package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD {
	 
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver(); //Launches a browser and browser session is created
		BrowserUtility butils=new BrowserUtility(driver);
		butils.goToWebsite("http://www.automationpractice.pl/index.php?");
		butils.maximizeBrowserWindow();
		By signInlinklocator=By.linkText("Sign in");
		butils.clickOn(signInlinklocator);
		By emailid=By.id("email");
		By password=By.id("passwd");
		butils.enterText(emailid,"kasagal270@bitflirt.com" );
		butils.enterText(password,"12345" );
		By signInlinkButton=By.id("SubmitLogin");
		butils.clickOn(signInlinkButton);  
	}

}
