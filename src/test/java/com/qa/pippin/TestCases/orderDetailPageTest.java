package com.qa.pippin.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.pippin.Listener.listen;
import com.qa.pippin.TestBase.Base;
import com.qa.pippin.TestUtil.Util;
import com.qa.pippin.pages.HomePage;
import com.qa.pippin.pages.LoginPage;
import com.qa.pippin.pages.PlaceNewOrderPage;
import com.qa.pippin.pages.PlaceOrderPage;
import com.qa.pippin.pages.orderDetailPage;

@Listeners(listen.class)

public class orderDetailPageTest extends Base{
	
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
		orderdetailpage=placeneworderpage.Submit();
	}
	
	@Test
	public void sendMsgTest() throws InterruptedException
	{
		orderdetailpage.sendMsg();
		orderdetailpage.send();
		orderdetailpage.logout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
