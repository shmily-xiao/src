package com.design.patterns.commandparttern;

/**
 *
 * Created by simpletour_Jenkin on 2016/11/17.
 *
 * 将一个接收者对象绑定一个动作，调用接收者相应的操作，以实现execute
 *
 *
 */
public class ConcreteCommand extends Command{

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
