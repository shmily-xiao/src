package com.design.patterns.visitor.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        // 告诉这个访问者这个方法只会访问元素A
        visitor.visitConcreteElementA(this);
    }

    public void operationA(){}
}
