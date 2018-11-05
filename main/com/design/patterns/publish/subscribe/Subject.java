package com.design.patterns.publish.subscribe;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 *
 * 通知者的接口
 */
public interface Subject {
    /**
     * 添加
     * @param observer 我要我要通知的对象，通知谁
     */
    void attach(Observer observer);


    /**
     * 减少
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知
     */
    void notifyObserver();

    /**
     * 设置通知者的状态
     */
    void setSubjectStatus(String status);

    /**
     * 设置通知者的状态
     * @return
     */
    String getSubjectStatus();
}
