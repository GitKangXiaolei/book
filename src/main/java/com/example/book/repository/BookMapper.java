package com.example.book.repository;

import com.example.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    // 添加图书
    int saveBook(Book book);

    // 查询全部图书信息
    List<Book> selectAllBook();

    // 根据图书id查询该图书数量
    Integer selectNumbersByBookID(int bookId);

    // 根据图书id查询该图书信息
    Book selectBookByBookID(int bookId);
}
