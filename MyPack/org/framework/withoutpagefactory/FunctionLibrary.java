package org.framework.withoutpagefactory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {

	public static WebDriver driver;
	public static String chromeDriverPath = "F:\\Selenium Practice\\Framework\\driver\\chromedriver.exe";
	public static Select s = null;
	public static Actions acc = null;
	public static Robot r = null;

	public static WebDriver invokeBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

	public static void maximizeScreen() {
		driver.manage().window().maximize();
	}

	public static void sendKeys(WebElement element, String name) {
		element.sendKeys(name);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectByText(WebElement element, String name) {
		s = new Select(element);
		s.selectByVisibleText(name);
	}

	public static void selectByIndex(WebElement element, int name) {
		s = new Select(element);
		s.selectByIndex(name);
	}

	public static void selectByValue(WebElement element, String name) {
		s = new Select(element);
		s.selectByValue(name);
	}

	public static String randomAlpha() {
		String random = RandomStringUtils.randomAlphanumeric(5);
		return random;
	}

	public static void screenShot() throws Exception {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f1 = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("F:\\Selenium Practice\\Framework\\Screenshots\\" + randomAlpha() + ".jpg"));
	}

	public static void moveToElement(WebElement element) {
		acc = new Actions(driver);
		acc.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement element1, WebElement element2) {
		acc = new Actions(driver);
		acc.dragAndDrop(element1, element2).perform();
	}

	public static void contextClick(WebElement element) {
		acc = new Actions(driver);
		acc.contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		acc = new Actions(driver);
		acc.doubleClick(element).perform();
	}

	public static void robotDown() throws Throwable {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void robotUp() throws Throwable {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public static void robotEnter() throws Throwable {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void explicitWaitClick(WebElement element, By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
	
	
	// Read Excel - Method 1
	public static void getData() throws Exception {
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet sh = w.getSheet("TestData");
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row r = sh.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int ct = c.getCellType();
				String name = "";
				switch (ct) {
				case Cell.CELL_TYPE_NUMERIC:
					if (ct == 0) {
						if (DateUtil.isCellDateFormatted(c)) {
							SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
							name = form.format(c.getDateCellValue());
							System.out.println(name);
						} else {
							double d = c.getNumericCellValue();
							long l = (long) d;
							name = String.valueOf(l);
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					if (ct == 1) {
						name = c.getStringCellValue();
						System.out.println(name);
					}
				}
			}
		}

	}

	// Read Excel - Method 2
	public static String getData2(int rownum, int cellnum) throws Exception {
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet sh = w.getSheet("TestData");
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(cellnum);
		int ct = c.getCellType();
		String name = "";
		switch (ct) {
		case Cell.CELL_TYPE_NUMERIC:
			if (ct == 0) {
				if (DateUtil.isCellDateFormatted(c)) {
					SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
					name = form.format(c.getDateCellValue());

				} else {
					double d = c.getNumericCellValue();
					long l = (long) d;

				}
			}
			break;
		case Cell.CELL_TYPE_STRING:
			if (ct == 1) {
				name = c.getStringCellValue();

			}
		}
		return name;
	}

	// Read Excel - Method 3
	public static ArrayList<String> getData3() throws Exception {
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		ArrayList<String> a = new ArrayList<String>();
		String name = "";
		int nos = w.getNumberOfSheets();
		for (int i = 0; i < nos; i++) {
			if (w.getSheetName(i).equalsIgnoreCase("TestData")) {
				Sheet sh = w.getSheetAt(i);
				Iterator<Row> rt1 = sh.rowIterator();
				Row r1 = rt1.next();
				Iterator<Cell> ct1 = r1.cellIterator();
				int column = 0, k = 0;
				while (ct1.hasNext()) {
					Cell c1 = ct1.next();
					if (c1.getStringCellValue().equalsIgnoreCase("TestCase")) {
						column = k;
					}
					k++;
				}
				System.out.println("TestCase Column Index: " + column);
				while (rt1.hasNext()) {
					Row r2 = rt1.next();
					if (r2.getCell(column).getStringCellValue().equalsIgnoreCase("TC01")) {
						Iterator<Cell> ct2 = r2.cellIterator();
						while (ct2.hasNext()) {
							Cell c3 = ct2.next();
							int ct = c3.getCellType();
							switch (ct) {
							case Cell.CELL_TYPE_NUMERIC:
								if (ct == 0) {
									if (DateUtil.isCellDateFormatted(c3)) {
										SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
										name = form.format(c3.getDateCellValue());

									} else {
										double d = c3.getNumericCellValue();
										long l = (long) d;
										name = String.valueOf(l);

									}
								}
								break;
							case Cell.CELL_TYPE_STRING:
								if (ct == 1) {
									name = c3.getStringCellValue();

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

	// Read Excel - Method 4

	public static List<HashMap<String, String>> getData4() throws Exception {
		ArrayList<HashMap<String, String>> mapDataList = new ArrayList<HashMap<String, String>>();
		String filepath = "F:\\Selenium Practice\\Framework\\TestData\\TestData.xlsx";
		File f = new File(filepath);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet sht = w.getSheet("TestData");
		Row headerRow = sht.getRow(0);
		for (int i = 0; i < sht.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sht.getRow(i);
			HashMap<String, String> mapData = new HashMap<String, String>();
			for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
				Cell currentCell = currentRow.getCell(j);
				int ct = currentCell.getCellType();
				String name = "";
				switch (ct) {
				case Cell.CELL_TYPE_NUMERIC:
					if (ct == 0) {
						if (DateUtil.isCellDateFormatted(currentCell)) {
							SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yy");
							name = form.format(currentCell.getDateCellValue());

						} else {
							double d = currentCell.getNumericCellValue();
							long l = (long) d;
							name = String.valueOf(l);
						}
					}
					mapData.put(headerRow.getCell(j).getStringCellValue(), name);

					break;
				case Cell.CELL_TYPE_STRING:
					if (ct == 1) {
						name = currentCell.getStringCellValue();
					}
					mapData.put(headerRow.getCell(j).getStringCellValue(), name);
					break;
				}
			}
			mapDataList.add(mapData);
		}
		return mapDataList;
	}

	public static void quit() {
		driver.quit();
	}

}
