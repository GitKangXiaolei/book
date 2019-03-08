package com.example.book.service.impl;

import com.example.book.entity.User;
import com.example.book.repository.UserMapper;
import com.example.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 根据卡号，获取用户
    @Override
    public User getEntity(int cardNumber) {
        return userMapper.selectUserById(cardNumber);
    }
}
