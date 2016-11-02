package com.thread;

/**
 * Created by simpletour_Jenkin on 2016/11/2.
 */
public class AddMoneyThread implements Runnable{


    /**
     * 存入的账号
     */
    private Account account;


    /**
     * 存入金额
     */
    private double money;

    public AddMoneyThread() {
    }

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (account) {
            account.deposit(money);
        }
    }
}
