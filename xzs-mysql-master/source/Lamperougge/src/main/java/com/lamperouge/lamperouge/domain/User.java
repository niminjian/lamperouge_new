package com.lamperouge.lamperouge.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nmj
 * @create 2022-01-11 10:05
 */
public class User implements Serializable {

    private static final long serialVersionId = -7797183521247423117L;

    private Integer id;

    private String userUuid;

    /**
     * 用户名
     */
    private String userName;

    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    private Integer age;

    /**
     * 1.男 2.女
     */
    private Integer sex;

    private Date birthDay;

    /**
     * 学生年级(1-12)
     */
    private Integer userLevel;

    private String phone;

    /**
     * 1.学生 3.管理员
     */
    private Integer role;

    /**
     * 1.启用 2.禁用
     */
    private Integer status;

    /**
     * 头像地址
     */
    private String imagePath;

    private Date createTime;

    private Date modifyTime;

    /**
     * 最近活跃时间
     */
    private Date lastActiveTime;

    /**
     * 是否删除
     */
    private boolean deleted;

    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
