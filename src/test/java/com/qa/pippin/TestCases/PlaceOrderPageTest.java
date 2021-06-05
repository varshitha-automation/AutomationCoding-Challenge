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

public class PlaceOrderPageTest extends Base{
	
	private WebDriver driver;
	HomePage homepage;
	PlaceOrderPage placeorderpage;
	Util util;
	LoginPage loginpage;
	PlaceNewOrderPage placeneworderpage;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		WebDriver driver=initialization();
		this.driver = driver;
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		placeorderpage = new PlaceOrderPage(driver);
		util = new Util(driver);
		homepage=loginpage.login();
		placeorderpage=homepage.placeOrder();
	}
	
	@Test
	public void pippingTest() throws InterruptedException
	{
		Thread.sleep(9000);
		util.commonProduct("Full Search");
		placeorderpage.scroll();
		util.searchCriteria("Full Address");
		placeorderpage.owner();
		util.autoComplete("Auto Complete");
		placeorderpage.searchBox();
		placeorderpage.scroll();
		placeorderpage.client();
		placeorderpage.uploadDoc();
		Thread.sleep(20000);
		placeorderpage.deleteName("Area");
		placeorderpage.deleteName("Zone");
		placeneworderpage=placeorderpage.continueBtn();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
