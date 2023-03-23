package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.dto.AddTagDto;
import com.yang.domain.dto.EditTagDto;
import com.yang.domain.dto.TagListDto;
import com.yang.domain.entity.Tag;
import com.yang.domain.vo.PageVo;
import com.yang.domain.vo.TagVo;
import com.yang.service.TagService;
import com.yang.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签(Tag)表控制层
 *
 * @author makejava
 * @since 2023-02-20 00:14:55
 */
@RestController
@RequestMapping("content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 分页查询标签列表
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    /**
     * 新增标签
     * @param tagDto
     * @return
     */
    @PostMapping
    public ResponseResult addTag(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable Long id){
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    /**
     * 修改标签
     * @param tagDto
     * @return
     */
    @PutMapping
    public ResponseResult updateTag(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }

    /**
     * 修改标签——获取标签信息
     * @param id
     * @return
     */
    @GetMapping ("/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id") Long id){
        Tag tag = tagService.getById(id);
        return ResponseResult.okResult(tag);
    }

    /**
     * 写博客时返回标签列表
     * @return
     */
    @GetMapping("/listAllTag")
    public ResponseResult listAlltag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}

