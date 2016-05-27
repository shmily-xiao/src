package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public abstract class AbstractOperation implements Operation {
    // 第一个参数
    protected Double parameterA;
    // 第二个参数
    protected Double parameterB;

    @Override
    public void initData(Double... doubles) {
        this.parameterA = doubles[0];
        this.parameterB = doubles[1];
    }


    public Double getParameterA() {
        return parameterA;
    }

    public void setParameterA(Double parameterA) {
        this.parameterA = parameterA;
    }

    public Double getParameterB() {
        return parameterB;
    }

    public void setParameterB(Double parameterB) {
        this.parameterB = parameterB;
    }
}
