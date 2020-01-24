package com.crm.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testutil;
	
	
	String sheetName="Sheet1";
	
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void LoginPageTitle(String fname,String lname,String mn) throws IOException, AWTException
	{
	//	String title = loginPage.validateLoginPageTitle();
	//	Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	
//	loginPage.login(fname, lname, mn);
		WebElement signup = driver.findElement(By.id("id")); 
		Actions builder = new Actions(driver);
		builder.moveToElement(signup).click().build().perform();
		driver.findElement(By.cssSelector("div#name")).click();
		
		String mainwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i1 = windows.iterator();
		while(i1.hasNext())
		{
			String child = i1.next();
			driver.switchTo().window(i1.next());
			driver.close();
			
		}
		
		FileInputStream fis = new FileInputStream("asfd");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s1 = wb.getSheet("Sheet1");
		Cell cell = s1.getRow(1).getCell(1);
		System.out.println(cell.getStringCellValue());		
		TakesScreenshot scr = (TakesScreenshot)driver;
		File file = scr.getScreenshotAs(OutputType.FILE);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	//	js.executeScript("arguments[0].scrollIntoView();",element);
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
