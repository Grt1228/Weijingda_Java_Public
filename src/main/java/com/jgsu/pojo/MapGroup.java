package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class MapGroup {
    private Long pkId;

    private String mapGroupId;

    private String mapGroupName;

    private String mapGroupDesc;

    private String status;

    private Date createTime;

    private Date modifiedTime;

    public MapGroup(Long pkId, String mapGroupId, String mapGroupName, String mapGroupDesc, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.mapGroupId = mapGroupId;
        this.mapGroupName = mapGroupName;
        this.mapGroupDesc = mapGroupDesc;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public MapGroup() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getMapGroupId() {
        return mapGroupId;
    }

    public void setMapGroupId(String mapGroupId) {
        this.mapGroupId = mapGroupId == null ? null : mapGroupId.trim();
    }

    public String getMapGroupName() {
        return mapGroupName;
    }

    public void setMapGroupName(String mapGroupName) {
        this.mapGroupName = mapGroupName == null ? null : mapGroupName.trim();
    }

    public String getMapGroupDesc() {
        return mapGroupDesc;
    }

    public void setMapGroupDesc(String mapGroupDesc) {
        this.mapGroupDesc = mapGroupDesc == null ? null : mapGroupDesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}