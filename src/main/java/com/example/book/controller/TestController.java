package com.example.book.controller;

import com.alibaba.fastjson.JSON;
import com.example.book.entity.Borrowing;
import com.example.book.service.BorrowService;
import com.example.book.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    BorrowService borrowService;

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
//        Gson gson = new Gson();
        if (borrowService.borrowService(c, b)) {
            Borrowing bo = borrowService.findBorrowing(borrowService.findBorrowId(c, b));
//            ExcelUtils.outFile(ExcelUtils.expExcel(), "ONE");
            return JSON.toJSONString(bo);
//            return gson.toJson(borrowService.findBorrowing(borrowService.findBorrowId(c, b)));
        } else {
            return JSON.toJSONString("借阅失败");
//            return gson.toJson("借阅失败！");
        }
    }
}