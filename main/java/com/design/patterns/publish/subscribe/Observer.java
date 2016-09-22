package com.design.patterns.publish.subscribe;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 *
 * 抽象的观察者
 *
 */
public abstract class Observer {

    /**
     * 名字
     */
    protected String name;

    /**
     * 通知者 ，告诉自己我应该听谁的才是正确的，被谁通知
     */
    protected Subject sub;

    /**
     * 提示的内容，由子类自己创建内容
     */
    public abstract void update();


    public Observer() {
    }

    public Observer(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }
}
