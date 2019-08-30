package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.AppImage;
import com.jgsu.vo.ImageRequest;

import java.io.FileInputStream;
import java.util.List;

/**
 * 描述:
 * 图片管理
 *
 * @author grt
 * @create 2018-05-29 17:16
 */
public interface IAppImageService {
    /**
     * 前台获取图片展示
     * @param imageRequest
     * @return
     */
    ServerResponse<List<AppImage>> getImage(ImageRequest imageRequest);

    /**
     * 后台展示图片
     * @param imageRequest
     * @return
     */
    ServerResponse<PageInfo> list(ImageRequest imageRequest);

    /**
     * 后台新增或修改图片
     * @param image
     * @return
     */
    ServerResponse addOrUpdate(AppImage image);

    /**
     *
     * @param inputStream
     * @return
     */
    ServerResponse uploadImg(FileInputStream inputStream);
}
