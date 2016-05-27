package com.secureemail.dao.impl;

import com.secureemail.dao.BaseDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 * Created by simpletour_Jenkin on 2015/11/7.
 * 基础的实现
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

    public String getNameSpace(){
        return this.getClass().getName();
    }

    public final String opof(String namespace, String op){
        return String.format("%s,%s",namespace,op);
    }

    @Override
    public T find(T query) {
        return this.getSqlSession().selectOne(opof(getNameSpace(),"find"),query);
    }

    @Override
    public int delete(T query) {
        return this.getSqlSession().delete(opof(getNameSpace(),"delete"),query);
    }

    @Override
    public int update(T query) {
        return this.getSqlSession().update(opof(getNameSpace(),"update"),query);
    }

    @Override
    public int insert(T query) {
        return this.getSqlSession().insert(opof(getNameSpace(),"insert"),query);
    }
}
