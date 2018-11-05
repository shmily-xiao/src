package com.design.patterns.iteratorpattern;

/**
 * Created by simpletour_Jenkin on 2016/11/16.
 *
 * 集合，要迭代的集合
 *
 */
public interface Aggregate {

    Iterator createIterator();
}
