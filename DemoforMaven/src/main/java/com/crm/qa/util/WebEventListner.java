package com.crm.qa.util;

import java.io.IOException;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.crm.qa.Base.TestBase;
/*import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;*/

public class WebEventListner extends TestBase implements WebDriverEventListener {
	public static final Logger log = Logger.getLogger(WebEventListner.class.getName());
	public WebEventListner() throws IOException {
		super();
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		log.info("Navigated forward to next page");
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception ocured"+ error);
		TestUtil.TakeSnapshot(error.toString());
		
	}
	/*public void log(String data){
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}*/

}
