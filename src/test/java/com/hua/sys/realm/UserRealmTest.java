package com.hua.sys.realm;

import com.hua.sys.BaseTest;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.junit.Assert;
import org.junit.Test;

import javax.security.auth.login.AccountLockedException;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class UserRealmTest extends BaseTest {

    @Test
    public void testLoginSuccessful() {
        login("classpath:shiro.ini", "hai", "123");
        Assert.assertTrue(subject().isAuthenticated());
    }

    /**
     * 测试登录
     * 账户错误
     */
    @Test(expected = UnknownAccountException.class)
    public void testLoginFailWithUnKnowUsername() {
        login("classpath:shiro.ini", "haih", "123");
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test(expected = IncorrectCredentialsException.class)
    public void testLoginFailWithErrorPassword() {
        login("classpath:shiro.ini", "hai", "1234");
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test(expected = AccountLockedException.class)
    public void testLoginFailWithLocked() {
        login("classpath:shiro.ini", "hua", "123");
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test(expected = ExcessiveAttemptsException.class)
    public void testLoginFailWithLimitRetryCount() {
        for (int i = 1; i <= 5; i++) {
            try {
                login("classpath:shiro.ini", "hai", "124");
            } catch (Exception e) {
            }
            System.out.print("..........................................."+i+"\n");
        }
        login("classpath:shiro.ini", "hai", "124");
    }


    @Test
    public void testHasRoel(){
        login("classpath:shiro.ini","hai","123");
        Assert.assertTrue(subject().hasRole("admin"));
        subject().checkRole("admin");
    }

    @Test
    public void testHasPermission(){
        login("classpath:shiro.ini","hai","123");
        Assert.assertTrue(subject().isPermitted("user:create"));
        Assert.assertTrue(subject().isPermittedAll("user:create","user:update","menu:create"));
    }

}
