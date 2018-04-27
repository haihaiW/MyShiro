package com.hua.sys;

import com.hua.sys.entity.Permission;
import com.hua.sys.entity.Role;
import com.hua.sys.entity.User;
import com.hua.sys.service.PermissionService;
import com.hua.sys.service.RoleService;
import com.hua.sys.service.UserService;
import com.hua.sys.service.impl.PermissionServiceImpl;
import com.hua.sys.service.impl.RoleServiceImpl;
import com.hua.sys.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class BaseTest {

    protected PermissionService permissionService = new PermissionServiceImpl();

    protected RoleService roleService = new RoleServiceImpl();

    protected UserService userService = new UserServiceImpl();

    protected String password = "123";

    protected Permission p1;
    protected Permission p2;
    protected Permission p3;

    protected  Role r1;
    protected  Role r2;

    protected User u1;
    protected  User u2;
    protected  User u3;

    @Before
    public void setUp() throws Exception {
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_users");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_roles");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_roles_permissions");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_users_permissions");

        //新增权限
        p1=new Permission("user:create","用户新增模块",Boolean.TRUE);
        p2=new Permission("user:update","用户修改模块",Boolean.TRUE);
        p3=new Permission("menu:create","菜单模块修改",Boolean.TRUE);

        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);

        //新增角色
        r1=new Role("admin","管理角色",Boolean.TRUE);
        r2=new Role("user","普通用户",Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);

        //角色添加权限
        roleService.correlationPermissions(r1.getId(),p1.getId());
        roleService.correlationPermissions(r1.getId(),p2.getId());
        roleService.correlationPermissions(r1.getId(),p3.getId());

        roleService.correlationPermissions(r2.getId(),p1.getId());
        roleService.correlationPermissions(r2.getId(),p2.getId());

        //新增用户
        u1=new User("zhang",password);
        u2=new User("hai",password);
        u3=new User("li",password);

        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.correlationRoles(u1.getId(),r1.getId());
    }

    @Test
    public void login(String config,String username,String password){
        Factory<org.apache.shiro.mgt.SecurityManager> factory= new IniSecurityManagerFactory();
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        subject.login(usernamePasswordToken);
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时解除绑定到线程的subject.
    }

    public Subject subject(){
        return SecurityUtils.getSubject();
    }
}

