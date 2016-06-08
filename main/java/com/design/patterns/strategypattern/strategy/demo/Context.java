package com.design.patterns.strategypattern.strategy.demo;

/**
 * Created by simpletour_Jenkin on 2016/6/2.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printAlgorithmInfo(){
        strategy.algorithm();
    }

    public static void main(String[] args){

        Context contextA = new Context(new AlgorithmA());
        contextA.printAlgorithmInfo();

        Context contextB = new Context(new AlgorithmB());
        contextB.printAlgorithmInfo();

        Context contextC = new Context(new AlgorithmC());
        contextC.printAlgorithmInfo();
    }

}
