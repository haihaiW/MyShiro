package com.hua.sys.realm;

import com.hua.sys.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class MyRealm3 implements Realm {
    @Override
    public String getName() {
        return "c";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user=new User("zhang","123");
        return new SimpleAuthenticationInfo(user,"123",getName());
    }
}
