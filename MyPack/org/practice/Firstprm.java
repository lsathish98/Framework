package org.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Firstprm {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Practice\\Framework\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement txtResult = driver.findElement(By.xpath("(//*[contains(text(),'Create')])[2]"));
		String filepath="F:\\Selenium Practice\\Framework\\Extentreport\\firstreport.html";
		ExtentHtmlReporter report=new ExtentHtmlReporter(filepath);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		ExtentTest logger = extent.createTest("First TestCase");
		if(txtResult.getText().contains("Create"))
		{
			logger.log(Status.PASS, "Testcase passed"); }
			else
			{
				logger.log(Status.FAIL, "Testcase failed");
		}
		extent.flush();
	}

}
