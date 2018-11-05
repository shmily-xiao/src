package com.design.patterns.strategypattern.strategy.strategy;

import com.design.patterns.strategypattern.factory.*;

/**
 * Created by simpletour_Jenkin on 2016/6/20.
 */
public class Context {
    private Pay pay;

    public Context(){}

    public Context(SaleTypeEnum typeEnum){
        if (SaleTypeEnum.normal.equals(typeEnum)){
            pay = new NormalPay();
        }else if (SaleTypeEnum.discount.equals(typeEnum)){
            pay = new SalePay();
        }else{
            pay = new FullCouponPay();
        }
    }
    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

}
