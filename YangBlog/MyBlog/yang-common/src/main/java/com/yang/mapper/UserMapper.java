package com.yang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-08 20:19:45
 */
public interface UserMapper extends BaseMapper<User> {

}
