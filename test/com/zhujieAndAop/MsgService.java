package com.zhujieAndAop;

import org.springframework.stereotype.Service;

@Service
public interface MsgService {

    /**
     *
     * @param msg
     * @param persons
     * @return
     */
    @TestA
    String sendMsg(String msg, Long... persons);

}
