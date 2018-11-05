package com.design.patterns.strategypattern.factory;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public class Goods {

    private String name;

    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
