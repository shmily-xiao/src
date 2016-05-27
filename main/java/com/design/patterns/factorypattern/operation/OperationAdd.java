package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class OperationAdd extends AbstractOperation{

    @Override
    public Double getResult() {
        return this.parameterA + this.parameterB;
    }
}
