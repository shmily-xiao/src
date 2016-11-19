package com.design.patterns.commandpattern;

/**
 * Created by simpletour_Jenkin on 2016/11/17.
 *
 * 用来声明执行的操作的接口
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
