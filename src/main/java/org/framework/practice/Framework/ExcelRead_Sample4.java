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

public class ExcelRead_Sample4 {

	static String name = "";

	public String getData() throws Exception {
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet s = w.getSheet("TestData");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c2 = r.getCell(j);
				int ct = c2.getCellType();
				if (ct == 0) {
					if (DateUtil.isCellDateFormatted(c2)) {
						SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
						name = form.format(c2.getDateCellValue());
						System.out.println(name);

					} else {
						double d = c2.getNumericCellValue();
						long l = (long) d;
						name = String.valueOf(l);
						System.out.println(name);

					}
				}

				if (ct == 1) {
					name = c2.getStringCellValue();
					System.out.println(name);

				}

			}
		}
		return name;
	}



	public static void main(String[] args) throws Exception 
	{
		ExcelRead_Sample4 sd=new ExcelRead_Sample4();
		System.out.println(sd.getData());
}
}