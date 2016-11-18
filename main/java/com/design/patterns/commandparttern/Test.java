package com.design.patterns.commandparttern;

/**
 * Created by simpletour_Jenkin on 2016/11/17.
 */
public class Test {
    public static void main(String[] args) {
        //
        Receiver receiver = new Receiver();

        Command command = new ConcreteCommand(receiver); // 创建一个命令但是不一定要立即执行

        Invoker invoker = new Invoker();

        invoker.setCommand(command); // 添加命名
        invoker.executeCommand();  // 执行命令

    }
}
