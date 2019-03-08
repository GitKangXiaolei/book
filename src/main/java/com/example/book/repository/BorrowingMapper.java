package com.example.book.repository;

import com.example.book.entity.Borrowing;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BorrowingMapper {
    // 添加借阅信息
    int saveBorrowing(Borrowing borrowing);

    // 查询全部借阅信息
    List<Borrowing> selectAllBorrowing();

    // 根据图书id查询该图书的借阅总次数
    int selectCountByBookId(int bookId);

    // 根据卡号、图书id，查询距离当前日期最近的借阅号
    Integer selectBorrowId(int cardNumber, int bookId);

    // 根据借阅号查询借阅日期
    LocalDate selectDateByBorrowId(int borrowId);

    // 查询借阅表总行数
    int selectCount();

    // 根据借阅号查询借阅信息
    Borrowing selectInformationByBorrowId(int borrowId);
}