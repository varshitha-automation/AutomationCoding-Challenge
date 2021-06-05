package com.qa.pippin.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippin.TestBase.Base;
import com.qa.pippin.pages.HomePage;
import com.qa.pippin.pages.LoginPage;


public class LoginPageTest extends Base {
	
	private WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		WebDriver driver=initialization();
		this.driver=driver;
		loginpage = new LoginPage(driver);
	}
	
	@Test
	public void login()
	{
		homepage=loginpage.login();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
