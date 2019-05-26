package org.framework.practice.Framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryTrack extends Base{
	
	public PageFactoryTrack() {
	
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[id='email']")
	public WebElement userId;
	
	@FindBy(css="[id='pass']")
	public WebElement userPassword;
	
	@FindBy(css="[value='Log In']")
	public WebElement userClick;

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getUserClick() {
		return userClick;
	}
	
}
