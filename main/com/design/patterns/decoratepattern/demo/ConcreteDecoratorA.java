package com.design.patterns.decoratepattern.demo;

/**
 * Created by simpletour_Jenkin on 2016/7/18.
 */
public class ConcreteDecoratorA extends Decorator{
    private String addedState;

    @Override
    public void Operation() {
        super.Operation();
        this.addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }
}
