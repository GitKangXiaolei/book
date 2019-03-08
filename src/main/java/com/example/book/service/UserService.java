package com.example.book.service;

import com.example.book.entity.User;

public interface UserService {

    // 根据卡号，获取用户
    User getEntity(int cardNumber);
}
