package com.design.patterns.strategypattern.factory;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/5/30.
 */
public class FullCouponPay extends AbstractCorePay{
    @Override
    public Double computePrice(List<Goods> goodsList) {
        Double total =  super.corePay(goodsList);
        if (reduceMoney != null && total > sale){
            return total - reduceMoney;
        }else {
            return total;
        }
    }
}
