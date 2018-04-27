package com.hua.sys.credentials;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private Ehcache passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher() {
        CacheManager cacheManager=CacheManager.newInstance(CacheManager.class.getClassLoader().getResource("ehcache.xml"));
        passwordRetryCache=cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username=(String)token.getPrincipal();
        Element element=passwordRetryCache.get(username);
        if (element==null){
          //  passwordRetryCache.put(username,new AtomicInteger(0));
        }
        return super.doCredentialsMatch(token, info);
    }
}
