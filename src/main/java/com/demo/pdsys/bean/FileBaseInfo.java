package com.demo.pdsys.bean;

import java.util.Date;

public class FileBaseInfo {
    private Long id;

    private String fileName;

    private String filePath;

    private String fileSize;

    private Boolean fileTypeDictValue;

    private Boolean fileDeletedFlag;

    private Boolean fileNameIsEncryption;

    private Boolean filePathIsEncryption;

    private Boolean fileIsSettingKeywords;

    private String fileUploadUserName;

    private Date fileUploadTime;

    private Long updateUserId;

    private Date updateTime;

    private String updateUserName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public Boolean getFileTypeDictValue() {
        return fileTypeDictValue;
    }

    public void setFileTypeDictValue(Boolean fileTypeDictValue) {
        this.fileTypeDictValue = fileTypeDictValue;
    }

    public Boolean getFileDeletedFlag() {
        return fileDeletedFlag;
    }

    public void setFileDeletedFlag(Boolean fileDeletedFlag) {
        this.fileDeletedFlag = fileDeletedFlag;
    }

    public Boolean getFileNameIsEncryption() {
        return fileNameIsEncryption;
    }

    public void setFileNameIsEncryption(Boolean fileNameIsEncryption) {
        this.fileNameIsEncryption = fileNameIsEncryption;
    }

    public Boolean getFilePathIsEncryption() {
        return filePathIsEncryption;
    }

    public void setFilePathIsEncryption(Boolean filePathIsEncryption) {
        this.filePathIsEncryption = filePathIsEncryption;
    }

    public Boolean getFileIsSettingKeywords() {
        return fileIsSettingKeywords;
    }

    public void setFileIsSettingKeywords(Boolean fileIsSettingKeywords) {
        this.fileIsSettingKeywords = fileIsSettingKeywords;
    }

    public String getFileUploadUserName() {
        return fileUploadUserName;
    }

    public void setFileUploadUserName(String fileUploadUserName) {
        this.fileUploadUserName = fileUploadUserName == null ? null : fileUploadUserName.trim();
    }

    public Date getFileUploadTime() {
        return fileUploadTime;
    }

    public void setFileUploadTime(Date fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}
