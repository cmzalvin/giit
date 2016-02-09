package com.giit.www.system.dao;

import com.giit.www.entity.User;

import java.util.List;

/**
 * Created by c0de8ug on 16-2-9.
 */
public interface UserDao {
    public List<User> findAll();
}
