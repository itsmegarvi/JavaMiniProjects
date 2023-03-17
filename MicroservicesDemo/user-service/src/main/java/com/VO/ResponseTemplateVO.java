package com.VO;

import com.entity.Users;
//Combined class
public class ResponseTemplateVO {
    Users user;
    Department department;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ResponseTemplateVO(Users user, Department department) {
        this.user = user;
        this.department = department;
    }

    public ResponseTemplateVO(){

    }

    @Override
    public String toString() {
        return "ResponseTemplateVO{" +
                "user=" + user +
                ", department=" + department +
                '}';
    }
}
