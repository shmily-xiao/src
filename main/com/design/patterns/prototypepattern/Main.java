package com.design.patterns.prototypepattern;

/**
 * Created by simpletour_Jenkin on 2016/7/21.
 */
public class Main {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype("1111");
        ConcretePrototype clone = (ConcretePrototype)prototype.Clone();
        clone.setId("2222");
        System.out.println("prototype ：" + prototype.getId());
        System.out.println("clone ：" + clone.getId());
    }
}

