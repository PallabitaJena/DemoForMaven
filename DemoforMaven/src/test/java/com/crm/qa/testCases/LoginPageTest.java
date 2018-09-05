package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	SoftAssert softAssert;
	HomePage homePage;
	public LoginPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		 intialization();
		 loginPage= new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		softAssert=new SoftAssert();
		System.out.println(title);
		softAssert.assertEquals( "Free CRM software in the cloud powers sales and customer service",title);
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void crmLogoImgTest()
	{
		boolean flag=loginPage.validateCRMImage();
		softAssert=new SoftAssert();
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	@Test(priority=3)
	public void logInTest() throws IOException, InterruptedException
	{
	  Thread.sleep(2000);
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("passwrod"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
