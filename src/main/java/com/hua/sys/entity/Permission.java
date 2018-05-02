package com.hua.sys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by haihaiW
 * 权限
 * @Date :created in {time} {date}
 */
@Setter
@Getter
public class Permission implements Serializable{
    private Long id;
    /**权限标识*/
    private String permission;
    /**权限描述*/
    private String description;
    /**是否可用*/
    private Boolean available=Boolean.FALSE;

    public Permission() {
    }

    public Permission(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return  id != null ? id.hashCode() : 0;
    }
}
