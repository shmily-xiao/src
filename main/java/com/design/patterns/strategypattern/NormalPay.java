package com.design.patterns.strategypattern;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public class NormalPay extends AbstractCorePay {

    @Override
    public Double computePrice(List<Goods> goodsList) {
        return super.corePay(goodsList);
    }

}
