package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homepage;
	Logger logger= LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest=true;
	private boolean isHeadLess=true;
	
	@Parameters({"browser","isLambdaTest","isHeadLess"})
	@BeforeMethod(description="Load the HomePage of the website")
	public void setUp(
			@Optional("chrome") String browser,@Optional("false") boolean isLambdaTest,@Optional("true") boolean isHeadLess, ITestResult result) {
		WebDriver lambdadriver;
		if(isLambdaTest) {
			
			lambdadriver=	LamdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homepage= new HomePage(lambdadriver);
			
		}else {
			logger.info("Load the HomePage of the website");
			homepage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadLess);
		}
		
	}
	
	public BrowserUtility getInstance() {
		return homepage;
	}
	
	@AfterMethod(description="Tear Down the Browser")
	public void tearDown() {
		if(isLambdaTest) {
			LamdaTestUtility.quitSession();
		}else {
			homepage.quit();
		}
	}

}
