package com.design.patterns.factorypattern;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class Calculator {
    public static void main(String[] args){
        while (true) {
            System.out.println("please enter like '1 2 +' or '6 5 -'");
            System.out.println("please enter 'q' to quit");
            Scanner scanner = new Scanner(System.in);
            String data1 = scanner.next();
            if (data1.equals("q")) {
                System.out.println("I will go now!");
                break;
            }
            String data2 = scanner.next();
            String doThings = scanner.next();
            System.out.println(calculator(data1,data2, doThings));
        }
    }
    private static String calculator(String data1, String data2, String doThings){
        try{
            Long parameterA = Long.parseLong(data1);
            Long parameterB = Long.parseLong(data2);
            if ("+".equals(doThings)){
                return (parameterA + parameterB) + "";
            }else if ("-".equals(doThings)){
                return (parameterA - parameterB) + "";
            }else if ("/".equals(doThings) && parameterB != 0){
                return (parameterA / parameterB) + "";
            }else if ("*".equals(doThings)){
                return (parameterA * parameterB) + "";
            }else {
                return "your data is unavailable";
            }
        }catch (NumberFormatException e){
            return "your data is unavailable";
        }

    }

}
