package com.yang.dao;

import com.yang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher getTeacherId(@Param("tid") int id);

    Teacher getTeacherId2(@Param("tid") int id);
}
