package com.design.patterns.visitor.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    public void operationB(){}
}
