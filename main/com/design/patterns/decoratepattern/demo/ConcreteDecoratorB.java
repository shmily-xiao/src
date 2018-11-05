package com.design.patterns.decoratepattern.demo;

/**
 * Created by simpletour_Jenkin on 2016/7/18.
 */
public class ConcreteDecoratorB extends Decorator {
    @Override
    public void Operation() {
        super.Operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void addedBehavior(){


    }
}
