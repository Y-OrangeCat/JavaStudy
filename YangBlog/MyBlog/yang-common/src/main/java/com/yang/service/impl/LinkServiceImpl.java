package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Link;
import com.yang.domain.vo.LinkVo;
import com.yang.domain.vo.PageVo;
import com.yang.mapper.LinkMapper;
import com.yang.service.LinkService;
import com.yang.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 友链(Link)表服务实现类
 * @author makejava
 * @since 2022-12-07 20:33:02
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //封装vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);

        return ResponseResult.okResult(linkVos);
    }

    /**
     * 分页查询友链——后台
     */
    @Override
    public PageVo selectLinkPageList(Link link, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(link.getName()),Link::getName,link.getName());
        queryWrapper.eq(Objects.nonNull(link.getStatus()),Link::getStatus,link.getStatus());

        Page<Link> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //封装Vo
        List<Link> records = page.getRecords();
        PageVo pageVo = new PageVo();
        pageVo.setRows(records);
        pageVo.setTotal(page.getTotal());

        return pageVo;
    }
}

