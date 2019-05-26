package org.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {
	
	public static WebDriver driver;
	public static Set<String> childWindows;
	public static String parentWindow;
	
	public static void switchWindow(int count)
	{	String navigate=null;
		 childWindows = driver.getWindowHandles();
		 Iterator<String> iter = childWindows.iterator();
		 for (int i = 0; i <=count; i++) {
			navigate = iter.next();
		}
		 driver.switchTo().window(navigate);
	}
	
	public static void main(String[] args) {
		
		//WindowsHandle win=new WindowsHandle();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Practice\\Framework\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[class='_2AkmmA _29YdH8'")).click();
		driver.findElement(By.cssSelector("[class='LM6RPg']")).sendKeys("iphone6");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone')])[1]")).click();
		parentWindow = driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone')])[2]")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone')])[3]")).click();
		driver.switchTo().window(parentWindow);
		switchWindow(2);
		
	}

}
