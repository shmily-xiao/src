package com.thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by simpletour_Jenkin on 2016/11/11.
 */



public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Task> buffer = new LinkedBlockingQueue<>(Constants.MAX_BUFFER_SIZE);
        ExecutorService es = Executors.newFixedThreadPool(Constants.NUM_OF_CONSUMER + Constants.NUM_OF_PRODUCER);
        for(int i = 1; i <= Constants.NUM_OF_PRODUCER; ++i) {
            es.execute(new Producer2(buffer));
        }
        for(int i = 1; i <= Constants.NUM_OF_CONSUMER; ++i) {
            es.execute(new Consumer2(buffer));
        }
    }
}


/**
 * 消费者
 */
class Consumer2 implements Runnable{

    private BlockingQueue<Task> buffer;

    public Consumer2(BlockingQueue<Task> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            try {
                Task task = buffer.take();
                System.out.println("Consumer["+Thread.currentThread().getName()+"] got " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer2 implements Runnable{
    private BlockingQueue<Task> buffer;

    public Producer2(BlockingQueue<Task> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            try {
                Task task = new Task();
                buffer.put(task);
                System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


