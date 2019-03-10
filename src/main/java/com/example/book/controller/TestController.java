package com.example.book.controller;

import com.example.book.service.BorrowService;
import com.example.book.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class TestController {
    @Autowired
    BorrowService borrowService;
    @Autowired
    UserService userService;

    // json与map互相转换
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    @ResponseBody
    public String test(@RequestBody Map<String, Object> param) {
        param.forEach((k, v) -> System.out.println(k + ": " + v));
        return "";
    }

    @RequestMapping(value = "/borrow", method = {RequestMethod.GET})
    @ResponseBody
    public String borrow(@RequestParam int c, @RequestParam int b) {
        borrowService.borrowService(c, b);
        Gson gson = new Gson();
        return gson.toJson(userService.getEntity(c));
    }
}