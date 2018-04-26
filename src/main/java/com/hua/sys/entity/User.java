package com.hua.sys.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by haihaiW on 2018/4/26.
 * 用户
 */
@Setter
@Getter
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String salt;
    private Boolean locked = Boolean.FALSE;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
