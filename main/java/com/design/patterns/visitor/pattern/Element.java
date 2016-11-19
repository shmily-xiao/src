package com.design.patterns.visitor.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 *
 * 定义一个Accept操作，他以一个访问者为参数
 *
 */
public interface Element {

    void accept(Visitor visitor);

}
