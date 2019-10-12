package com.crm.qa.testcases;

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
	public void LoginPageTitle(String fname,String lname,String mn)
	{
	//	String title = loginPage.validateLoginPageTitle();
	//	Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	
	loginPage.login(fname, lname, mn);
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
