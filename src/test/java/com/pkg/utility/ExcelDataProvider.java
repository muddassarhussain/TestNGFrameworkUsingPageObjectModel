package com.pkg.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {

    File src;
    FileInputStream fis;
    XSSFWorkbook xwb;

    //Constructor
    public ExcelDataProvider() {
        src = new File("./Test Data/TestDataWorkBook.xlsx");
        try {
            fis = new FileInputStream(src);
            xwb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to read excel file" +e.getMessage());
        }
    }

    //Method to read data from Excel by Index
    public String getExcelStringData(int sheetIndex, int rowNumber, int colNumber) {
        //Navigate to Workbook and get row and get column for specific sheet by index
        return xwb.getSheetAt(sheetIndex).getRow(rowNumber).getCell(colNumber).getStringCellValue();
    }

    //Method to read String data from Excel
    public String getExcelStringData(String sheetName, int rowNumber, int colNumber) {
        //Navigate to Workbook and get row and get column for specific sheet
        return xwb.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getStringCellValue();
    }

    //Method to read Integer data from Excel
    public double getExcelIntegerData(String sheetName, int rowNumber, int colNumber) {
        //Navigate to Workbook and get row and get column for specific sheet
        return xwb.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getNumericCellValue();
    }
}
