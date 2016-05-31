package com.design.patterns.strategypattern;

/**
 * Created by simpletour_Jenkin on 2016/5/30.
 */
public enum SaleTypeEnum {
    normal("没有优惠",1.0),
    discount("折扣优惠"),
    fullcoupon("满减劵");
//    fullcoupon("满减劵",300.0,100.0);

    private String value;
    private Double sale;
    private Double reduceMoney;

    SaleTypeEnum(String value){
        this.value = value;
    }

    SaleTypeEnum(String value, Double sale){
        this.value = value;
        this.sale = sale;
    }
    SaleTypeEnum(String value, Double sale, Double reduceMoney){
        this.value = value;
        this.sale = sale;
        this.reduceMoney = reduceMoney;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }


}
