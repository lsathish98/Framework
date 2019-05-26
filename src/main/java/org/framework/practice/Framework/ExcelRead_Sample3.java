package org.framework.practice.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Sample3 {
	public static void main(String[] args) throws Throwable {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		String name="";
		try {
			File excelLocaltion = new File("F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx");
			String sheetName = "TestData";
			FileInputStream f = new FileInputStream(excelLocaltion);
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					int ct = currentCell.getCellType();
					switch (ct) {
					case Cell.CELL_TYPE_STRING:
						if(ct==1)
						{
							name=currentCell.getStringCellValue();
						mapDatas.put(headerRow.getCell(j).getStringCellValue(), name);
						}
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if(ct==0)
						{ 
							if(DateUtil.isCellDateFormatted(currentCell))
							{
								SimpleDateFormat form=new SimpleDateFormat("dd-MMM-yy");
								name = form.format(currentCell.getDateCellValue());
							}
							else
							{
								double d = currentCell.getNumericCellValue();
								long l=(long) d;
								name = String.valueOf(l);
							}
							
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								name);
						}
						break;
					}
				}
				mapDatasList.add(mapDatas);
			}
// System.out.println(mapDatasList);
			
			System.out.println(mapDatasList.get(1).get("TestCase"));
			System.out.println(mapDatasList.get(3).get("Name"));
			System.out.println(mapDatasList.get(1).get("Mail"));
			System.out.println(mapDatasList.get(1).get("Address"));
			System.out.println(mapDatasList.get(1).get("DOB"));
			System.out.println(mapDatasList.get(1).get("Phone#"));
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
