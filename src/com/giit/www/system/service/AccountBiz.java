package com.giit.www.system.service;

import com.giit.www.entity.User;

/**
 * Created by c0de8ug on 16-2-14.
 */
public interface AccountBiz {
    public User login(String username, String password);
}
