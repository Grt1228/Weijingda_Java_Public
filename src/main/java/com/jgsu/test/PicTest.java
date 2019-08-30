package com.jgsu.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 描述:
 * 测试获取图片
 *
 * @author grt
 * @create 2018-02-23 22:34
 */
public class PicTest {
    public static void main(String[] args) throws IOException {
        String url = "http://xuanke.jgsu.edu.cn/other/CheckCode.aspx?datetime=az";
        String path="e:\\pic.jpg";
        downloadPicture(url,path);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList,String path) throws IOException {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            System.out.println(dataInputStream.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            System.out.println(output);
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}