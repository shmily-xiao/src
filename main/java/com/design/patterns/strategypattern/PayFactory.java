package com.design.patterns.strategypattern;

/**
 * Created by simpletour_Jenkin on 2016/5/30.
 */
public class PayFactory {
    public static Pay instantiated(SaleTypeEnum typeEnum){
//        SaleTypeEnum typeEnum = SaleTypeEnum.of(type);
        if (typeEnum == null) return null;
        Pay pay;
        if (SaleTypeEnum.normal.equals(typeEnum)){
            pay = new NormalPay();
        }else if (SaleTypeEnum.discount.equals(typeEnum)){
            pay = new SalePay();
        }else{
            pay = new FullCouponPay();
        }
        return pay;
    }
}
