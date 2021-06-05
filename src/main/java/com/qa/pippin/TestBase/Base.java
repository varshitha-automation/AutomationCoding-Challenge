package com.qa.pippin.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static Properties prop;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	
	public static WebDriver initialization() throws IOException
	{
		prop = new Properties();
		FileInputStream fp = new FileInputStream("C:\\Users\\VARSHITHA\\eclipse-workspace\\CodingChallenge\\src\\main\\java\\com\\qa\\pippin\\congif\\config.properties");
		prop.load(fp);
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}
		else if(BrowserName.contains("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
		
		public static WebDriver getDriver()
		{
			return tl.get();
		}
}


