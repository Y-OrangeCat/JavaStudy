package com.yang.dao;

import com.yang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> querygetBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    int queryBlogSet(Map map);

    List<Blog> queryBlogForeach(Map map);
}
