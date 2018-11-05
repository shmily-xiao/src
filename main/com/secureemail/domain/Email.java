package com.secureemail.domain;

import java.sql.Timestamp;

/**
 * Created by simpletour_Jenkin on 2015/11/7.
 * 邮箱的主表
 */

public class Email {
    //邮箱id
    private long emailId;

    //接收人的id
    private String acceptPersonId;

    //接收人的名字
    private String acceptPersonName;

    //发送人的id
    private String sendPersonId;

    //发送人的名字
    private String sendPersonName;

    //邮箱的主题
    private String emailTheme;

    //发送的内容
    private String sendInformation;

    //发送的时间
    private Timestamp sendTime;

    //是否已经读取
    private Boolean isRead;

    //是否为自动发送（回复）
    private Boolean atuoSend;

    //是接收的还是发送的
    private Boolean sendOrAccept;

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
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

    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    public String getSendInformation() {
        return sendInformation;
    }

    public void setSendInformation(String sendInformation) {
        this.sendInformation = sendInformation;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getAtuoSend() {
        return atuoSend;
    }

    public void setAtuoSend(Boolean atuoSend) {
        this.atuoSend = atuoSend;
    }

    public Boolean getSendOrAccept() {
        return sendOrAccept;
    }

    public void setSendOrAccept(Boolean sendOrAccept) {
        this.sendOrAccept = sendOrAccept;
    }
}
