package org.framework.withoutpagefactory;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BusinessLogics extends FunctionLibrary {

	FB_Login_OR login = new FB_Login_OR();
	FB_Registration_OR registration = new FB_Registration_OR();

	@BeforeClass
	public static void beforeClass() {
		invokeBrowser("https://www.facebook.com");
		maximizeScreen();
	}

	@Before
	public void beforeMethod() {
		Date d = new Date();
		System.out.println("Before Execution: " + d);
	}

	@Test
	public void myLogic() throws Exception {

		/******* Login ******
		sendKeys(login.txtUserName(), getData3().get(1));
		sendKeys(login.txtPassword(), getData4().get(1).get("Lname"));
		click(login.btnLogin());*/
		
		// ******* Registration ******
		sendKeys(registration.txtFirstName(), getData4().get(1).get("Fname"));
		sendKeys(registration.txtLastName(), getData4().get(1).get("Lname"));
		sendKeys(registration.txtMobNum(), getData4().get(1).get("Mobile"));
		sendKeys(registration.txtNewPwd(), getData4().get(1).get("Pwd"));
		selectByText(registration.drpDay(), getData4().get(1).get("Day"));
		selectByText(registration.drpMonth(), getData4().get(1).get("Mon"));
		selectByText(registration.drpYear(), getData4().get(1).get("Year"));
		click(registration.radSex());
		click(registration.btnSignup());
		
		
		
		
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
