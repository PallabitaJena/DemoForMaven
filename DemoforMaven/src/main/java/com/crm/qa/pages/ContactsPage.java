package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.Base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement pContactslabel;
	
	@FindBy(id="first_name")
	WebElement pFirstname;
	
	@FindBy(id="surname")
	WebElement pLastName;
	
	@FindBy(name="client_lookup")
	WebElement pCompany;
	
	@FindBy(xpath="//form[@id='contactForm']//input[@type='submit' and @value='Save']")
	WebElement pSave;
	
	
	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return pContactslabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		List<WebElement> contacts=driver.findElements(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//"+
	                                            "preceding-sibling::td//input[@type='checkbox']"));
		for(WebElement c: contacts)
		{
			c.click();
		}
	}
	public void createNewContact(String title, String ftName,String ltName, String company)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		pFirstname.sendKeys(ftName);
		pLastName.sendKeys(ltName);
		pCompany.sendKeys(company);
		pSave.click();
	}
	public void verifyTypeOfdata(String name)
	{
		List<WebElement> contacts=driver.findElements(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//following-sibling::td//a[@context='company']"));

		for(WebElement c: contacts)
		{
			Object val=c.getText();
			if(val instanceof Integer)
			{
			System.out.println("class of the variable is-->integer");
			}
			else if (val instanceof String)
			{
				System.out.println("class of the variable is-->String");
			}
			else if (val instanceof Float)
			{
				System.out.println("class of the variable is-->float val");
			}
		}
	}
	


}
