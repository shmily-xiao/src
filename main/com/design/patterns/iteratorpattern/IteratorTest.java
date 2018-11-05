package com.design.patterns.iteratorpattern;

/**
 * Created by simpletour_Jenkin on 2016/11/16.
 */
public class IteratorTest {
    public static void main(String[] args) {
        MyAggregateImpl aggregate = new MyAggregateImpl();
        aggregate.setItem(0,"aaa");
        aggregate.setItem(1,"bbb");
        aggregate.setItem(2,"ccc");
        aggregate.setItem(3,"ddd");

        Iterator iterator = new MyIteratorImpl(aggregate);
        while(!iterator.isDone()){
            System.out.println(iterator.currentItem() + " please go out!");
            iterator.next();
        }
    }
}
