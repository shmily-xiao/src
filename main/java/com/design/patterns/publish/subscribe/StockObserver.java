package com.design.patterns.publish.subscribe;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 *
 * 被通知的人，订阅者
 *
 */
public class StockObserver extends Observer{

    public StockObserver(String name, Subject sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getSubjectStatus() + "," + name +"该干啥干啥");
    }
}
