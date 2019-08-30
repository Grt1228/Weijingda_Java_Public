package com.jgsu.dao;

import com.jgsu.pojo.AppImage;
import com.jgsu.vo.ImageRequest;

import java.util.List;

public interface AppImageMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(AppImage record);

    int insertSelective(AppImage record);

    AppImage selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(AppImage record);

    int updateByPrimaryKey(AppImage record);

    /**
     * 获取图片
     * @param imageRequest
     * @return
     */
    List<AppImage> selectImage(ImageRequest imageRequest);
    /**
     * 后台获取图片
     * @param imageRequest
     * @return
     */
    List<AppImage> backImageList(ImageRequest imageRequest);
}