package com.yang.dao;

import com.yang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一个Book
    int addBook(Books books);

    //根据id删除一个Book
    int deleteBook(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBook(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //查询书名
    Books queryBookByName(String bookName);
}
