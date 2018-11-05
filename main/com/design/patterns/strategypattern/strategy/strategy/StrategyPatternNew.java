package com.design.patterns.strategypattern.strategy.strategy;

import com.design.patterns.strategypattern.factory.Goods;
import com.design.patterns.strategypattern.factory.SaleTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/6/20.
 */
public class StrategyPatternNew {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        System.out.println("please enter 'q' to stop input,and enter 'r' to reset goods");
        int count = 0;
        while (true){
            count = count + 1;
            System.out.println("please enter " + count + " goods! like 'xxx 0.01 6'");
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
        System.out.println("/*****************************************************************/");
        printGoods(goodsList);
        System.out.println("/*****************************************************************/");
        System.out.println("Whether enjoying the activities,1.正常支付；2.折扣优惠；3.减满卷");
        System.out.println("please choose one and enter other values,something look like '1 0 0' or '2 0.8 0' or '3 200 100'");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        String sale = "";
        String reduceMoney = "";
        if (scanner.hasNext()){
            sale = scanner.next();
        }
        if (scanner.hasNext()){
            reduceMoney = scanner.next();
        }
        Context context = new Context(selectEnum(type,sale,reduceMoney));
        context.getPay().initData(sale,reduceMoney);
        System.out.println("if have no coupons, you should pay " + computePrice(goodsList));
        System.out.println("you should pay " + context.getPay().computePrice(goodsList));

    }

    private static SaleTypeEnum selectEnum(String type, String sale, String reduceMoney){
        if ("1".equals(type)){
            return SaleTypeEnum.normal;
        }
        if ("2".equals(type) && !sale.isEmpty() && !sale.equals("0") && validateData(sale)){
            return SaleTypeEnum.discount;
        }
        if ("3".equals(type) && !sale.isEmpty() && !reduceMoney.isEmpty()
                && !sale.equals("0") && !reduceMoney.equals("0") && validateData(sale,reduceMoney)){
            return SaleTypeEnum.fullcoupon;
        }

        return null;
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

    private static boolean validateData(String sale){
        try {
            Double tempSale = Double.valueOf(sale);
            if (0 < tempSale && tempSale <1) return true;
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
    private static boolean validateData(String sale, String reduceMoney){
        try {
            Integer tempSale = Integer.valueOf(sale);
            Integer tempReduceMoney= Integer.valueOf(reduceMoney);
            if (tempReduceMoney >0 && tempSale >0) return true;
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
