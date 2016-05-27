package com.demo.domain;

import java.sql.Timestamp;

/**
 * Created by simpletour_java on 2015/5/21.
 */
public class Detail {
    private int detailId;                //内容的自增id
    private String sendPersonId;  //发送人的id
    private String sendPersonName;//发送人的名字
    private String acceptPersonId;  //接收人的id
    private String acceptPersonName; //接收人的名字
    private String information;  //发送的内容
    private int followId;       //这是为了追溯是回复的哪一条记录
    private Timestamp sendTime;  //发送的时间
    private boolean isSend;
    private String theme;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    private User user; //这和user是一个一对一的关系，一条记录只会有一条user里面的记录与其匹配

    public boolean isSend() {
        return isSend;
    }

    public void setIsSend(boolean isSend) {
        this.isSend = isSend;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getSendPersonId() {
        return sendPersonId;
    }

    public void setSendPersonId(String sendPersonId) {
        this.sendPersonId = sendPersonId;
    }

    public String getSendPersonName() {
        return sendPersonName;
    }

    public void setSendPersonName(String sendPersonName) {
        this.sendPersonName = sendPersonName;
    }

    public String getAcceptPersonId() {
        return acceptPersonId;
    }

    public void setAcceptPersonId(String acceptPersonId) {
        this.acceptPersonId = acceptPersonId;
    }

    public String getAcceptPersonName() {
        return acceptPersonName;
    }

    public void setAcceptPersonName(String acceptPersonName) {
        this.acceptPersonName = acceptPersonName;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp semdTime) {
        this.sendTime = semdTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
