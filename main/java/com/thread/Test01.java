package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simpletour_Jenkin on 2016/11/2.
 *
 * 1.第一种在run方法调用 存取的方法的时候调用 synchronized (account) { 需要锁住的代码 }  (account 是对象，锁对象)
 *
 * 2.在存取的方法上添加关键字 synchronized  （锁方法）
 *
 * 3.在需要锁住的类里面添加显示的添加锁 如： （锁代码）
 *   // 显示的锁机制，为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作
 *    private Lock accountLock = new ReentrantLock();
 *
 *    accountLock.lock();
 *    try{
 *        需要锁住的代码逻辑
 *    }finally{
 *        accountLock.unlock();
 *    }
 *
 *
 *  总结：这三种方法锁住的区域一个比一个具体，范围一个比一个小
 *  这应该是一个取舍，是拆分成小锁，还是一个大锁解决所有的问题
 */
public class Test01 {
    public static void main(String[] args) {
        Account account = new Account();

        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i=0; i<1000;i++){
            service.execute(new AddMoneyThread(account,1));
        }

        service.shutdown();
        while(!service.isTerminated()){}

        System.out.println("账户金额：" + account.getBalance());

    }
}
