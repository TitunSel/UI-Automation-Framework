package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal= new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal= new ThreadLocal<DesiredCapabilities>();
	private static ThreadLocal<ChromeOptions> capabilitiesLocal1= new ThreadLocal<ChromeOptions>();
	
	public static  WebDriver initializeLambdaTestSession(String browser,String testName)  {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("137");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "titunchakraborty7");
		ltOptions.put("accessKey", "LT_8HI1zXcWGx2pb57ZcbjQrLZsLfSkHOkfbLKh8jWNRkEUA6A");
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
        
        capabilitiesLocal1.set(browserOptions);
        WebDriver driver=null;
		try {
			driver = new RemoteWebDriver(new  URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driverLocal.set(driver); 
        
        return driverLocal.get();
	}
	
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}
	
	

}
