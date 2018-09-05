package com.crm.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	public LoginPage loginPage;
	public SoftAssert softAssert;
	public HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		 intialization();
		 loginPage= new LoginPage();
		 softAssert=new SoftAssert();
		 contactsPage= new ContactsPage();
		 homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("passwrod"));
	}
	
	@Test(priority=1)
	public void veryfiHomePgaeTitleTest() throws InterruptedException
	{
		Thread.sleep(1000);
		String title=homePage.verifyHomePagetitle();
		System.out.println(title);
		softAssert.assertEquals( "CRMPRO",title,"Opps!!Home page do not matched :( ");
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		TestUtil.swichToFrame("mainpanel");
		softAssert.assertTrue(homePage.verifyCorrectUserName());
		softAssert.assertAll();
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException
	{
		TestUtil.swichToFrame("mainpanel");
		contactsPage=homePage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
