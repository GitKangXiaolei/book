package com.example.book.repository;

import com.example.book.entity.BookType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    // 添加图书类型
    int saveBookType(BookType bookType);

    // 查询全部图书类型
    List<BookType> selectAllBookType();

}
