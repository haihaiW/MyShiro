package com.hua.sys.dao;

import com.hua.sys.entity.User;

import java.util.Set;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface UserDao {
    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermisions(String username);
}
