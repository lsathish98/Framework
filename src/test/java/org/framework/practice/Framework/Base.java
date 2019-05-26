package org.framework.practice.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public static void getBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Practice\\Framework\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void sendData(WebElement element, String data)
	{
		element.sendKeys(data);
	}

	public static void clickElement(WebElement element)
	{
		element.click();
	}
	
	public static void quitBrowser()
	{
		driver.quit();
	}
}
