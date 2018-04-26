package com.hua.sys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by haihaiW
 * 角色
 * @Date :created in ${time} ${date}
 */
@Setter
@Getter
public class Role implements Serializable{

    private Long id;
    /**角色标识*/
    private String role;
    /**角色描述,ui界面显示*/
    private String description;
    /**是否可用*/
    private Boolean available=Boolean.FALSE;

    public Role() {
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
