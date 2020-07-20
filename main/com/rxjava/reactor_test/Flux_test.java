package com.rxjava.reactor_test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.string.TestJsonString;
import jdk.dynalink.beans.StaticClass;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.awt.desktop.ScreenSleepEvent;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Flux_test {
    public static void main(String[] args) throws Exception{

        Flux<String> just = Flux.just("foo", "bar", "foobar");

        List<String> strings = Arrays.asList("foo", "bar", "foobar");
        Flux<String> stringFlux = Flux.fromIterable(strings);

        just.subscribe(i -> System.out.println(i));

        System.out.println("--");

        Flux<Integer> integerFlux = Flux.range(1, 20)
            .map(i -> {
                if (i <= 3) { return i;}
                //throw new RuntimeException("Got to 4");
                return i;
            });

        //integerFlux.subscribe(i -> System.out.println(i), error -> {
        //    System.err.println("Error" + error);
        //    //throw new RuntimeException(error);
        //});

        System.out.println("----");

        integerFlux.subscribe(i -> System.out.println(i),
            error -> System.err.println("Error" + error),
            () -> System.out.println("Done"),
            sub -> sub.request(10)
        );
        System.out.println("----");

        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        //integerFlux.subscribe(ss);

        Flux.generate(
            () -> 0,
            (state, sink) -> {
                sink.next("3 x" + state + " = " + 3*state);
                if (state == 10) {sink.complete();}
                return state + 1;
            }).subscribe( i -> System.out.println(i));

        Flux<Object> generate = Flux.generate(
            AtomicLong::new,
            (state, sink) -> {
                long i = state.getAndIncrement();
                sink.next("3 X " + i + " = " + 3 * i);
                if (i == 10) {sink.complete();}
                return state;
            }
        );
        generate.subscribe(i -> System.out.println(i));

        Flux.generate(
            AtomicLong::new,
            (state, sink) -> {
                long i = state.getAndIncrement();
                sink.next("3 X " + i + " = " + 3 * i);
                if (i == 10) {sink.complete();}
                return state;
            },
            (state) -> System.out.println("state = " + state)
        ).subscribe(i -> System.out.println(i));

        System.out.println("------");

        Flux<String> handle = Flux.just(-1, 30, 13, 9, 20)
            .handle((i, sink) -> {
                String letter = alphabet(i);
                if (letter != null) {sink.next(letter);}
            });
        handle.subscribe(System.out::println);


        final Mono<String> mono = Mono.just("hello ");
        new Thread(() -> mono
        .map(msg -> msg + " thread ")
            .map( msg -> msg + " @@@@@ " + Thread.currentThread().getName() + " | ")
        .subscribe(v -> System.out.println(v + Thread.currentThread().getName()))
        ).start();

        // 一直循环的答应数据子
        //Flux.interval(Duration.ofMillis(1000), Schedulers.newParallel("test")).subscribe(System.out::println);

        Scheduler scheduler = Schedulers.newParallel("parallel - scheduler", 4);
        final Flux<String> flux = Flux
            .range(1,9)
            .map(i -> 10+i + " ** " + Thread.currentThread().getName() + "***")
            .subscribeOn(scheduler)
            //.publishOn(scheduler)
            .map(i -> "value "+i + " -- " + Thread.currentThread().getName());

        new Thread(() -> flux.subscribe(System.out::println));

        Flux.just(1, 2, 0)
            .map(i -> "Wow : " +  100 /i )
            .onErrorReturn("DIvided by zero : (")
            .subscribe(System.out::println);

        Flux.<String>error(new IllegalArgumentException())
            .doOnError(System.out::println)
            .retryWhen(companion -> companion.zipWith(
                Flux.range(1, 4),
                (error, index) -> {
                    if (index < 3) {return index;}
                    else {throw Exceptions.propagate(error);}
                }
            ))
            .subscribe(System.out::println);
        StringBuilder sb =new StringBuilder();
        Set<String> strings1 = Set.of("22", "11", "333");
        Flux.just(strings1.toArray()).reduce((a,b)-> a+","+b).subscribe( item -> sb.append(item));
        System.out.println(sb.toString());



        String jsonString = "{\"a\":\"qdcscs\",\"b\":3, \"c\":\"233\"}";
        //TestJsonString testJsonString = JSONObject.parseObject(jsonString, TestJsonString.class);
        //System.out.println(testJsonString);
        Mono.just(jsonString)
            .map(item -> JSONObject.parseObject(jsonString, TestJsonString.class))
            .subscribe(item -> System.out.println(item));



        // 去掉 ctx.get(key) 之后就只打印 Hello，因为执行顺序的原因
        // 如果把 subscriberContext(ctx -> ctx.put(key, "World")) 放在flatMap之前会报Context is empty
        // The numbering above vs the actual line order is not a mistake: it represents the execution order.
        // Even though subscriberContext is the last piece of the chain, it is the one that gets executed first
        // (due to its subscription time nature, and the fact that the subscription signal flows from bottom to top).
        // 从下往上执行
        String key = "message";
        Mono.just("Hello")
            // 2
            .flatMap(s -> Mono.subscriberContext()
                // 3
                .map(ctx -> s + " " + ctx.get(key)))
            // 1
            .subscriberContext(ctx -> ctx.put(key, "World"))
            .subscribe(System.out::println);

        // 输出 "Default"
        Mono.subscriberContext()
            .map(ctx -> ctx.put(key, "Hello"))
            .flatMap(ctx -> Mono.subscriberContext())
            .map(ctx -> ctx.getOrDefault(key, "Default"))
            .subscribe(System.out::println);

        // $$Context0{}
        // @@Context1{message=World}
        // Hello Reactor
        Mono.just("Hello")
            .flatMap( s -> Mono.subscriberContext()
                .map( ctx -> s + " " + ctx.get(key)))
            .subscriberContext(ctx -> {
                System.out.println("@@" + ctx.toString());
                return ctx.put(key, "Reactor");
            })
            .subscriberContext(ctx -> {
                System.out.println("$$" + ctx.toString());
                return ctx.put(key, "World");
            }).subscribe(System.out::println);


        // ++
        // ==
        // @@
        // ##
        // 输出 Hello 1 Reactor 2 World
        Mono.just("Hello")
            .flatMap( s -> Mono.subscriberContext()
                // 3
                .map( ctx -> {
                    System.out.println("@@");
                    return s + " 1 " + ctx.get(key);
                }))
            // 2
            .subscriberContext(ctx -> {
                System.out.println(" == ");
                return ctx.put(key, "Reactor");
            })
            .flatMap( s -> Mono.subscriberContext()
                // 4
                .map( ctx -> {
                    System.out.println("##");
                    return s + " 2 " + ctx.get(key);
                }))
            // 1
            .subscriberContext(ctx -> {
                System.out.println(" ++ ");
                return ctx.put(key, "World");
            })
            .subscribe(System.out::println);

        // 1111
        // Hello World**
        // 3333
        // 2222
        // Hello World Reactor00
        // Hello World Reactor
        Mono.just("Hello")
            .flatMap( s -> Mono.subscriberContext()
                .map( ctx -> {
                    System.out.println("1111");
                    return s + " " + ctx.get(key);
                })
            ).doOnNext(s -> System.out.println(s + "**"))
            .flatMap( s -> Mono.subscriberContext()
                .map( ctx -> {
                    System.out.println("2222");
                    return s + " " + ctx.get(key);
                })
                .subscriberContext(ctx -> {
                    System.out.println("3333");
                    return ctx.put(key, "Reactor");
                })
            ).doOnNext(s -> System.out.println(s + "00"))
            .subscriberContext(ctx -> ctx.put(key, "World"))
            .subscribe(System.out::println);

        /**
         * {1=44}
         * {1=44, 2=44}
         * {1=44, 2=44, 3=44}
         * {1=44, 2=44, 3=44, 4=44}
         * {1=44, 2=44, 3=44, 4=44, 5=44}
         * iiii
         */
        Map<Integer, String> resultMap = new HashMap<>(5);
        Flux.just(1,2,3,4,5)
            .map(item -> {
                resultMap.put(item, "44");
                return resultMap;
            }).doOnComplete(()-> System.out.println("iiii")).subscribe(item -> System.out.println(item));


        // 测试多线程的能力
        //List<Mono<String>> monos = new ArrayList<>();
        //Flux.range(0, 5)
        //    .flatMap(item -> Mono.fromCallable(() -> testMono(item)).publishOn(Schedulers.newParallel("mono_test", 5)))
        //    .collectList()
        //    .subscribe(item -> System.out.println(item));

        System.out.println("------------");
        // 无限序列
        Page page = new Page();
        page.page = 1;
        page.size = 2;
        Flux.generate(ArrayList::new, (list, sink) -> {
                List<String> byPage = findByPage(page.page, page.size);
                list.addAll(byPage);
                sink.next(byPage);
                if (byPage.size() != page.size) {
                    sink.complete();
                }
                page.page += 1;
                System.out.println("--2000--"+byPage);
                return list;
            })
            .map(item -> {
                System.out.println("--1000--"+item);
                return item;
            })
            .collectList()
            .block();

        //System.out.println(block);

        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        Flux.interval(Duration.ofMillis(100)).buffer(Duration.ofMillis(1001)).take(2).toStream().forEach(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        Flux.range(1, 100).window(20).subscribe(System.out::println);

        Flux.just("a", "b")
            .zipWith(Flux.just("c", "d"))
            .subscribe(System.out::println);
        Flux.just("a", "b")
            .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
            .subscribe(System.out::println);


        Mono.just("U")
            .delayElement(Duration.ofSeconds(1))
            .filter(item -> "T".equals(item))
            .switchIfEmpty(Mono.just("U1"))
            .subscribe(System.out::println);

        Flux.just("U")
            .log()
            .filter(item -> "T".equals(item))
            .switchIfEmpty(Mono.just("U2"))
            .single()
            .doOnSuccess(System.out::println)
            .block();

        System.out.println("TT");




    }

    private static List<String> findByPage(int page, int size){
        List<String> ss = new ArrayList<>(size);
        if (page == 4){
            size = 1;
        }
        for (int i=0; i <size; i++){
            ss.add(page + "---"+i);
        }
        //System.out.println(ss);
        return ss;
    }

    private static String testMono(int number) throws Exception{
        System.out.println(">>>" + number + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + number + "任务终止");
        return number + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }

    public static String alphabet(int letterNumber){
        if (letterNumber <1 || letterNumber > 26){
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }

}
class Page{
    int page = 1;
    int size = 10;
}




