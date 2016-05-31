package com.design.patterns.strategypattern;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/5/30.
 */
public class SalePay extends AbstractCorePay{

    @Override
    public Double computePrice(List<Goods> goodsList) {
        return super.corePay(goodsList) * this.sale;
    }
}
