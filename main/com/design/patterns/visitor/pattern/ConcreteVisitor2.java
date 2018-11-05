package com.design.patterns.visitor.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class ConcreteVisitor2 implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() +" 被 "+this.getClass().getName() + "访问了");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {

        System.out.println(concreteElementB.getClass().getName() +" 被 "+this.getClass().getName() + "访问了");

    }
}
