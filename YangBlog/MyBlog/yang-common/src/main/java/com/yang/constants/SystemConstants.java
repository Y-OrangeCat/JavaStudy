package com.yang.constants;

/**
 * @Description: 字面值处理：能够降低代码的耦合性，便于维护
 * @Author: Mr.Yang
 * @Date: 2022/12/3 23:35
 * @Version: 1.0
 */
public class SystemConstants {
    /**
     * 文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     * 文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论类型为：文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     * 评论类型为：友联评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 该值为获取文章浏览量时调用redisCache.set/getCacheMap方法的键
     */
    public static final String ARTICLE_VIEW_COUNT = "article:viewCount";

    /**
     * 菜单类型-菜单
     */
    public static final String MENU="C";
    /**
     * 菜单类型-按钮
     */
    public static final String BUTTON="F";

    /** 正常状态 */
    public static final String NORMAL = "0";
    public static final String ADMIN = "1";
}
