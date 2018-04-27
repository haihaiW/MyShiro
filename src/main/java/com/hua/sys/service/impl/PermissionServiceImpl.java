package com.hua.sys.service.impl;

import com.hua.sys.dao.PermissionDao;
import com.hua.sys.dao.impl.PermissionDaoImpl;
import com.hua.sys.entity.Permission;
import com.hua.sys.service.PermissionService;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao = new PermissionDaoImpl();

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
