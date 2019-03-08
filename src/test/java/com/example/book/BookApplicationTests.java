package com.example.book;

import com.example.book.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApplicationTests {

    @Autowired
    BorrowService borrowService;

    @Test
    public void service() {
        borrowService.borrowService(101, 20190201);
    }

}