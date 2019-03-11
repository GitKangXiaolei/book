package com.example.book.service.impl;

import com.example.book.entity.Borrowing;
import com.example.book.repository.BookMapper;
import com.example.book.repository.BorrowingMapper;
import com.example.book.repository.ReturnedMapper;
import com.example.book.repository.UserMapper;
import com.example.book.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private UserMapper user;
    @Autowired
    private BookMapper book;
    @Autowired
    private BorrowingMapper borrow;
    @Autowired
    private ReturnedMapper returnm;

    @Override
    public boolean borrowService(int cardNumber, int bookId) {

        if (user.selectUserById(cardNumber) == null) {
            System.out.println("该用户不存在！借阅失败！");
            return false;
        } else if (user.selectDepositById(cardNumber) < 100) {
            System.out.println("押金不足！借阅失败！");
            return false;
        } else if (book.selectBookByBookID(bookId) == null) {
            System.out.println("该图书不存在！借阅失败！");
            return false;
        } else if (getActualNumbers(bookId) == 1) {
            System.out.println("实际在馆数量仅为壹本！借阅失败！");
            return false;
        } else if (returnm.selectCountByBorrowId(findBorrowId(cardNumber,bookId)) == 0) {
            System.out.println("还未归还！借阅失败！");
            return false;
        } else {
            System.out.println("借阅成功！");
            return saveBorrowing(new Borrowing(getNextId(), user.selectUserById(cardNumber), book.selectBookByBookID(bookId), LocalDate.now()));
        }
    }

    @Override
    public Borrowing findBorrowing(int borrowId) {
        return borrow.selectInformationByBorrowId(borrowId);
    }

    @Override
    public Integer findBorrowId(int cardNumber, int bookId) {
        return borrow.selectBorrowId(cardNumber,bookId);
    }

    // 获取借阅信息表下一个id
    public int getNextId() {
        return borrow.selectCount() + 1;
    }

    // 添加借阅信息
    public boolean saveBorrowing(Borrowing borrowing) {
        if (borrow.saveBorrowing(borrowing) == 1) {
            return true;
        } else {
            return false;
        }
    }

    // 根据图书id，通过图书总数量 - 借阅数量，获取该图书可借阅数量
    public int getActualNumbers(int bookId) {
        // 图书总数量
        Integer numbers = book.selectNumbersByBookID(bookId);
        // 借阅数量
        int borrowNumbers = borrow.selectCountByBookId(bookId) - returnm.selectCountByBookId(bookId);
        if (numbers == null) {
            return 0;
        } else {
            return numbers - borrowNumbers;
        }
    }
}