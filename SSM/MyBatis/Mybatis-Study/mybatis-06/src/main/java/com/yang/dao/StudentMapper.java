package com.yang.dao;

import com.yang.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudent();

    //连接查询
    List<Student> getStudentAll();
}
