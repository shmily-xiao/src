package com.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * https://www.ibm.com/developerworks/cn/java/j-cf-of-jdk8/index.html
 */
public class MyFutureTest {

    /**
     * 获取前面两个future的结果，然后回调函数来完成某个动作
     *
     * thenCombine()被用来当两个独立的Future都完成的时候，用来做一些事情。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void test1() throws ExecutionException, InterruptedException {

        System.out.println("Retrieving weight.");
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 165.0;
        });

        System.out.println("Retrieving height.");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("2");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 1717.8;
        });

        System.out.println("Calculating BMI.");
        // 获得前面两个future 的结果然后传入下一个future的计算
        //  回调函数
        //(weightInKg, heightInCm) -> {
        //    Double heightInMeter = heightInCm/100;
        //    return weightInKg/(heightInMeter*heightInMeter);
        //}
        CompletableFuture<Double> combinedFuture = weightInKgFuture
            .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                Double heightInMeter = heightInCm/100;
                return weightInKg/(heightInMeter*heightInMeter);
            });

        System.out.println("Your BMI is - " + combinedFuture.get());
    }

    /**
     *  allof  获取之前所有future的结果
     *  一个列表的独立future，并且你想在它们都完成后并行的做一些事情
     *
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void test2() throws ExecutionException, InterruptedException {

        String[] words = new String[]{"1","4","3","4"};

        // A list of 100 web page links
        List<String> webPageLinks = Arrays.asList(words);

        // Download contents of all the web pages asynchronously
        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
            .map(webPageLink -> this.randomSleep(webPageLink, Integer.parseInt(webPageLink)))
            .collect(Collectors.toList());


        // Create a combined Future using allOf()
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
            pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
        );

        // 我们需要调用 join()方法等待后一个方法结束后再合成字符串，
        // 这一点和线程的 join()方法是一致的，主线程生成并起动了子线程，
        // 如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
        // 但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，
        // 也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到 join()方法了，
        // 即 join()的作用是："等待该线程终止"。
        // When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream()
                .map(pageContentFuture -> pageContentFuture.join())
                .collect(Collectors.toList());
        });

        System.out.println(allFutures.toString());

        // Count the number of web pages having the "CompletableFuture" keyword.
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            System.out.println(pageContents);
            return pageContents.stream()
                .filter(pageContent -> pageContent.contains("CompletableFuture"))
                .count();
            // 异常会走这个逻辑，handler的话，相当于finally 无论怎么样都会走
        }).exceptionally(ex -> {
            System.out.println("unknown");
            return null;
        });

        System.out.println("Number of Web Pages having CompletableFuture keyword - " +
            countFuture.get());

    }

    /**
     * 使用固定的线程池完成异步执行动作示例
     *
     */
    public void test3(){
        ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
            int count = 1;
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "custom-executor-" + count++);
            }
        });


        CompletableFuture<String>cf = CompletableFuture.completedFuture("message")
            .thenApplyAsync(s -> {
                System.out.println(Thread.currentThread().getName().startsWith("custom-executor-"));
                System.out.println(Thread.currentThread().isDaemon());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return s.toUpperCase();
                }
                , executor);
        System.out.println(cf.getNow(null));
        System.out.println("MESSAGE = : " + cf.join());


        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
            .thenAccept(s ->result.append(s));

        // 和 thenAccept 比， thenAcceptAsync会新开启一个线程去执行任务
        //CompletableFuture.completedFuture("thenAccept message")
        //    .thenAcceptAsync(s ->result.append(s));


        System.out.println(result.toString());
        System.out.println("Result was empty: " + (result.length() > 0));

    }

    /**
     * 程序两个阶段执行完毕后返回结果，首先将字符转为大写，然后将字符转为小写，在两个计算阶段都结束之后触发 CompletableFuture。
     *
     * thenCompose()被用于当一个future依赖另外一个future的时候用来组合两个future。
     * thenCombine()被用来当两个独立的Future都完成的时候，用来做一些事情。
     */
    public void test4(){
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original)
            .thenApply(String::toUpperCase)
            .runAfterBoth(CompletableFuture.completedFuture(original).thenApply(String::toLowerCase), () -> result.append("done\n -"));
        System.out.println(result);

        CompletableFuture.completedFuture(original)
            .thenApply(String::toUpperCase)
            .thenAcceptBoth(CompletableFuture.completedFuture(original).thenApply(String::toLowerCase), (t1, t2) -> result.append(t1 + t2));

        System.out.println(result);


    }


    CompletableFuture<String> randomSleep(String pageLink, int sleepTime) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(pageLink+"  yo!");
            return pageLink;
            // Code to download and return the web page's content
        });


    }


    public static void main(String[] args) {
        try {
            MyFutureTest test = new MyFutureTest();
            //test.test1();
            //test.test2();
            //test.test3();
            test.test4();


        }catch (Exception e){
            System.out.print("//");
        }

    }
}
