package com.qa.pippin.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.pippin.Listener.listen;
import com.qa.pippin.TestBase.Base;
import com.qa.pippin.pages.HomePage;
import com.qa.pippin.pages.LoginPage;
import com.qa.pippin.pages.PlaceOrderPage;

@Listeners(listen.class)
public class HomePageTest extends Base{
	
	private WebDriver driver;
	HomePage homepage;
	PlaceOrderPage placeorderpage;
	LoginPage loginpage;
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		WebDriver driver=initialization();
		this.driver = driver;
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		
		homepage=loginpage.login();
	}
	
	@Test
	public void placeTest()
	{
		placeorderpage=homepage.placeOrder();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
