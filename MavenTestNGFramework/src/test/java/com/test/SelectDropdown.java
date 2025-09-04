package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropdown extends SetUp {

	@Test(priority=1)
	public void Test1()
	{
		
		
		WebElement dropdown = driver.findElement(By.id(prop.getProperty("DropdownBoxID")));
		
		Select sel = new Select(dropdown);
		
		sel.selectByIndex(3);
		
		sel.selectByValue("search-alias=freshmeat");
		
		sel.selectByVisibleText(prop.getProperty("Garden"));
		

	}
	
	@Test(priority=2)
	public void Test2()
	{
		
		WebElement dropdown = driver.findElement(By.id(prop.getProperty("DropdownBoxID")));
		
		Select sel = new Select(dropdown);
		
		List<WebElement> li = sel.getOptions();

		for(int i=0;i<li.size();i++)
		{
			li.get(i).click();
			System.out.println(li.get(i).getText());
		} 
			
	}
	
	@Test(priority=0)
	public void Test3()
	{
		WebElement Login = driver.findElement(By.xpath("//span[contains(text(),'Account &')]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(Login).perform();
		
		List<WebElement> SignIn = driver.findElements(By.xpath("//div[@id='nav-al-container']"));
		
		for(int j=0;j<SignIn.size();j++)
		{
			System.out.println(SignIn.get(j).getText());
		}
	}
	


}
