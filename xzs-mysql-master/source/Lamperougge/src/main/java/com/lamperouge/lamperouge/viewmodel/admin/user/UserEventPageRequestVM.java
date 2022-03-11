package com.lamperouge.lamperouge.viewmodel.admin.user;

import com.lamperouge.lamperouge.base.BasePage;

/**
 * @author nmj
 * @create 2022-01-24 18:29
 */
public class UserEventPageRequestVM extends BasePage {

    private Integer userId;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
