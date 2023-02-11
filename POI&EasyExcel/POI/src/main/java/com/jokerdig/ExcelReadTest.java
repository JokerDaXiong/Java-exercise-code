package com.jokerdig;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Joker大雄
 * @data 2022/8/30 - 13:19
 **/
public class ExcelReadTest {
    // 存放路径
    String PATH= "D:\\Project\\project3\\POI&EasyExcel\\excel\\";

    // 03版本读excel
    @Test
    public void testRead03() throws IOException {
        // 获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "学习信息统计03.xls");
        // 创建工作簿
        Workbook workbook = new HSSFWorkbook(inputStream);
        // 得到表
        Sheet sheetAt = workbook.getSheetAt(0);
        // 得到行
        Row row = sheetAt.getRow(0);
        // 得到单元格
        Cell cell = row.getCell(0);
        // 获取值的时候，一定要注意类型要对应
        System.out.println(cell.getStringCellValue());
        inputStream.close();
    }
    // 07版本读excel
    @Test
    public void testRead07() throws IOException {
        // 获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "学习信息统计07.xlsx");
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);
        // 得到表
        Sheet sheetAt = workbook.getSheetAt(0);
        // 得到行
        Row row = sheetAt.getRow(0);
        // 得到单元格
        Cell cell = row.getCell(0);
        // 获取值的时候，一定要注意类型要对应
        System.out.println(cell.getStringCellValue());
        inputStream.close();
    }

    // 读取不同类型的数据
    @Test
    public void testReadCellType()throws IOException{
        // 获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "information.xlsx");
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        // 获取标题内容
        Row rowTitle = sheetAt.getRow(0);
        if(rowTitle!=null){
            // 获取总数
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellCount-1; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if(cell!=null){
                    int cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue+" | ");
                }
            }
            System.out.println();
        }
        // 获取表中数据
        int rowCount = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheetAt.getRow(rowNum);
            if(rowData!=null){
                // 读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    // System.out.print("["+(rowNum+1)+"-"+(cellNum+1)+"]");
                    Cell cell = rowData.getCell(cellNum);
                    // 匹配列的数据类型
                    if(cell!=null){
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType){
                                // 字符串
                            case XSSFCell.CELL_TYPE_STRING:
                                System.out.print("[String]");
                                cellValue = cell.getStringCellValue();
                                break;
                                // 布尔值
                            case XSSFCell.CELL_TYPE_BOOLEAN:
                                System.out.print("[Boolean]");
                                cellValue =String.valueOf(cell.getBooleanCellValue());
                                break;
                                // 数字
                            case XSSFCell.CELL_TYPE_NUMERIC:
                                System.out.print("[Numeric]");
                                // 数字类型 日期 普通数字
                                if(DateUtil.isCellDateFormatted(cell)){
                                    Date date = cell.getDateCellValue();
                                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    cellValue = format.format(date);
                                }else{
                                    // 普通数字
                                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                                // 为空
                            case XSSFCell.CELL_TYPE_BLANK:
                                System.out.print("[Blank]");
                                break;
                                // error
                            case XSSFCell.CELL_TYPE_ERROR:
                                System.out.print("[Error]");
                                break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        inputStream.close();
    }

    // 了解计算公式
    @Test
    public void testFormula() throws IOException {
        // 获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + "sum.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(4);
        XSSFCell cell = row.getCell(0);
        // 拿到计算公式
        XSSFFormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(workbook);

        // 输出单元格内容
        int cellType = cell.getCellType();
        switch(cellType){
            case Cell.CELL_TYPE_FORMULA:
                String cellFormula = cell.getCellFormula();
                System.out.println(cellFormula);
                // 计算
                CellValue evaluate = formulaEvaluator.evaluate(cell);
                String cellValue = evaluate.formatAsString();
                System.out.println(cellValue);
                break;
        }
    }

}
