package com.thread;

import org.apache.http.client.fluent.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simpletour_Jenkin on 2016/11/10.
 */
public class CopyOnWriteArrayListTest  implements Runnable{
    private List<Double> list;

    public CopyOnWriteArrayListTest() {
    }

    public CopyOnWriteArrayListTest(List<Double> list) {
        this.list = list;
    }


    @Override
    public void run() {
        for (int i = 0; i<100000; i++){
            list.add(Math.random());
        }
    }
}


class Test{
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
//        List<Double> list = new ArrayList<>(); //非线程安全的方法
        List<Double> list = new CopyOnWriteArrayList<>(); // 线程安全的方法,但是效率不高，时间的开销大

        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new CopyOnWriteArrayListTest(list));
        es.execute(new CopyOnWriteArrayListTest(list));
        es.shutdown();
    }
}