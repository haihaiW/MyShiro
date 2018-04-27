package com.hua.sys.service;

import com.hua.sys.entity.Permission;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public interface PermissionService {
    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);
}
