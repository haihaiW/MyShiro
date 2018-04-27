package com.hua.sys.service;


import com.hua.sys.entity.User;

import java.util.Set;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param user
     * @return User
     */
    User createUser(User user);

    /**
     * 需改用户密码
     *
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);

    /**
     * 添加用户角色关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(Long userId,Long ...roleIds);

    /**
     * 移除用户角色关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles(Long userId,Long...roleIds);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户名称查询其角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

}
