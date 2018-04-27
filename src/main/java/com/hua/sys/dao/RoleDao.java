package com.hua.sys.dao;

import com.hua.sys.entity.Role;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface RoleDao {
    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
