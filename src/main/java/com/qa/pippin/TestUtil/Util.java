package com.qa.pippin.TestUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.pippin.TestBase.Base;

public class Util extends Base{
	
	private WebDriver driver;
	
	public Util(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	private void waitForElement(WebDriver driver,WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		 .until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
	
	public void commonProduct(String option)
	{
		List<WebElement> radio1 = driver.findElements(By.xpath("//mat-radio-group[@aria-labelledby='common-search-types']/mat-radio-button/label/div[2]/span[2]"));
		for(int i=0;i<radio1.size();i++)
		{
			String name = radio1.get(i).getText();
			if(name.contains(option))
			{
				radio1.get(i).click();
				break;
			}
		}
	}
	
	public void searchCriteria(String option)
	{
		List<WebElement> radio1 = driver.findElements(By.xpath("//mat-radio-group[@aria-labelledby='search-criteria']//label//div[2]/span[2]"));
		for(int i=0;i<radio1.size();i++)
		{
			String name = radio1.get(i).getText();
			if(name.contains(option))
			{
				waitForElement(driver,radio1.get(i),20);
				clickIntercepted(radio1.get(i));
				//radio1.get(i).click();
				break;
			}
		}
	}
	
	public void autoComplete(String option)
	{
		List<WebElement> radio1 = driver.findElements(By.xpath("//mat-radio-button[@id='mat-radio-82']//label//div[2]/span[2]"));
		for(int i=0;i<radio1.size();i++)
		{
			String name = radio1.get(i).getText();
			if(name.contains(option))
			{
				radio1.get(i).click();
				break;
			}
		}
	}
	
	public void logOut(String option)
	{
		List<WebElement> btn = driver.findElements(By.xpath("//div[@class='mat-menu-content']/button"));
		for(int i=0;i<btn.size();i++)
		{
			String name = btn.get(i).getText();
			if(name.contains(option))
			{
				btn.get(i).click();
				break;
			}
		}
	}
	
	public String TakeScreenShot(WebDriver driver,String filename) throws IOException
	{
		//take screenshot and store it in file
		// WebDriver augmentedDriver = new Augmenter().augment(driver);
		    File file = ((TakesScreenshot)driver).
		                        getScreenshotAs(OutputType.FILE);
		    String destination = "C:\\Users\\VARSHITHA\\eclipse-workspace\\CodingChallenge\\Screenshots\\"+filename+".png";
		//copy the screenshot to desidered location
		FileUtils.copyFile(file, new File(destination));
		
		return destination;
	}
	
	public static ExtentReports report()
	{
		String path=System.getProperty("user.dir")+"\\ExtentReport\\result.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Pippin Automation");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA engg.", "Varshitha");
		return extent;
	}
}
