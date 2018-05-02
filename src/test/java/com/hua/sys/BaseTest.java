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
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;


/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public abstract class BaseTest {
    protected PermissionService permissionService=new PermissionServiceImpl();
    protected UserService userService=new UserServiceImpl();
    protected RoleService roleService=new RoleServiceImpl();

    protected String password="123";

    protected Permission p1;
    protected Permission p2;
    protected Permission p3;

    protected Role r1;
    protected Role r2;

    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;

    @Before
    public void setUp() throws Exception {
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_users");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_roles");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_users_roles");
        JdbcTemplateUtils.jdbctemplate().update("delete from sys_roles_permissions");


        //1.新增权限
        p1=new Permission("user:create", "用户模块新增", Boolean.TRUE);
        p2=new Permission("user:update","用户模块修改",Boolean.TRUE);
        p3=new Permission("menu:create","菜单新增模块",Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2.新增角色
        r1=new Role("admin","管理员", Boolean.TRUE);
        r2=new Role("user","普通用户",Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3.角色和权限关联
        roleService.correlationPermissions(r1.getId(),p1.getId());
        roleService.correlationPermissions(r1.getId(),p2.getId());
        roleService.correlationPermissions(r1.getId(),p3.getId());

        roleService.correlationPermissions(r2.getId(),p1.getId());
        roleService.correlationPermissions(r2.getId(),p2.getId());

        //4 用户添加
        u1=new User("zhang",password);
        u2=new User("li",password);
        u3=new User("hua",password);
        u4=new User("hai",password);
        u4.setLocked(Boolean.TRUE);

        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);

        //5.用户关联角色
        userService.correlationRoles(u1.getId(),r1.getId());
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject(); //退出时解除绑定subject到线程，否则对下次测试造成影响
    }

    protected  void login(String configFile,String username,String userpassword){
        try {
            Factory<SecurityManager> factory=new IniSecurityManagerFactory();
            SecurityManager securityManager=factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);
            org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,userpassword);
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();

        }
    }
    public org.apache.shiro.subject.Subject subject(){
        return SecurityUtils.getSubject();
    }
}
