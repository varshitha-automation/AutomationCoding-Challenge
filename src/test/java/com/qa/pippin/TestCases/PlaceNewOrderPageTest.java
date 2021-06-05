package com.qa.pippin.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippin.TestBase.Base;
import com.qa.pippin.TestUtil.Util;
import com.qa.pippin.pages.HomePage;
import com.qa.pippin.pages.LoginPage;
import com.qa.pippin.pages.PlaceNewOrderPage;
import com.qa.pippin.pages.PlaceOrderPage;
import com.qa.pippin.pages.orderDetailPage;

public class PlaceNewOrderPageTest extends Base{
	
	private WebDriver driver;
	HomePage homepage;
	PlaceOrderPage placeorderpage;
	Util util;
	LoginPage loginpage;
	PlaceNewOrderPage placeneworderpage;
	orderDetailPage orderdetailpage;
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		WebDriver driver=initialization();
		this.driver = driver;
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		placeorderpage = new PlaceOrderPage(driver);
		placeneworderpage = new PlaceNewOrderPage(driver);
		util = new Util(driver);
		homepage=loginpage.login();
		placeorderpage=homepage.placeOrder();
		placeneworderpage=placeorderpage.place();
	}
	
	@Test
	public void acceptTest()
	{
		placeneworderpage.scroll();
		orderdetailpage=placeneworderpage.Submit();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
