package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	WebElement signup = driver.findElement(By.id("id")); 
	
	public void easy() 
	{
	Actions builder = new Actions(driver);
	builder.moveToElement(signup).build().perform();
	
	}
}
