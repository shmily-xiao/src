package com.design.patterns.prototypepattern;

/**
 * Created by simpletour_Jenkin on 2016/7/21.
 */
public abstract class Prototype implements Cloneable{
    private String id;

    public Prototype() {
    }

    public Prototype(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // 抽象类中的一个Clone方法
    public abstract Prototype Clone();
}
