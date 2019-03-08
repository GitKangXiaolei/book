package com.example.book.service.impl;

import com.example.book.entity.Returned;
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
public class ReturnedServiceImpl implements ReturnedService {
    @Autowired
    private UserMapper user;
    @Autowired
    private BookMapper book;
    @Autowired
    private BorrowingMapper borrow;
    @Autowired
    private ReturnedMapper returnm;

    @Override
    public boolean returnService(int cardNumber, int bookId) {
        if (user.selectUserById(cardNumber) == null) {
            System.out.println("该用户不存在！归还失败！");
            return false;
        } else if (book.selectBookByBookID(bookId) == null) {
            System.out.println("该图书不存在！归还失败！");
            return false;
        } else if (returnm.selectCountByBorrowId(borrow.selectBorrowId(cardNumber, bookId)) == 1) {
            System.out.println("该图书已归还！归还失败！");
            return false;
        } else {
            System.out.println("归还成功！");
            return saveReturned(new Returned(getNextId(), LocalDate.now(), borrow.selectInformationByBorrowId(borrow.selectBorrowId(cardNumber, bookId))));
        }
    }

    // 获取归还信息表下一个id
    public int getNextId() {
        return returnm.selectCount() + 1;
    }

    // 添加归还信息
    public boolean saveReturned(Returned returned) {
        if (returnm.saveReturned(returned) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
