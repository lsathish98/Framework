package org.framework.practice.Framework;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logics extends PageFactoryTrack{
	

	
	@BeforeClass
	public static void beforeClass()
	{
		getBrowser("https://www.facebook.com/");
	}

	@Before
	public  void beforeMethod()
	{
		Date d=new Date();
		System.out.println("Before Exe" +d);
	}
	
	@Test
	public  void executeLogin()
	
	{		
		
		sendData(getUserId(), "java");				
		sendData(getUserPassword(), "welcome");
		clickElement(getUserClick());
	}
	
	@After
	public  void afterMethod()
	{
		Date d=new Date();
		System.out.println("After Exe" +d);
	}
	
	@AfterClass
	public static void afterClass()
	{
		quitBrowser();
	}
	
	
	
}
