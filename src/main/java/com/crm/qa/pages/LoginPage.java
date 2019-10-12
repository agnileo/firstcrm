package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//PageFactory
	@FindBy(name="firstname")
	WebElement firstname;

	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="reg_email__")
	WebElement mobnum;

	

public LoginPage() 
{
	PageFactory.initElements(driver, this);
}

public String validateLoginPageTitle()
{
	return driver.getTitle();
}

public void login(String fname,String lname,String mn)
{
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	mobnum.sendKeys(mn);
	
	

}



}