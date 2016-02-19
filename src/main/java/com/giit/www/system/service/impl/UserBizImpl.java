package com.giit.www.system.service.impl;

import com.giit.www.entity.User;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.UserBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-9.
 */

@Service
public class UserBizImpl implements UserBiz {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
}

