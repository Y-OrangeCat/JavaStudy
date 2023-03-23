package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.dto.TagListDto;
import com.yang.domain.entity.Tag;
import com.yang.domain.vo.PageVo;
import com.yang.domain.vo.TagVo;

import java.util.List;

/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-02-20 00:15:00
 */
public interface TagService extends IService<Tag> {
    /**
     * 分页查询标签列表(后台)
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    /**
     * 写博客时返回标签列表(后台)
     * @return
     */
    List<TagVo> listAllTag();
}

