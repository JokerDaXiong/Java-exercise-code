package com.jokerdig;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Joker大雄
 * @data 2022/8/30 - 10:34
 **/
public class ExcelWriteTest {
    // 存放路径
    String PATH= "D:\\Project\\project3\\POI&EasyExcel\\excel\\";

    // 03版本的excel
    @Test
    public void testWrite03() throws IOException {
        // 1. 创建工作簿
        Workbook workbook = new HSSFWorkbook();
        // 2. 创建工作表
        Sheet sheet = workbook.createSheet("学习统计表");
        // 3. 创建第一行
        Row row1 = sheet.createRow(0);
        // 4. 创建单元格
        Cell cell1_1 = row1.createCell(0);
        // 5. 写入值
        cell1_1.setCellValue("今日学习时间");
        // 第二个单元格
        Cell cell1_2 = row1.createCell(1);
        // 时间工具类
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell1_2.setCellValue(time);
        // 创建第二行
        Row row2 = sheet.createRow(1);
        Cell cell2_1 = row2.createCell(0);
        cell2_1.setCellValue("今日学习进度");
        Cell cell2_2 = row2.createCell(1);
        cell2_2.setCellValue("60%");
        // 6. 生成Excel表 03版本使用.xls
        FileOutputStream outputStream = new FileOutputStream(PATH + "学习信息统计03.xls");
        workbook.write(outputStream);
        // 关闭流
        outputStream.close();
        System.out.println("03Excel生成完毕");
    }
    // 07版本的excel
    @Test
    public void testWrite07() throws IOException {
        // 1. 创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建工作表
        Sheet sheet = workbook.createSheet("学习统计表");
        // 3. 创建第一行
        Row row1 = sheet.createRow(0);
        // 4. 创建单元格
        Cell cell1_1 = row1.createCell(0);
        // 5. 写入值
        cell1_1.setCellValue("今日学习时间");
        // 第二个单元格
        Cell cell1_2 = row1.createCell(1);
        // 时间工具类
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell1_2.setCellValue(time);
        // 创建第二行
        Row row2 = sheet.createRow(1);
        Cell cell2_1 = row2.createCell(0);
        cell2_1.setCellValue("今日学习进度");
        Cell cell2_2 = row2.createCell(1);
        cell2_2.setCellValue("60%");
        // 6. 生成Excel表 07版本使用.xlsx
        FileOutputStream outputStream = new FileOutputStream(PATH + "学习信息统计07.xlsx");
        workbook.write(outputStream);
        // 关闭流
        outputStream.close();
        System.out.println("07Excel生成完毕");
    }

    // 大文件写03
    @Test
    public void testWrite03BigData() throws IOException {
        // 时间
        long begin = System.currentTimeMillis();
        // 创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        // 创建表
        Sheet sheet = workbook.createSheet();
        // 写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("数据写入完成");
        FileOutputStream outputStream = new FileOutputStream(PATH + "testWrite03BigData.xls");
        workbook.write(outputStream);
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    // 大文件写07
    @Test
    public void testWrite07BigData() throws IOException {
        // 时间
        long begin = System.currentTimeMillis();
        // 创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建表
        Sheet sheet = workbook.createSheet();
        // 写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("数据写入完成");
        FileOutputStream outputStream = new FileOutputStream(PATH + "testWrite07BigData.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    // 大文件写07加速
    @Test
    public void testWrite07BigDataS() throws IOException {
        // 时间
        long begin = System.currentTimeMillis();
        // 创建一个工作簿
        Workbook workbook = new SXSSFWorkbook();
        // 创建表
        Sheet sheet = workbook.createSheet();
        // 写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("数据写入完成");
        FileOutputStream outputStream = new FileOutputStream(PATH + "testWrite07BigDataS.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        // 关闭临时文件
        ((SXSSFWorkbook)workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
}
