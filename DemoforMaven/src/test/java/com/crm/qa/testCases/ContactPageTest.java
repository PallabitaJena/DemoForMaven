package com.crm.qa.testCases;

import java.io.IOException;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	public LoginPage loginPage;
	public SoftAssert softAssert;
	public HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="Contact";
	public ContactPageTest() throws IOException {
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
		 TestUtil.swichToFrame("mainpanel");
		 contactsPage=homePage.clickOnContactLink();
	}
	@Test(priority=1)
	public void verifyContactspageLabelTest()
	{
		softAssert.assertTrue(contactsPage.verifyContactsLabel()," Contact lebel is missing on the page");
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void SelectContactsTest() throws InterruptedException
	{
		contactsPage.selectContactByName("Ashwin Unknown");
		Thread.sleep(2000);
		TestUtil.TakeSnapshot("contactlist");
	}
	@Test(priority=3)
	public void validateCreatenewContactTest()
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Steve", "Roger", "Avenger");
	}
	@DataProvider
	public Object[][] getCRMTestdata() throws InvalidFormatException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4, dataProvider="getCRMTestdata")
	public void validateCreateNewContactTest(String title,String fstname,String lstName, String cmpny) throws IOException
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, fstname, lstName, cmpny);
	}
	@Test(priority=5)
	public void verifyTypeOfdataTest() throws IOException
	{
		contactsPage.verifyTypeOfdata("Ankit joe");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
