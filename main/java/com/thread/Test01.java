package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simpletour_Jenkin on 2016/11/2.
 */
public class Test01 {
    public static void main(String[] args) {
        Account account = new Account();

        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i=0; i<100;i++){
            service.execute(new AddMoneyThread(account,1));
        }

        service.shutdown();
        while(!service.isTerminated()){}

        System.out.println("账户金额：" + account.getBalance());

    }
}
