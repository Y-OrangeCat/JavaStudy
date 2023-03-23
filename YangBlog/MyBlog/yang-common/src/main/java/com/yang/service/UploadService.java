package com.yang.service;

import com.yang.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 图片上传接口
 * @Author: Mr.Yang
 * @Date: 2023/2/7 0:52
 * @Version: 1.0
 */
public interface UploadService {
    /**
     * 上传用户头像信息
     * @param img
     * @return
     */
    ResponseResult uploadImg(MultipartFile img);
}
