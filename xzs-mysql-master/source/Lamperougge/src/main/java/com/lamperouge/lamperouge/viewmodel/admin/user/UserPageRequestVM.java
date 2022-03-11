package com.lamperouge.lamperouge.viewmodel.admin.user;

import com.lamperouge.lamperouge.base.BasePage;

/**
 * @author nmj
 * @create 2022-01-10 23:26
 */
public class UserPageRequestVM extends BasePage {

    private String userName;
    private Integer role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
