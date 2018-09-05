package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxml4j.exceptions.InvalidFormatException;

import com.crm.qa.Base.TestBase;



public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
		
	}

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
//Explicit wait
	public  static void clickon(WebDriver driver,WebElement locator,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		locator.click();
		System.out.println("User logged in");
	}
// handle irritating popup
	
	public  static void handlePopup(String popup,String cross)
	{
		
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(popup))).build().perform();
		driver.findElement(By.xpath(cross)).click();
	}
//Switch to frame
	public static void swichToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
// Take Screenshot.

	public static void TakeSnapshot(String name)
	{
		try {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			// create image file
			File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			//File DestFile=new File(fileWithPath);
			String currentDir=System.getProperty("user.dir");
			//Copy file at destination

			FileUtils.copyFile(scrFile, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+ name+".png"));
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
// getData from excel
	public static String TEST_DATASHEET_PATH="D:\\PJ\\Pallabi\\Vertivco\\DemoforMaven\\src\\main\\java\\com\\crm\\qa\\testData"
                                                +"\\FreeCRMTestData.xlsx";
    static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException
	{
		FileInputStream file=null;
		try{
			file=new FileInputStream(TEST_DATASHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try{
			book= new XSSFWorkbook(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		XSSFRow row=sheet.getRow(0);
		System.out.println(sheet.getLastRowNum());
		System.out.println(row.getLastCellNum());
		Object[][] data=new Object[sheet.getLastRowNum()][row.getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<row.getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	
}
