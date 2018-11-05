package com.secureemail.service;

import com.secureemail.domain.Email;
import com.secureemail.domain.EmailModel;

/**
 * Created by simpletour_Jenkin on 2015/11/9.
 * 邮箱的service
 */
public interface EmailService {

    /**
     * 查找用户所发送的邮件
     * @param email
     * @return
     */
    public Email find(Email email);

    /**
     * 更新邮件的信息
     * @param email
     * @return
     */
    public int update(Email email);

    /**
     * 发送一封邮件
     * @param email
     * @return
     */
    public int insert(Email email);

    /**
     * 删除某一封邮件
     * @param email
     * @return
     */
    public int delete(Email email);

    /**
     * 查找超级用户所制作的模板邮件
     * @param email
     * @return
     */
    public EmailModel find(EmailModel email);

    /**
     * 更新邮件的信息
     * @param email
     * @return
     */
    public int update(EmailModel email);

    /**
     * 发送一封邮件
     * @param email
     * @return
     */
    public int insert(EmailModel email);

    /**
     * 删除某一封邮件
     * @param email
     * @return
     */
    public int delete(EmailModel email);

}
