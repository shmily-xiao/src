package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public class OperationFactory {

    public static Operation instantiation(String operation){
        Operation operationTemp = null;
//        if ("+".equals(operation)){
//            operationTemp = new OperationAdd();
//        }else if ("-".equals(operation)){
//            operationTemp = new OperationSub();
//        }else if ("/".equals(operation)){
//            operationTemp = new OperationDivision();
//        }else if ("*".equals(operation)){
//            operationTemp = new OperationMultiplication();
//        }
        operationTemp = OperationEnum.of(operation).getOperation();
        return operationTemp;
    }
}
