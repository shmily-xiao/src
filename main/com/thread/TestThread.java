package com.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author wangzaijun
 * @date 2020/04/28
 */

@SuppressWarnings("unchecked")
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        System.out.println("----程序开始运行----");
        Long time1 = System.currentTimeMillis();

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Long time2 = System.currentTimeMillis();
        System.out.println("----程序结束运行----，程序运行时间【"
            + (time2 - time1) + "毫秒】");

        List<CompletableFuture<String>> futures = new ArrayList<>();
        for (int i = 0; i < taskSize; i++){
            MyCallable c = new MyCallable(i + " ");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
                try {
                    return (String)c.call();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return "";
            });
            futures.add(future);
        }
        List<String> collect = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());


    }
}

class MyCallable implements Callable<Object> {
    private String taskNum;

    public MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }

}

