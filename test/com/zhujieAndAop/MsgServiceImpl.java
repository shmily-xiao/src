package com.zhujieAndAop;

public class MsgServiceImpl implements MsgService {

    @Override
    public String sendMsg(String msg, Long... persons) {

        for(Long person: persons){
            System.out.println(person);
        }

        System.out.println(msg);

        return msg;
    }
}
