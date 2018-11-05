package com.design.patterns.iteratorpattern;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/11/16.
 *
 * 这个迭代器的具体实现
 */
public class MyIteratorImpl implements Iterator{

    private MyAggregateImpl aggregate;

    private int currentCount = 0;

    public MyIteratorImpl() {
    }

    public MyIteratorImpl(MyAggregateImpl aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object currentItem() {
        return aggregate.getItem(currentCount);
    }

    @Override
    public Object first() {
        return aggregate.getItem(0);
    }

    @Override
    public Object next() {
        currentCount++;
        return isDone()?null:aggregate.getItem(currentCount);
    }

    @Override
    public boolean isDone() {
        return currentCount >= aggregate.getCount();
    }
}
