package com.example.book.repository;

import com.example.book.entity.Returned;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturnedMapper {
    // 添加归还信息
    int saveReturned(Returned returned);

    // 查询全部归还信息
    List<Returned> selectAllReturned();

    // 根据借阅id查询该图书有没有归还记录
    int selectCountByBorrowId(Integer borrowId);

    // 根据图书id查询该图书的归还总次数
    int selectCountByBookId(int bookId);

    // 查询归还表总行数
    int selectCount();
}
