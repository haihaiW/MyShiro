package com.hua.sys.service.impl;

import com.hua.sys.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by haihaiW
 *
 * @Date :created in {time} {date}
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();

    private String algorithmName="md5";
    private final int hashIterations = 2;


    public void encryptPassword(User user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword=new SimpleHash(algorithmName,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),hashIterations).toHex();
        user.setPassword(newPassword);
    }

}
