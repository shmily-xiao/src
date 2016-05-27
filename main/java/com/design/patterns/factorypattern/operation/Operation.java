package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public interface Operation {

    void initData(Double ... doubles);

    Double getResult();
}
