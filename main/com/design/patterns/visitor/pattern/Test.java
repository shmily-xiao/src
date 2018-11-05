package com.design.patterns.visitor.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class Test {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        // 添加元素
        // 这个元素要告诉访问者调用访问者的哪一个方法才能访问到自己，
        // 然后具体的访问者调用相应的方法来完成想要访问的元素的内容
        objectStructure.attach(new ConcreteElementA());
        objectStructure.attach(new ConcreteElementB());

        // 具体的访问者
        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        // 通过第三方的调节，v1间接访问了A元素，因为在concreteElementA中实现accept只访问了访问者v1中的A方法
        objectStructure.accept(v1);
        objectStructure.accept(v2);
    }
}
