package com.jgsu.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述:
 * 获取验证码外链
 *
 * @author grt
 * @create 2018-04-22 22:19
 */
public class QiNiuYunUtil {

    public static Configuration cfg = new Configuration(Zone.zone0());
    public static UploadManager uploadManager = new UploadManager(cfg);

    public static int LIMIT_SIZE = 1000;
    /**
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param @param inputStream    待上传文件输入流
     * @param @param bucketName     空间名称
     * @param @param key            空间内文件的key
     * @param @param mimeType       文件的MIME类型，可选参数，不传入会自动判断
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public static String uploadFile(InputStream inputStream, String bucketName, String key, String mimeType) throws IOException {
        Auth auth = Auth.create(PropertiesUtil.getProperty("QINIUYUN_ACCESS_KEY"), PropertiesUtil.getProperty("QINIUYUN_SECRET_KEY"));
        String token = auth.uploadToken(bucketName);
        byte[] byteData = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(byteData, key, token, null, mimeType, false);
        inputStream.close();
        return response.bodyString();
    }

    /**
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param @param inputStream    待上传文件输入流
     * @param @param bucketName     空间名称
     * @param @param key            空间内文件的key
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public static String uploadFile(InputStream inputStream,String bucketName,String key) throws IOException {
        Auth auth = Auth.create(PropertiesUtil.getProperty("QINIUYUN_ACCESS_KEY"), PropertiesUtil.getProperty("QINIUYUN_SECRET_KEY"));
        String token = auth.uploadToken(bucketName);
        byte[] byteData = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(byteData, key, token, null, null, false);
        inputStream.close();
        return response.bodyString();
    }

    /**
     * @Title: getFileAccessUrl
     * @Description: 返回七牛空间内指定文件的访问URL
     * @param @param key
     * @param @return
     * @param @throws QiniuException
     * @return String
     * @throws
     */
    public static String getFileAccessUrl(String key,String bucketHostName) throws QiniuException {
        return bucketHostName + key;
    }
}