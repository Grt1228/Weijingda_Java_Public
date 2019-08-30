package com.jgsu.vo;

/**
 * 描述:
 *  图片相关操作
 * @author grt
 * @create 2018-05-29 17:19
 */
public class ImageRequest extends PageRequest{
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 图片状态0：失效，1：生效',
     */
    private String status;
    /**
     * 图片类型0轮播图，1首页图标',2新闻头图
     */
    private String imageType;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "ImageRequest{" +
                "imageUrl='" + imageUrl + '\'' +
                "status='" + status + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}