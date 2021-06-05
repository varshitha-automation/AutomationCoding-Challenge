package com.qa.pippin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pippin.TestUtil.Util;

public class orderDetailPage {
	
	private WebDriver driver;

	public orderDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="ordDetBtnSendMsg")
	WebElement msg;	
	
	@FindBy(id="msg-area")
	WebElement msgArea;	
	
	@FindBy(id="msgSend")
	WebElement send;	
	
	@FindBy(xpath="//input[@id='Order_ID']")
	WebElement orderId;
	
	@FindBy(xpath="//textarea[@id='File_ID']")
	WebElement fileId;
	
	@FindBy(xpath="//input[@id='Order_Time']")
	WebElement orderTime;
	
	@FindBy(xpath="//icon[@icon='arrow_drop_down']")
	WebElement icon;
	
	
	
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
	
	public void sendMsg() throws InterruptedException
	{
		clickIntercepted(msg);
		Thread.sleep(9000);
		String orderID = orderId.getAttribute("ng-reflect-value");
		String fileID = fileId.getAttribute("ng-reflect-value");
		String time = orderTime.getAttribute("ng-reflect-value");
		msgArea.sendKeys("varshitha" + Keys.ENTER + orderID + Keys.ENTER + fileID + Keys.ENTER + time + "23:52");
	}
	
	public void send()
	{
		clickIntercepted(send);
	}
	
	public void logout()
	{
		clickIntercepted(icon);
		Util util = new Util(driver);
		util.logOut("Logout");
	}

}
