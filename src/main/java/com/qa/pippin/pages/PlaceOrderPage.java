package com.qa.pippin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pippin.TestBase.Base;
import com.qa.pippin.TestUtil.Util;

public class PlaceOrderPage extends Base{
	
	private WebDriver driver;
	
	public PlaceOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//mat-radio-group[@aria-labelledby='common-search-types']/mat-radio-button/label/div[2]/span[2]")
	WebElement radioBtn;
	
	@FindBy(xpath="//button[@class='btn btn-primary css-bnepv4']")
	WebElement uploadDoc;
	
	@FindBy(xpath="//mat-radio-group[@aria-labelledby='search-criteria']//label//div[2]/span[2]")
	WebElement searchCriteria;
	
	@FindBy(id="Property_First_Name")
	WebElement ownerName;
	
	@FindBy(xpath="//mat-radio-button[@id='mat-radio-82']//label//div[2]/span[2]")
	WebElement autoComplete;
	
	@FindBy(id="search-box")
	WebElement PropertySearch;
	
	@FindBy(xpath="//div[@class='pac-container pac-logo hdpi']/div[2]")
	List<WebElement> address;
	
	@FindBy(id="Property_Order_Number")
	WebElement clientNum;
	
	@FindBy(id="file-upload")
	WebElement fileUpload;
	
	@FindBy(xpath="//div[@class='p-2']/div/div")
	List<WebElement> text;
	
	@FindBy(xpath="//div[@class='p-2']/div/div")
	List<WebElement> text1;
	
	@FindBy(xpath="//div[@class='p-2']/div/div/../button")
	List<WebElement> delete;
	
	@FindBy(id="Property_State_Abbr")
	WebElement view;
	
	@FindBy(id="conOk")
	WebElement confirmation;
	
	@FindBy(xpath="//button[@color='primary']")
	WebElement Continue;
	
	public PlaceNewOrderPage place() throws InterruptedException
	{
		Util util=new Util(driver);
		Thread.sleep(9000);
		util.commonProduct("Full Search");
		scroll();
		util.searchCriteria("Full Address");
		owner();
		util.autoComplete("Auto Complete");
		searchBox();
		scroll();
		client();
		uploadDoc();
		Thread.sleep(20000);
		deleteName("Area");
		deleteName("Zone");
		clickIntercepted(Continue);
		return new PlaceNewOrderPage(driver);
	}
	
	public PlaceNewOrderPage continueBtn()
	{
		clickIntercepted(Continue);
		return new PlaceNewOrderPage(driver);
	}
	
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
	
	private void waitForElement(WebDriver driver,WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		 .until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void deleteName(String name) throws InterruptedException 
	{
		WebElement t = driver.findElement(By.xpath("//div[@class='p-2']/div/div[contains(text(),'"+name+"')]/../button"));
		waitForElement(driver,t,20);
		clickIntercepted(t);
		Thread.sleep(9000);
		waitForElement(driver,confirmation,20);
		clickIntercepted(confirmation);
	}
	
	public void uploadDoc()
	{
		String file1= "c://Area(s) Day-wise In Report 2021-06-03.pdf";
		String file2= "c://Mall(s) Day-wise In Report 2021-06-03.pdf";
		String file3= "c://Zone(s) Day-wise In Report 2021-06-03.pdf";
		fileUpload.sendKeys(file1 + "\n" + file2 + "\n" + file3);
	}
	
	
	public void owner()
	{
		ownerName.sendKeys("varshitha");
	}
	
	public void searchBox()
	{
		PropertySearch.sendKeys("3485 Wineville");
		for(int i=0;i<address.size();i++)
		{
			String name= address.get(i).getText();
			System.out.println(name);
			address.get(i).click();
		//	clickIntercepted(address.get(i));
		}
	}
	
	public void scroll()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(100,700)");
	}
	
	public void scrollToView(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public void client()
	{
		clientNum.sendKeys("varshitha_03_06_2021");
	}

}
