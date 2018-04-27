package com.hua.sys.service.impl;

import com.hua.sys.dao.UserDao;
import com.hua.sys.dao.impl.UserDaoImpl;
import com.hua.sys.entity.User;
import com.hua.sys.service.UserService;

import java.util.Set;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    private PasswordHelper passwordHelper = new PasswordHelper();

    @Override
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);

    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId,roleIds);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermisions(username);
    }
}
