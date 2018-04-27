package com.hua.sys.service.impl;

import com.hua.sys.dao.RoleDao;
import com.hua.sys.dao.impl.RoleDaoImpl;
import com.hua.sys.entity.Role;
import com.hua.sys.service.RoleService;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao=new RoleDaoImpl();
    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId,permissionIds);
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
    roleDao.uncorrelationPermissions(roleId,permissionIds);
    }
}
