package com.qa.pippin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pippin.TestBase.Base;

public class HomePage extends Base{
	
private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//strong[text()='Place Order']")
	WebElement palceOrder;
	
	public PlaceOrderPage placeOrder()
	{
		clickIntercepted(palceOrder);
		return new PlaceOrderPage(driver);
	}
	
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
}
