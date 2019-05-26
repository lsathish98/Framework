package org.framework.withoutpagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FB_Login_OR extends FunctionLibrary{
	
public WebElement txtUserName()
{ WebElement gettxtUserName = driver.findElement(By.xpath("//input[starts-with(@name,'email')]")); return gettxtUserName; }

public WebElement txtPassword()
{ WebElement gettxtPassword = driver.findElement(By.cssSelector("[id='pass']")); return gettxtPassword; }

public WebElement btnLogin()
{ WebElement getbtnLogin = driver.findElement(By.cssSelector("[value='Log In']")); return getbtnLogin; }



}




