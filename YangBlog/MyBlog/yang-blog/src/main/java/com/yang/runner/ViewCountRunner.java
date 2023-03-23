package com.yang.runner;

import com.yang.constants.SystemConstants;
import com.yang.domain.entity.Article;
import com.yang.mapper.ArticleMapper;
import com.yang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: 启动预处理
 * @Author: Mr.Yang
 * @Date: 2023/2/17 0:56
 * @Version: 1.0
 */
@Component
public class ViewCountRunner implements CommandLineRunner {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private RedisCache redisCache;

    /**
     * ①在应用启动时把博客的浏览量存储到redis中
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //查询博客信息 id     viewCount
        List<Article> articles = articleMapper.selectList(null);
        Map<String, Integer> viewCount = articles.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));
        //保存到redis中
        redisCache.setCacheMap(SystemConstants.ARTICLE_VIEW_COUNT,viewCount);
    }
}
