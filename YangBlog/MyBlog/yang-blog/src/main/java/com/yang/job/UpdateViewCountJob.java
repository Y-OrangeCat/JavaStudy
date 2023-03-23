package com.yang.job;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.constants.SystemConstants;
import com.yang.domain.entity.Article;
import com.yang.mapper.ArticleMapper;
import com.yang.service.ArticleService;
import com.yang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 定时任务
 * @Author: Mr.Yang
 * @Date: 2023/2/18 23:51
 * @Version: 1.0
 */
@Component
public class UpdateViewCountJob {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ArticleService articleService;


    /**
     * ③定时更新redis中的浏览量保存到数据库中
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void updateViewCount() {
        //从redis中获取浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap(SystemConstants.ARTICLE_VIEW_COUNT);

        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                .collect(Collectors.toList());

        //将数据存到数据库中
        //根据ID 批量更新 updateBatchById
        //Params:entityList – 实体对象集合
        /*
        按这样写没问题的，因为MP自带的update类方法是全字段的更新操作，
        此时会导致更新字段的自动填充，因为没有token，会在getUser时报空指针异常，
        即使在自动填充组件中update时判空，也会导致数据库中的updateTime等字段变为null。
        所以不使用MP自带的方法，而是使用wrapper进行指定字段的更新，
        此时没有更新需要自动填充的字段，不会调用自动填充相关的方法，所以没有任何异常还可以完成浏览量的更新
        */
        for (Article article : articles) {
            LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(Article::getId, article.getId());
            updateWrapper.set(Article::getViewCount, article.getViewCount());
            articleService.update(updateWrapper);
        }

//        articleService.updateBatchById(articles);
    }
}
