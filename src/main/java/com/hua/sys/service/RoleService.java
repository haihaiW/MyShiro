package com.hua.sys.service;

import com.hua.sys.entity.Role;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface RoleService {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId,Long...permissionIds);

    void uncorrelationPermissions(Long roleId,Long...permissionIds);
}
