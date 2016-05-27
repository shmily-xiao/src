package com.design.patterns.strategypattern;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public interface Pay {
    Double computePrice(List<Goods> goodsList);
}
