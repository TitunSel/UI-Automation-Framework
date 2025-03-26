package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public  final  class LoginPage extends BrowserUtility{
	   private static final By EMAIL_TEXT_BOX_LOCATOR =By.id("email");
	   private static final  By PASSWORD_TEXT_BOX_LOCATOR=By.id("passwd");
	   private static final  By SIGN_IN_BUTTON=By.id("SubmitLogin");
	    public LoginPage(WebDriver driver) {
		    super(driver);
	     }
	    
	    public MyAccountPage performLoginWith(String email,String password) {
	    	  enterText(EMAIL_TEXT_BOX_LOCATOR,email);
	    	  enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
	    	  clickOn(SIGN_IN_BUTTON);
	    	  MyAccountPage myaccountpage=new MyAccountPage(getDriver());
	    	  return myaccountpage;
	    }

}
