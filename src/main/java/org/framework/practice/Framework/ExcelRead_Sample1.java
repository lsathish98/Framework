package org.framework.practice.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Sample1 {

	static String name = "";

	public ArrayList<String> getData(String testcasenumber) throws Throwable {
		ArrayList<String> a=new ArrayList<String>();
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		int nos = w.getNumberOfSheets();
		for (int i = 0; i < nos; i++) {
			if (w.getSheetName(i).equalsIgnoreCase("TestData")) {
				Sheet s = w.getSheetAt(i);
				Iterator<Row> rt1 = s.rowIterator();
				Row r1 = rt1.next();
				Iterator<Cell> ct1 = r1.cellIterator();
				int column = 0, k = 0;
				while (ct1.hasNext()) {
					ct1.next().getStringCellValue().equalsIgnoreCase("TestCase");
					column = k;
				}
				k++;
				System.out.println("TestCase Column Index Is: " + column);
				while (rt1.hasNext()) {
					Row r2 = rt1.next();
					if (r2.getCell(column).getStringCellValue().equalsIgnoreCase(testcasenumber)) {
						Iterator<Cell> ct2 = r2.cellIterator();
						while (ct2.hasNext()) {
							Cell c2 = ct2.next();
							int ct = c2.getCellType();
							switch (ct) {
							case Cell.CELL_TYPE_NUMERIC:
								if (ct == 0) {
									if (DateUtil.isCellDateFormatted(c2)) {
										SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
										name = form.format(c2.getDateCellValue());
										
									} else {
										double d = c2.getNumericCellValue();
										long l = (long) d;
										name = String.valueOf(l);
										
									}
								}
							case Cell.CELL_TYPE_STRING:
								if (ct == 1) {
									name = c2.getStringCellValue();
									
								} 
							}
							a.add(name);
						}
					}
				}
			}

		}
return a;
	}

	public static void main(String[] args) throws Throwable {
		
		ExcelRead_Sample1 er=new ExcelRead_Sample1();
		ArrayList<String> data = er.getData("TC01");
		System.out.println(String.valueOf(data.get(0)));
		System.out.println(String.valueOf(data.get(1)));
		System.out.println(String.valueOf(data.get(2)));
		System.out.println(String.valueOf(data.get(3)));
		System.out.println(String.valueOf(data.get(4)));
		System.out.println(String.valueOf(data.get(5)));

	}

}
