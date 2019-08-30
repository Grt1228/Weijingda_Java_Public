package com.jgsu.service.impl;

import com.aliyun.oss.OSS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.AppImageMapper;
import com.jgsu.pojo.AppImage;
import com.jgsu.service.IAppImageService;
import com.jgsu.utils.OSSUtils;
import com.jgsu.utils.PropertiesUtil;
import com.jgsu.utils.QiNiuYunUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.ImageRequest;
import com.jgsu.vo.ImageResponse;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 描述:
 * 图片管理
 *
 * @author lqd12
 * @create 2018-05-29 17:17
 */
@Service("iAppImageService")
public class AppImageServiceImpl implements IAppImageService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private AppImageMapper appImageMapper;
    @Override
    public ServerResponse<List<AppImage>> getImage(ImageRequest imageRequest) {
        logger.info("获取图片参数："+imageRequest);
        try {
            List<AppImage> appImageList = appImageMapper.selectImage(imageRequest);
            return ServerResponse.createBySuccess("获取图片成功",appImageList);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取图片异常"+e);
        }
        return ServerResponse.createByError("获取图片异常");
    }

    @Override
    public ServerResponse<PageInfo> list(ImageRequest imageRequest) {
        logger.info("后台获取图片参数："+imageRequest);
        try {
            PageHelper.startPage(imageRequest.getPageNum(),imageRequest.getPageSize());
            List<AppImage> appImageList = appImageMapper.backImageList(imageRequest);
            List<ImageResponse> imageResponseList = Lists.newArrayList();
            buildResponseList(appImageList,imageResponseList);
            PageInfo pageResult = new PageInfo(appImageList);
            pageResult.setList(imageResponseList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("后台获取图片异常"+e);
        }
        return ServerResponse.createByError("后台获取图片异常");
    }



    @Override
    public ServerResponse addOrUpdate(AppImage image) {
        logger.info("后台新增或修改图片参数："+image);
        try {
            if(StringUtils.isEmpty(image.getImageId())){
                image.setImageId(UUIDUtil.getUUID());
                //新增
                int insert = appImageMapper.insert(image);
                if(insert>0){
                    return ServerResponse.createBySuccess("新增图片成功");
                }
                return ServerResponse.createByError("新增图片异常");
            }else{
                //修改
                int i = appImageMapper.updateByPrimaryKeySelective(image);
                if(i>0){
                    return ServerResponse.createBySuccess("修改图片成功");
                }
                return ServerResponse.createByError("修改图片异常");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("后台新增或修改图片异常"+e);
        }
        return ServerResponse.createByError("后台新增或修改图片异常");
    }

    /**
     * @param inputStream
     * @return
     */
    @Override
    public ServerResponse uploadImg(FileInputStream inputStream) {
        String checkCodeUUid = UUIDUtil.getUUID();
        String imageUrl = null;
        OSS ossClient = OSSUtils.getOSSClient();

        try {
            /*QiNiuYunUtil.uploadFile(inputStream, PropertiesUtil.getProperty("QINIUYUN_BUCKET_NAME_ADMIN_IMG"),checkCodeUUid);
            imageUrl = QiNiuYunUtil.getFileAccessUrl(checkCodeUUid,
                    PropertiesUtil.getProperty("QINIUYUN_BUCKET_HOST_NAME_ADMIN_IMG"));*/

            OSSUtils.uploadByInputStream(ossClient,
                    inputStream,
                    PropertiesUtil.getProperty("ALIYUN_BUCKET_NMAE_GOOD"),
                    checkCodeUUid+".jpg");
            imageUrl = OSSUtils.getUrl(ossClient, checkCodeUUid+".jpg",
                    PropertiesUtil.getProperty("ALIYUN_BUCKET_NMAE_GOOD"));
            if(imageUrl!=null && imageUrl!=""){
                return ServerResponse.createBySuccess("上传成功",imageUrl);
            }
        } catch (Exception e) {
            logger.error("OSS上传出错了:"+e.getMessage());
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return ServerResponse.createByError("上传出错了");
    }

    private void buildResponseList(List<AppImage> appImageList, List<ImageResponse> imageResponseList) {
        for (AppImage appImage:appImageList){
            ImageResponse vo = new ImageResponse();
            vo.setCreateTime(appImage.getCreateTime());
            vo.setImageId(appImage.getImageId());
            vo.setImageName(appImage.getImageName());
            vo.setImageType(appImage.getImageType());
            vo.setImageTypeDesc(Const.ImageType.codeOf(Integer.parseInt(appImage.getImageType())).getValue());
            vo.setImageUrl(appImage.getImageUrl());
            vo.setModifiedTime(appImage.getModifiedTime());
            vo.setPkId(appImage.getPkId());
            vo.setSortNum(appImage.getSortNum());
            vo.setStatus(appImage.getStatus());
            vo.setStatusDesc(appImage.getStatus().equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            imageResponseList.add(vo);
        }
    }
}