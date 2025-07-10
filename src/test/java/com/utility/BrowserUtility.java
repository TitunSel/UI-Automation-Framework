package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public  class BrowserUtility {
	
	 private static ThreadLocal< WebDriver> driver=new ThreadLocal< WebDriver>();
	 Logger logger= LoggerUtility.getLogger(this.getClass());

	 public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);  //initialize instance variable -driver
	}
	 
	 
	 public BrowserUtility(Browser browsername, boolean isHeadless) {
		 logger.info("Launching Browser for:"+browsername);
		  if(browsername==Browser.CHROME  ) {
			  if(isHeadless) {
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("--headless");              //launch the browsers in headless
			  options.addArguments("--window-size=1920,1080");
			  driver.set(new ChromeDriver(options));
		  }else {
			  driver.set(new ChromeDriver());
		  }
	 }
		  else   if(browsername==Browser.EDGE) {
			  if(isHeadless) {
				  EdgeOptions options=new EdgeOptions();
				  options.addArguments("--headless=old");              //launch the browsers in headless
				  options.addArguments("disable-gpu");
				  driver.set(new EdgeDriver(options));
			  }else {
				  driver.set( new EdgeDriver());
			  }
			  
		  }else   if(browsername==Browser.FIREFOX) {
			  if(isHeadless) {
				  FirefoxOptions options=new FirefoxOptions();
				  options.addArguments("--headless=old"); 
				  driver.set(new FirefoxDriver(options));
			  }else {
				  driver.set( new FirefoxDriver());
			  }
			  
		  }else {
			  System.err.print("Invalid BrowserName, please select edge,chrome or Firefox");
		  }
	 }
	 
	 public void goToWebsite(String url) {
		 logger.info("Visiting the website:"+url);
		 driver.get().get(url);
	 }
	 
	 public void maximizeBrowserWindow() {
		 driver.get().manage().window().maximize();
	 }
	 
	 public void clickOn(By locator) {
		   
		     WebElement signnlink= driver.get().findElement(locator);
			  signnlink.click();
	 }
	 
	 public WebDriver getDriver() {
		return driver.get();
	}

	public void enterText(By locator,String textToEnter) {
		    WebElement textBoxWebElement= driver.get().findElement(locator);
		    textBoxWebElement.sendKeys(textToEnter);
			
		 
	 }
	
	public String  getVisibleText(By locator) {
		WebElement element= driver.get().findElement(locator);
		return element.getText();
	}
	 
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver.get();
		
		Date date= new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timestamp=format.format(date);
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);	
		String path=System.getProperty("user.dir")+"//screenshots//"+name+".png  -"+timestamp;
		File screenshotFile=new File(path);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
