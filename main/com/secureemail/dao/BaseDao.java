package com.secureemail.dao;

/**
 * Created by simpletour_Jenkin on 2015/11/7.
 * 基本的操作
 */
public interface BaseDao<T> {
    /**
     * 查找
     * @param query
     * @return
     */
    public T find(T query);

    /**
     * 删除
     * @param query
     * @return
     */
    public int delete(T query);

    /**
     * 更新
     * @param query
     * @return
     */
    public int update(T query);

    /**
     * 添加
     * @param query
     * @return
     */
    public int insert(T query);
}
