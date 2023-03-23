package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 上传图片控制层
 * @Author: Mr.Yang
 * @Date: 2023/3/3 23:08
 * @Version: 1.0
 */
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 上传博客图片文件（后台）
     * @param multipartFile
     * @return
     */
    @PostMapping("/upload")
    public ResponseResult uploadImg(@RequestParam("img") MultipartFile multipartFile) {
        try {
            return uploadService.uploadImg(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传上传失败");
        }

    }
}
