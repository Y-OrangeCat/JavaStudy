package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Link;
import com.yang.domain.vo.PageVo;

/**
 * 友链(Link)表服务接口
 * @author makejava
 * @since 2022-12-07 20:33:01
 */
public interface LinkService extends IService<Link> {
    /**
     * 查询所有友链
     * @return
     */
    ResponseResult getAllLink();

    /**
     * 分页查询友链——后台
     */
    PageVo selectLinkPageList(Link link, Integer pageNum, Integer pageSize);
}

