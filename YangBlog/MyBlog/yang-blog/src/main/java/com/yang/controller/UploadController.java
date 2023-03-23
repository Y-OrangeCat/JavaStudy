package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 图片上传控制层
 * @Author: Mr.Yang
 * @Date: 2023/2/7 0:43
 * @Version: 1.0
 */
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 上传用户头像信息
     * @param img
     * @return
     */
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile img){
        return uploadService.uploadImg(img);
    }
}
