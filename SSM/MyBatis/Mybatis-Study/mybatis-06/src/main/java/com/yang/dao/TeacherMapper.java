package com.yang.dao;

import com.yang.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher;")
    List<Teacher> getTeacher();
}
