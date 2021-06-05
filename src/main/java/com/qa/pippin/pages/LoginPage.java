package com.qa.pippin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pippin.TestBase.Base;

public class LoginPage extends Base{
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="Email_Address")
	WebElement username;
	
	@FindBy(id="User_Password")
	WebElement password;
	
	@FindBy(id="loginBtnLogin")
	WebElement loginBtn;
	
	public HomePage login()
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage(driver);
	}
}
