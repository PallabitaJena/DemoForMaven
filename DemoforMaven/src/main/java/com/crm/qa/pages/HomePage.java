package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td//font[contains(text(),'User: Naveen K')]")
	WebElement pUserNameLebel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement pContacts;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement pNewContactLink;
    
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement pDeals;
	
	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	WebElement pUsername;
	
	
	// initialize all OR
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	 //Action
	
	public String verifyHomePagetitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactLink() throws IOException
	{
		pContacts.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealLink() throws IOException
	{
		pContacts.click();
		return new DealsPage();
	}
	public boolean verifyCorrectUserName()
	{
		return pUsername.isDisplayed();
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(pContacts).build().perform();
		pNewContactLink.click();
		
	}
	


}
