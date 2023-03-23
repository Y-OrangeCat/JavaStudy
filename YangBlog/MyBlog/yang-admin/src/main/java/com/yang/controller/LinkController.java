package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Link;
import com.yang.domain.vo.PageVo;
import com.yang.service.LinkService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/3/9 19:55
 * @Version: 1.0
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    /**
     * 分页查询友链
     */
    @GetMapping("/list")
    public ResponseResult LinkPageList(Link link,Integer pageNum,Integer pageSize){
        PageVo pageVo = linkService.selectLinkPageList(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 添加友链
     */
    @PostMapping
    public ResponseResult addLink(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }

    /**
     * 修改前查询友链信息
     */
    @GetMapping(value = "/{id}")
    public ResponseResult getLinkById(@PathVariable(value = "id") Long id){
        Link link = linkService.getById(id);
        return ResponseResult.okResult(link);
    }

    /**
     * 修改友链
     * @param link
     * @return
     */
    @PutMapping
    public ResponseResult edit(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    /**
     * 改变友链状态
     * @param link
     * @return
     */
    @PutMapping("/changeLinkStatus")
    public ResponseResult changeLinkStatus(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    /**
     * 删除友链
     */
    @DeleteMapping(value = "/{id}")
    public ResponseResult removeLink(@PathVariable(value = "id") Long id){
        linkService.removeById(id);
        return ResponseResult.okResult();
    }

}
