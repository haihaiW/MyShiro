package com.hua.sys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by haihaiW
 * 权限角色关系
 * @Date :created in {time} {date}
 */
@Setter
@Getter
public class RolePermssion implements Serializable {
    private Long roleId;
    private Long permissionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermssion that = (RolePermssion) o;

        if (!roleId.equals(that.roleId)) return false;
        return permissionId.equals(that.permissionId);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + permissionId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RolePermssion{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
