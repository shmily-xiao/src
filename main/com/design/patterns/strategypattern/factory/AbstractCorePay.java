package com.design.patterns.strategypattern.factory;


import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public abstract class AbstractCorePay implements Pay{
    /**
     * 折扣 或者是 减满的阀值
     */
    protected Double sale = Double.valueOf(1);

    /**
     * 优惠的类型
     */
    protected SaleTypeEnum type = SaleTypeEnum.normal;

    /**
     * 只用于减满券
     */
    protected Double reduceMoney;

    @Override
    public void initData(Object ...value) {
//        this.type = (SaleTypeEnum) value[0];
        this.sale = Double.valueOf(value[0] + "");
        if (value[1] != null){
            this.reduceMoney = Double.valueOf(value[1] + "");
        }
    }

    protected Double corePay(List<Goods> goodsList){
        Double totalFee = Double.valueOf(0);
        for (Goods goods : goodsList){
            totalFee = totalFee + goods.getPrice();
        }
        return totalFee;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public SaleTypeEnum getType() {
        return type;
    }

    public void setType(SaleTypeEnum type) {
        this.type = type;
    }

    public Double getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(Double reduceMoney) {
        this.reduceMoney = reduceMoney;
    }
}
