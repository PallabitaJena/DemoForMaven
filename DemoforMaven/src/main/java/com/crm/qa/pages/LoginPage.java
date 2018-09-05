package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.Base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	//page factory OR
		@FindBy(name="username")
		WebElement pUsername;
		
		@FindBy(name="password")
		WebElement pPassword;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement pLoginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement pSignUp;
		
		@FindBy(xpath="//a[@class='navbar-brand']//img[contains(@class,'img-responsive')]")
		WebElement pCRMLogo;
		
		// initialize all OR
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	//Action
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCRMImage()
	{
		return pCRMLogo.isDisplayed();
	}
	public HomePage login(String un,String Pw) throws IOException, InterruptedException
	{
		pUsername.sendKeys(un);
		pPassword.sendKeys(Pw);
		//TestUtil.clickon(driver,pLoginBtn,5000);
		/*(new WebDriverWait(driver, 20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginPopup_Xpath"))));*/
		try
		{
			
			    TestUtil.swichToFrame("intercom-borderless-frame");
			
				TestUtil.handlePopup(prop.getProperty("loginPopup_Xpath"), prop.getProperty("loginCross_Xpath"));
			
			
		}
		catch(Exception e) 
		{
		
			System.out.println("irritating popup is not displayed");
		
		}
		pLoginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	

}
