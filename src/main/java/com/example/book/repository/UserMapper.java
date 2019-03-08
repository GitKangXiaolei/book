package com.example.book.repository;

import com.example.book.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 添加用户
    int saveUser(User user);

    // 查询全部用户
    List<User> selectAllUser();

    // 根据卡号查询押金
    int selectDepositById(int cardNumber);

    // 根据卡号查询用户
    User selectUserById(int cardNumber);
}
