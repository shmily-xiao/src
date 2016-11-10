package com.thread;

/**
 * Created by simpletour_Jenkin on 2016/11/10.
 */

import java.util.concurrent.CountDownLatch;

/**
 *
 * 工人
 */
public class Worker {
    // 名字
    private String name;

    // 工作持续时间
    private Long workDuration;

    public Worker(){}

    public Worker(String name, Long workDuration){
        this.name = name;
        this.workDuration = workDuration;
    }

    public void doWork(){
        System.out.println(name + "begins to work ...");

        try{
            Thread.sleep(workDuration); // 用休眠模拟工作执行的时间
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(name + "has finished the job...");
    }

}

class WorkerTestThread implements Runnable{
    private Worker worker;
    private CountDownLatch cdLatch;

    public WorkerTestThread() {
    }

    public WorkerTestThread(Worker worker,CountDownLatch cdLatch) {
        this.cdLatch = cdLatch;
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.doWork();  //让工人开始工作
        cdLatch.countDown(); //工作完成后倒计时次数减1
    }
}

class CountDownLatchTest{
    // 最大的工作时间
    private static final int MAX_WORK_DURATION = 5000;
    // 最小的工作时间
    private static final int MIN_WORK_DURATION = 1000;

    private static long getRandomWorkDuration(long min, long max){
        return (long) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(2); // 2 是线程数量
        Worker w1 = new Worker("aa ",getRandomWorkDuration(MIN_WORK_DURATION,MAX_WORK_DURATION));
        Worker w2 = new Worker("bb ",getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));

        new Thread(new WorkerTestThread(w1,latch)).start();
        new Thread(new WorkerTestThread(w2,latch)).start();

        try{
            latch.await(); // 等待倒计时闩减到0
            System.out.println("All jobs have been finished!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
