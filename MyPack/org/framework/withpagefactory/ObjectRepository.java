package org.framework.withpagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository extends FunctionLibrary {

	public ObjectRepository() {
		PageFactory.initElements(driver, this);
	}

	// Login
	@FindBy(xpath = "//input[starts-with(@name,'email')]")
	public WebElement txtUserName;

	@FindBy(css = "[id='pass']")
	public WebElement txtPassword;

	@FindBy(css = "[value='Log In']")
	public WebElement btnLogin;

	// Sign Up
	@FindBy(css = "[name='firstname']")
	public WebElement txtFirstName;

	@FindBy(css = "[name='lastname']")
	public WebElement txtLastName;

	@FindBy(css = "[name='reg_email__']")
	public WebElement txtMobNum;
	
	@FindBy(css = "[name='reg_passwd__']")
	public WebElement txtNewPwd;
	
	@FindBy(id = "day")
	public WebElement drpDay;

	@FindBy(id = "month")
	public WebElement drpMonth;

	@FindBy(id = "year")
	public WebElement drpYear;

	@FindBy(css = "[id='u_0_a']")
	public WebElement radSex;

	@FindBy(xpath = "(//button[text()='Sign Up'])[1]")
	public WebElement btnSignup;

	// Sign Up

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}


	public WebElement getTxtNewPwd() {
		return txtNewPwd;
	}
	
	public WebElement getTxtMobNum() {
		return txtMobNum;
	}

	public WebElement getDrpDay() {
		return drpDay;
	}

	public WebElement getDrpMonth() {
		return drpMonth;
	}

	public WebElement getDrpYear() {
		return drpYear;
	}

	public WebElement getRadSex() {
		return radSex;
	}

	public WebElement getBtnSignup() {
		return btnSignup;
	}

	// Login
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
}
