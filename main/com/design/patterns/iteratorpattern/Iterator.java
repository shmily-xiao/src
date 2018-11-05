package com.design.patterns.iteratorpattern;

/**
 * Created by simpletour_Jenkin on 2016/11/16.
 *
 * 自己实现迭代器模式
 */
public interface Iterator {

    Object first();

    Object next();

    boolean isDone();

    Object currentItem();
}
