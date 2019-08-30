package com.jgsu.controller.portal;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.AppImage;
import com.jgsu.service.IAppImageService;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 描述:
 * 图片管理
 *
 * @author grt
 * @create 2018-05-29 17:14
 */
@Controller
@RequestMapping("/portal/image")
public class AppImageController {
    @Autowired
    private IAppImageService iAppImageService;

    @RequestMapping(value = "/getImage.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<AppImage>> getImage(@RequestBody ImageRequest imageRequest){
        return iAppImageService.getImage(imageRequest);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addOrUpdate(HttpSession session
            ,@RequestParam("file") MultipartFile multipartFile,ImageRequest imageRequest) throws IOException {
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        ServerResponse response = iAppImageService.uploadImg(inputStream);
        return response;

    }
}