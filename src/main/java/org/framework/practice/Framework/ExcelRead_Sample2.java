package org.framework.practice.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Sample2 {

	static String name = "";

	public String readData(int r, int c) throws Exception {
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet s = w.getSheet("TestData");
		Row r2 = s.getRow(r);
		Cell c2 = r2.getCell(c);
		int ct = c2.getCellType();
		if (ct == 0) {
			if (DateUtil.isCellDateFormatted(c2))
			{
				SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
				name = form.format(c2.getDateCellValue());

			} else {
				double d = c2.getNumericCellValue();
				long l = (long) d;
				name = String.valueOf(l);

			}
		}

			if (ct == 1) {
				name = c2.getStringCellValue();
				
			}
			return name;
		}
		
	

	public static void main(String[] args) throws Exception {
		
		ExcelRead_Sample2 ek=new ExcelRead_Sample2();
		
		System.out.println(ek.readData(0,0));
		System.out.println(ek.readData(1,1));
		System.out.println(ek.readData(2,1));
		
		
	}
}
