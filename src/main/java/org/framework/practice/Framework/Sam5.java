package org.framework.practice.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sam5 {
	
	public static void main(String[] args) throws Exception {
		
		List<HashMap<String, String>> mapDataList=new ArrayList<HashMap<String,String>>();
		String filepath="F:\\Selenium Practice\\Framework\\TestData.xlsx";
		File f=new File(filepath);
		FileInputStream str=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(str);
		Sheet s = w.getSheet("TestData");
		Row headerRow = s.getRow(0);
		for (int i = 0; i < s.getPhysicalNumberOfRows() ; i++) {
			Row currentRow = s.getRow(i);
			HashMap<String, String> mapData=new HashMap<String, String>();
			for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
				Cell currentCell = currentRow.getCell(j);
				int ct = currentCell.getCellType();
				switch (ct) {
				case Cell.CELL_TYPE_STRING:
					mapData.put(headerRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					mapData.put(headerRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
					break;
				
				
				}
			}
			mapDataList.add(mapData);
		}
				
		System.out.println(mapDataList.get(1).get("Name"));
		System.out.println(mapDataList.get(1).get("Mail"));
		
		
		 
	}

}
