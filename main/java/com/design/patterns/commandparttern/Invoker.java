package com.design.patterns.commandparttern;

/**
 * Created by simpletour_Jenkin on 2016/11/17.
 *
 * 要求该命令执行这个请求
 *
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
