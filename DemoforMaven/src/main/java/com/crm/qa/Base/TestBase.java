package com.crm.qa.Base;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;
//read from properties file
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListner eventListner;
	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\PJ\\Pallabi\\Vertivco\\DemoforMaven\\src\\main\\"
		+"java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
	}
	public static void intialization() throws IOException
	{
		String pBrowser= prop.getProperty("browser");
		EventFiringWebDriver eDriver;
		
		if(pBrowser.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver","D:\\PJ\\Chrome Driver 2.33\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		
		//For WebDriver fire Event
		eDriver=new EventFiringWebDriver(driver);
		//now create object of EventListnerHandler to register it with EventFiringWebDriver   
		eventListner=new WebEventListner();
		eDriver.register(eventListner);
		driver=eDriver;
		
		
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   
		   driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	

}
