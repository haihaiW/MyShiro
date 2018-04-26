package com.hua.sys.dao;

import com.hua.sys.entity.Permission;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface PermissionDao {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
