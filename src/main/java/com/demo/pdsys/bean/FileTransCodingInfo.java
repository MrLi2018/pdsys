package com.demo.pdsys.bean;

import java.util.Date;

public class FileTransCodingInfo {
    private Long id;

    private Long fileBaseinfoId;

    private String fileTranscodingPath;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileBaseinfoId() {
        return fileBaseinfoId;
    }

    public void setFileBaseinfoId(Long fileBaseinfoId) {
        this.fileBaseinfoId = fileBaseinfoId;
    }

    public String getFileTranscodingPath() {
        return fileTranscodingPath;
    }

    public void setFileTranscodingPath(String fileTranscodingPath) {
        this.fileTranscodingPath = fileTranscodingPath == null ? null : fileTranscodingPath.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}
