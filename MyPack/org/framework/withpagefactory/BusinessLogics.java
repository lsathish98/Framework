package org.framework.withpagefactory;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;



public class BusinessLogics extends ObjectRepository {

	@BeforeClass
	public static void beforeClass() {
		invokeBrowser("https://www.facebook.com");
	}

	@Before
	public  void beforeMethod() {
		Date d = new Date();
		System.out.println("Before Execution: " + d);
	}

	@Test
	public void myLogic() throws Exception {

		
	
		
		maximizeScreen();
		sendKeys(getTxtFirstName(), getData3().get(1));
		sendKeys(getTxtLastName(), "ball");
		sendKeys(getTxtMobNum(), getData4().get(1).get("Mobile"));
		sendKeys(getTxtNewPwd(), "258errors");
		selectByText(getDrpDay(), "10");
		selectByText(getDrpMonth(), "Jun");
		selectByValue(getDrpYear(), "1993");
		click(getRadSex());
		click(getBtnSignup());
		
	}

	@After
	public void afterMethod() {
		Date d = new Date();
		System.out.println("After Execution: " + d);
	}

	@AfterClass
	public static void afterClass() {
		quit();
	}

}
