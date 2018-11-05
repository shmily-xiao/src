package com.secureemail.service;

import com.secureemail.domain.User;

/**
 * Created by simpletour_Jenkin on 2015/11/9.
 * 用户
 */
public interface UserService {
    /**
     * 查找用户
     * @param user
     * @return
     */
    public User find(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 删除某一个用户
     * @param user
     * @return
     */
    public int delete(User user);
}
