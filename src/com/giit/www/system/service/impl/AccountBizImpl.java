package com.giit.www.system.service.impl;

import com.giit.www.entity.User;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.AccountBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-14.
 */
@Service
public class AccountBizImpl implements AccountBiz {

    @Resource
    UserDao userDao;

    public User login(String username, String password) {
        return userDao.findByIdAndPassword(username, password);

    }
}
