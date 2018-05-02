package com.hua.sys.realm;

import com.hua.sys.BaseTest;
import com.hua.sys.entity.User;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class PrincialCollectionTest  extends BaseTest{

    @Test
    public void test() throws Exception {
        login("classpath:shiro-multirealm.ini","hua","123");
        Subject subject=subject();
        Object primaryPrincipal1=subject.getPrincipal();

        PrincipalCollection principalCollection=subject.getPrincipals();

        Object primaryPrincipal2=principalCollection.getPrimaryPrincipal();

        Assert.assertEquals(primaryPrincipal1,primaryPrincipal2);

        //返回 a b c
        Set<String> realms=principalCollection.getRealmNames();
        System.out.print(realms);

        //因为MyRealm1和MyRealm2返回的凭据都是zhang，所以排重了
        Set<Object> principals=principalCollection.asSet();
        System.out.print(principals);

        //根据Realm名字获取
        Collection<User> user=principalCollection.fromRealm("c");
        System.out.print(user);

    }
}
