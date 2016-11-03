package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by simpletour_Jenkin on 2016/11/2.
 * http://blog.csdn.net/jackfrued/article/details/44921941
 * 60
 */
public class Account {

    // 显示的锁机制，为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作
    private Lock accountLock = new ReentrantLock();

    private double balance;     // 账户余额

    /**
     * 存款
     * @param money 存入金额
     */
    public synchronized void deposit(double money) {
//        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10);   // 模拟此业务需要一段处理时间
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        }finally {
//            accountLock.unlock();
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }
}