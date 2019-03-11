package com.example.book.service;

import com.example.book.entity.Borrowing;

public interface BorrowService {
    boolean borrowService(int cardNumber, int bookId);

    // 根据借阅号查询借阅信息
    Borrowing findBorrowing(int borrowId);

    // 根据卡号、图书id，查询距离当前日期最近的借阅号
    Integer findBorrowId(int cardNumber, int bookId);
}
