package com.design.patterns.factorypattern.operation;

/**
 * Created by simpletour_Jenkin on 2016/5/26.
 */
public enum OperationEnum {
    add("+",new OperationAdd()),
    sub("-",new OperationSub()),
    division("/",new OperationDivision()),
    multiplication("*",new OperationMultiplication());

    OperationEnum() {
    }

    OperationEnum(String operationName, Operation operation) {
        this.operationName = operationName;
        this.operation = operation;
    }

    public String operationName;

    public Operation operation;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public static OperationEnum of(String operationName){
        for (OperationEnum operationEnum : OperationEnum.values()){
            if (operationEnum.getOperationName().equals(operationName)) return operationEnum;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(OperationEnum.of("/").name());
    }
}
