package com.design.patterns.decoratepattern.demo;

/**
 * Created by simpletour_Jenkin on 2016/7/18.
 */
public class ConcreteComponent extends Component{
    @Override
    public void Operation() {
        System.out.println("具体对象的操作");
    }
}
