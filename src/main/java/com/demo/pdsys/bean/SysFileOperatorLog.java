package com.demo.pdsys.bean;

import java.util.Date;

public class SysFileOperatorLog {
    private Long id;

    private Long fileBaseinfoId;

    private Boolean fileOptypeDicValue;

    private Long createUserId;

    private Date createTime;

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

    public Boolean getFileOptypeDicValue() {
        return fileOptypeDicValue;
    }

    public void setFileOptypeDicValue(Boolean fileOptypeDicValue) {
        this.fileOptypeDicValue = fileOptypeDicValue;
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
}
