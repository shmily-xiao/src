package com.design.patterns.decoratepattern.demo;

/**
 * Created by simpletour_Jenkin on 2016/7/18.
 */
public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        // 一层层的修饰
        d1.setComponent(c);
        d2.setComponent(d1);
        d2.Operation();
    }
}
