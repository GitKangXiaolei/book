package com.example.book.util;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.*;

/**
 * https://www.jianshu.com/p/6e153a5db41d
 */
public class ExcelUtils {
    /**
     * 创建excel并填入数据
     * @author 康晓磊
     * @date 2017年11月24日 下午5:25:13
     * @param head 数据头
     * @param body 主体数据
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook expExcel(JSONArray head, JSONArray body) {
        /**
         * 1.创建 Excel 文件对象
         */
        HSSFWorkbook workbook = new HSSFWorkbook();
        /**
         * 2.使用 workbook 对象创建工作表单对象
         */
        HSSFSheet sheet = workbook.createSheet("图书借阅信息");
        /**
         * 3.使用 sheet 对象创建（行）对象
         */
        HSSFRow row = sheet.createRow(0);
        /**
         * 4.声明（单元格）对象
         */
        HSSFCell cell = null;
        /**
         * 5.使用 workbook 对象创建单元格样式对象（边框、对齐方式等）
         */
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        // 设置边框（细边框）
        setBorderStyle(cellStyle, BorderStyle.THIN);
        // 设置字体样式(字体、高度)，将字体应用于单元格样式中
        cellStyle.setFont(setFontStyle(workbook, "黑体", (short) 14));
        // 设置对齐方式（居中）
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        /**
         * 6.将数据头填入Excel中
         */
        for (int i = 0; i < head.size(); i++) {
            // 使用 row 对象创建（单元格）对象,参数为列索引
            cell = row.createCell(i);
            // 设置单元格的值
            cell.setCellValue(head.getString(i));
            // 将样式应用于单元格
            cell.setCellStyle(cellStyle);
        }
        // 使用 workbook 对象创建单元格样式对象（边框、对齐方式等）
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        // 设置边框（细边框）
        setBorderStyle(cellStyle2, BorderStyle.THIN);
        // 设置字体样式(字体、高度)，将字体应用于单元格样式中
        cellStyle2.setFont(setFontStyle(workbook, "宋体", (short) 12));
        // 设置对齐方式（居中）
        cellStyle2.setAlignment(HorizontalAlignment.CENTER);
        /**
         * 7.将主体数据填入Excel中
         */
        for (int i = 0, isize = body.size(); i < isize; i++) {
            // 使用 sheet 对象创建（行）对象
            row = sheet.createRow(i + 1);
            JSONArray stuInfo = body.getJSONArray(i);
            for (int j = 0, jsize = stuInfo.size(); j < jsize; j++) {
                // 使用 row 对象创建（单元格）对象,参数为列索引
                cell = row.createCell(j);
                // 设置单元格的值
                cell.setCellValue(stuInfo.getString(j));
                // 将样式应用于单元格
                cell.setCellStyle(cellStyle2);
            }
        }
        for (int i = 0, isize = head.size(); i < isize; i++) {
            // 自动调整列宽
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

    /**
     * 文件输出
     * @author 康晓磊
     * @date 2017年11月24日 下午5:26:23
     * @param workbook 填充好的workbook
     * @param path 存放的位置
     */
    public static void outFile(HSSFWorkbook workbook, String path) {
        try(OutputStream out = new FileOutputStream(path)) {
            workbook.write(out);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置字体样式
     * @author 康晓磊
     * @date 2017年11月24日 下午3:27:03
     * @param workbook 工作簿
     * @param name 字体类型
     * @param height 字体大小
     * @return HSSFFont
     */
    private static HSSFFont setFontStyle(HSSFWorkbook workbook, String name, short height) {
        // 使用 workbook 对象创建字体对象
        HSSFFont font = workbook.createFont();
        // 高度
        font.setFontHeightInPoints(height);
        // 字体
        font.setFontName(name);
        return font;
    }

    /**
     * 设置单元格样式
     * @author 康晓磊
     * @date 2017年11月24日 下午3:26:24
     * @param cellStyle 样式对象
     * @param border border样式
     */
    private static void setBorderStyle(HSSFCellStyle cellStyle, BorderStyle border) {
        // 设置边框
        cellStyle.setBorderBottom(border); // 下边框
        cellStyle.setBorderLeft(border);// 左边框
        cellStyle.setBorderTop(border);// 上边框
        cellStyle.setBorderRight(border);// 右边框
    }
}
