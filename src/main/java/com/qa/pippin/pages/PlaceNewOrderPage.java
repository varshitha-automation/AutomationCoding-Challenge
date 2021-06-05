package com.qa.pippin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pippin.TestBase.Base;

public class PlaceNewOrderPage extends Base {
	
private WebDriver driver;
	
	public PlaceNewOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//label[@for='mat-checkbox-1-input']")
	WebElement radioBtn;
	
	@FindBy(xpath="//div[@class='css-11bp94m css-j00u3e']/button[2]")
	WebElement submitBtn;
	
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
	
	public orderDetailPage Submit()
	{
		if(!radioBtn.isSelected())
		{
			//radioBtn.click();
			clickIntercepted(radioBtn);
		}
		clickIntercepted(submitBtn);
		return new orderDetailPage(driver);
	}
	
	/*public void Submit()
	{
		//submitBtn.click();
		clickIntercepted(submitBtn);
	}*/
	
	public void scroll()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	}

}
