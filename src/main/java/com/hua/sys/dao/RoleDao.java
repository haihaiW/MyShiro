package com.hua.sys.dao;

import com.hua.sys.entity.Role;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface RoleDao {
    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId,Long ...permissionIds);

    public void uncorrelationPermissions(Long roleId,Long ...permissionIds);
}
