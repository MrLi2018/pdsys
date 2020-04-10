package com.demo.pdsys.bean;

import io.swagger.annotations.Api;

import java.io.Serializable;
import java.util.Date;

@Api("用户信息实体")
public class SysUserInfo implements Serializable {
    private Long id;

    private String userLoginName;

    private String userPassword ;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String userPhotoPath;

    private Date createTime;

    private Long createUserId;

    private Long updateUserId;

    private Date udateTime;

    private String verycode;

    public String getVerycode() {
        return verycode;
    }

    public void setVerycode(String verycode) {
        this.verycode = verycode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath == null ? null : userPhotoPath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUdateTime() {
        return udateTime;
    }

    public void setUdateTime(Date udateTime) {
        this.udateTime = udateTime;
    }
}
