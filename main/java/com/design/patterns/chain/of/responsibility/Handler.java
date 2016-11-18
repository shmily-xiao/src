package com.design.patterns.chain.of.responsibility;

/**
 * Created by simpletour_Jenkin on 2016/11/18.
 */
public interface Handler {
    void setSuccessor(Handler successor);

    void handlerRequest(int request);
}
