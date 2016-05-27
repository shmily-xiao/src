package com.design.patterns.strategypattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/5/27.
 */
public class StrategyPattern {

    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        int count = 0;
        while (true){
            count = count + 1;
            System.out.println("please enter " + count + " goods! like 'xxx 0.01 6'");
            System.out.println("please enter 'q' to stop input,and enter 'r' to reset goods");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if ("q".equals(name)) break;
            if ("r".equals(name)){
                count = 0;
                goodsList = new ArrayList<>();
            }
            String price = scanner.next();
            String numbers = scanner.next();
            try {
                Goods goods = new Goods(name,Double.valueOf(price)*Integer.valueOf(numbers));
                goodsList.add(goods);
            }catch (Exception e){
                System.out.println("your enter price is unavailable");
            }
        }
        printGoods(goodsList);
        System.out.println("you should pay " + computePrice(goodsList));

    }

    private static void printGoods(List<Goods> goodsList){
        System.out.println("your goods information is:");
        goodsList.forEach(goods -> System.out.println("name is "+goods.getName()+";price is " + goods.getPrice()));
    }

    private static Double computePrice(List<Goods> goodsList){
        Double totalPrice = Double.valueOf(0);
        for (Goods goods : goodsList) {
            totalPrice = totalPrice + goods.getPrice();
        }
        return totalPrice;
    }
}
