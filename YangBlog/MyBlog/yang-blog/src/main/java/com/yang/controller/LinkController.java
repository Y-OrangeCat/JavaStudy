package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 友链接口实现类
 * @Author: Mr.Yang
 * @Date: 2022/12/7 20:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    /**
     * 查询所有友链   localhost:7777/link/getAllLink
     * @return
     */
    @GetMapping("/getAllLink")
    public ResponseResult getAllLink() {
        return linkService.getAllLink();
    }
}
