package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class OperationDivision extends AbstractOperation {

    @Override
    public Double getResult() {
        if (getParameterB() == 0) throw new NumberFormatException("除数不能为0");
        return getParameterA() / getParameterB();
    }
}
