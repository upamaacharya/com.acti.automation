package com.actitime.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.actitime.base.DriverScript;

public class ExcelLib {
	XSSFWorkbook wb;

	public ExcelLib(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Excel Sheet not found in the path " + e.getMessage());
		}
	}

	public int getRowCount(int sheetnum) {
		return wb.getSheetAt(0).getLastRowNum() + 1;
	}

	public String getCellData(int sheetnum, int row, int col) {
		return wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
	}

}
