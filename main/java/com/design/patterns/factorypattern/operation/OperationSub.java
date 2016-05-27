package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class OperationSub extends AbstractOperation {

    @Override
    public Double getResult() {
        return getParameterA() - getParameterB();
    }
}
