package com.design.patterns.factorypattern;

import com.design.patterns.factorypattern.operation.*;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class Calculator2 {
    // 第一个参数
    private String parameterA;
    // 第二个参数
    private String parameterB;
    // 操作
    private String operation;

    public Calculator2() {
    }

    public Calculator2(String parameterA, String parameterB, String operation) {
        this.parameterA = parameterA;
        this.parameterB = parameterB;
        this.operation = operation;
    }

    public String getParameterA() {
        return parameterA;
    }

    public void setParameterA(String parameterA) {
        this.parameterA = parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }

    public void setParameterB(String parameterB) {
        this.parameterB = parameterB;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    private String calculator(){
        try{

            Double parameterA = Double.parseDouble(this.parameterA);
            Double parameterB = Double.parseDouble(this.parameterB);
            Operation operation = OperationFactory.instantiation(this.operation);
            operation.initData(parameterA, parameterB);
            return operation.getResult().toString();
        }catch (Exception e){
            return "your data is unavailable";
        }
    }

    public static void main(String[] args) {
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
            Calculator2 calculator2 = new Calculator2(data1,data2,doThings);
            System.out.println("the answer is : "+calculator2.calculator());
        }
    }

}
