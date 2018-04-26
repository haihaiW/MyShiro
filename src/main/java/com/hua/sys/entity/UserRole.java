package com.hua.sys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by haihaiW
 * 用户角色关系
 * @Date :created in {time} {date}
 */
@Setter
@Getter
public class UserRole implements Serializable {
    private Long userId;
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!userId.equals(userRole.userId)) return false;
        return roleId.equals(userRole.roleId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + roleId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
