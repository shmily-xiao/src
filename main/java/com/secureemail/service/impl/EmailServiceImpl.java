package com.secureemail.service.impl;

import com.secureemail.dao.EmailDao;
import com.secureemail.dao.EmailModelDao;
import com.secureemail.domain.Email;
import com.secureemail.domain.EmailModel;
import com.secureemail.service.EmailService;

/**
 * Created by simpletour_Jenkin on 2015/11/9.
 */
public class EmailServiceImpl implements EmailService{

    private EmailDao emailDao;

    private EmailModelDao emailModelDao;

    @Override
    public Email find(Email email) {
        return null;
    }

    @Override
    public int update(Email email) {
        return 0;
    }

    @Override
    public int insert(Email email) {
        return 0;
    }

    @Override
    public int delete(Email email) {
        return 0;
    }

    @Override
    public EmailModel find(EmailModel email) {
        return null;
    }

    @Override
    public int update(EmailModel email) {
        return 0;
    }

    @Override
    public int insert(EmailModel email) {
        return 0;
    }

    @Override
    public int delete(EmailModel email) {
        return 0;
    }

    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    public void setEmailModelDao(EmailModelDao emailModelDao) {
        this.emailModelDao = emailModelDao;
    }
}
