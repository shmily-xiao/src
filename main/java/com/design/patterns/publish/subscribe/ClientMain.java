package com.design.patterns.publish.subscribe;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 */
public class ClientMain {
    public static void main(String[] args) {
        // 老板
        Boss boss = new Boss();

        // 具体的订阅者
        StockObserver stockObserver =  new StockObserver("订阅1号",boss);

        NBAObserver nbaObserver = new NBAObserver("订阅者2号",boss);

        // 添加订阅者
        boss.attach(stockObserver);
        boss.attach(nbaObserver);


        // 有人说我不相信你的通知了，然后选择退出，于是服务器删掉了这个订阅者
        boss.detach(nbaObserver);

        // 老板的状态变动
        boss.setSubjectStatus("各单位注意，逗比开始了");

        // 于是服务器告诉了所有的订阅者
        boss.notifyObserver();

    }
}
