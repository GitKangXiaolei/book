package com.example.book.service;

import com.example.book.entity.Borrowing;

import java.util.List;

public interface BorrowService {
    boolean borrowService(int cardNumber, int bookId);

    // 查询全部借阅信息
    List<Borrowing> findAllBorrowing();
}
