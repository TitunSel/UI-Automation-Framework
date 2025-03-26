package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {
	 
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver(); //Launches a browser and browser session is created
		HomePage homepage=new HomePage(driver);
		LoginPage login=homepage.goToLogInPage();
		login.performLoginWith("kasagal270@bitflirt.com", "12345");
	}

}
