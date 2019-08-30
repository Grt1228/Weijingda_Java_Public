package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class MapPoint {
    private Long pkId;

    private String mapPointId;

    private String mapPointName;

    private String mapPointLongitude;

    private String mapPointLatitude;

    private String mapPointDesc;

    private String pointType;

    private String sort;

    private String mapGroupId;

    private String mapGroupName;

    private String status;

    private Date createTime;

    private Date modifiedTime;

    public MapPoint(Long pkId, String mapPointId, String mapPointName, String mapPointLongitude, String mapPointLatitude, String mapPointDesc, String pointType, String sort, String mapGroupId, String mapGroupName, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.mapPointId = mapPointId;
        this.mapPointName = mapPointName;
        this.mapPointLongitude = mapPointLongitude;
        this.mapPointLatitude = mapPointLatitude;
        this.mapPointDesc = mapPointDesc;
        this.pointType = pointType;
        this.sort = sort;
        this.mapGroupId = mapGroupId;
        this.mapGroupName = mapGroupName;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public MapPoint() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getMapPointId() {
        return mapPointId;
    }

    public void setMapPointId(String mapPointId) {
        this.mapPointId = mapPointId == null ? null : mapPointId.trim();
    }

    public String getMapPointName() {
        return mapPointName;
    }

    public void setMapPointName(String mapPointName) {
        this.mapPointName = mapPointName == null ? null : mapPointName.trim();
    }

    public String getMapPointLongitude() {
        return mapPointLongitude;
    }

    public void setMapPointLongitude(String mapPointLongitude) {
        this.mapPointLongitude = mapPointLongitude == null ? null : mapPointLongitude.trim();
    }

    public String getMapPointLatitude() {
        return mapPointLatitude;
    }

    public void setMapPointLatitude(String mapPointLatitude) {
        this.mapPointLatitude = mapPointLatitude == null ? null : mapPointLatitude.trim();
    }

    public String getMapPointDesc() {
        return mapPointDesc;
    }

    public void setMapPointDesc(String mapPointDesc) {
        this.mapPointDesc = mapPointDesc == null ? null : mapPointDesc.trim();
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType == null ? null : pointType.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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