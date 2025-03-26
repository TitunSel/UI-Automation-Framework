package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;
import static com.utility.JSONUtility.*;

public final class HomePage extends BrowserUtility{
	  
             static final By SIGN_IN_LINK_LOCATOR=By.linkText("Sign in");  
             Logger logger= LoggerUtility.getLogger(this.getClass());
             
            public HomePage(Browser browsername,boolean isHeadless) {
			    super(browsername,isHeadless); //To call the parent class constructor from the Childclass constructor
			    goToWebsite(readJSON(QA).getUrl());
				
			}

            public HomePage(WebDriver driver) {
            	super(driver);
            	 goToWebsite(readJSON(QA).getUrl());
            }


		public LoginPage goToLogInPage() {                                                                     //Page Functions
			 logger.info("Trying to perform click to go to sign-in page");
		     clickOn(SIGN_IN_LINK_LOCATOR);
		     LoginPage loginpage=new LoginPage(getDriver());
		     return loginpage;
	     }

		public void quit() {
			 logger.info("Tear Down the Browser");
			 this.getDriver().quit();
			
		}

}
