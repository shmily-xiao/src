package com.design.patterns.chain.of.responsibility;

/**
 * Created by simpletour_Jenkin on 2016/11/18.
 */
public class ConcreteHandler3 extends AbstractHandler{
    @Override
    public void handlerRequest(int request) {
        if (request >= 20 && request < 40){
            System.out.println(this.getClass().getName() + " 处理request " + request);
        }else if (successor != null){
            successor.handlerRequest(request);
        }
    }
}
