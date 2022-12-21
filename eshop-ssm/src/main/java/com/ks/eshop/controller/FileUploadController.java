package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.util.FtpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileUploadController {

    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //获取服务器上传文件路径
//        String path = request.getSession().getServletContext().getRealPath("upload");
//        String path = "\\usr\\local\\tomcat\\tomcat-9.0.46\\webapps\\eshop\\WEB-INF\\classes\\static\\upload";
////        System.out.println(path);
//        //获取文件名
//        String fileName = file.getOriginalFilename();
//        //创建File文件对象
//        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        try {
//            file.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return Result.fail();
//        }
//        return Result.success();
        if (!file.isEmpty()){
            try {
                InputStream inputStream = file.getInputStream();
                FtpUtil.UploadImageByInputStream(inputStream,file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                return Result.fail();
            }
            return Result.success();
        }else {
            return Result.fail();
        }
    }
}

