package com.giit.www.system.service.impl;

import com.giit.www.entity.Role;
import com.giit.www.entity.User;
import com.giit.www.entity.custom.UserVo;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.RoleBiz;
import com.giit.www.system.service.UserBiz;
import com.giit.www.util.PasswordHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by c0de8ug on 16-2-9.
 */

@Service
public class UserBizImpl implements UserBiz {

    @Resource
    UserDao userDao;

    @Resource
    RoleDao roleDao;

    @Resource
    private PasswordHelper passwordHelper;
    @Resource(name = "roleBizImpl")
    private RoleBiz roleBiz;

    @Override
    public List<UserVo> findAll() throws InvocationTargetException, IllegalAccessException {
        List<UserVo> userVoList = new ArrayList<>();
        List userList = userDao.findAll();
        StringBuilder s = new StringBuilder();

        Iterator iterator = userList.iterator();

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            List<Long> roleIds = user.getRoleIds();

            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userVo, user);

            if (roleIds != null) {
                int i = 0;
                int size = roleIds.size();
                //TODO 如果只有一个也会出问题!!
                for (; i < size - 1; i++) {
                    Role role = roleDao.findOne(roleIds.get(i));

                    s.append(role.getDescription());
                    s.append(",");
                }
                Role role = roleDao.findOne(roleIds.get(i));
                s.append(role.getDescription());
                userVo.setRoleIdsStr(s.toString());
            }


            userVoList.add(userVo);

        }

        return userVoList;
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
        passwordHelper.encryptPassword(user);
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        User user = userDao.findById(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.update(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    @Override
    public Set<String> findPermissions(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }
}

