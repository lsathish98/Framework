package org.framework.withoutpagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FB_Registration_OR extends FunctionLibrary {
	
	public WebElement txtFirstName()
	{ WebElement gettxtFirstName = driver.findElement(By.cssSelector("[name='firstname']")); return gettxtFirstName; }
	
	public WebElement txtLastName()
	{ WebElement gettxtLastName = driver.findElement(By.cssSelector("[name='lastname']")); return gettxtLastName; }
	
	public WebElement txtMobNum()
	{ WebElement gettxtMobNum = driver.findElement(By.cssSelector("[name='reg_email__']")); return gettxtMobNum 	; }
	
	public WebElement txtNewPwd()
	{ WebElement gettxtNewPwd = driver.findElement(By.cssSelector("[name='reg_passwd__']")); return gettxtNewPwd 	; }
	
	public WebElement drpDay()
	{ WebElement getdrpDay = driver.findElement(By.id("day")); return getdrpDay;}
	
	public WebElement drpMonth()
	{ WebElement getdrpMonth = driver.findElement(By.id("month")); return getdrpMonth;}
	
	public WebElement drpYear()
	{ WebElement getdrpYear = driver.findElement(By.id("year")); return getdrpYear;}
	
	public WebElement radSex()
	{ WebElement getradSex = driver.findElement(By.cssSelector("[id='u_0_a']")); return getradSex 	; }
	
	public WebElement btnSignup()
	{ WebElement getbtnSignup = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]")); return getbtnSignup;}
	
	

}
