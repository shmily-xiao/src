package com.design.patterns.chain.of.responsibility;

/**
 * Created by simpletour_Jenkin on 2016/11/18.
 */
public abstract class AbstractHandler implements Handler{

    // 这是类的下一个关联层级
    protected Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
