package com.test;

import java.util.List;

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

public class SelectDropdown {
	
	WebDriver driver;
	
	@BeforeClass
	public void Initialization()
	{
        driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void Test1()
	{
		
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
		Select sel = new Select(dropdown);
		
		sel.selectByIndex(3);
		
		sel.selectByValue("search-alias=freshmeat");
		
		sel.selectByVisibleText("Garden & Outdoors");
		

	}
	
	@Test(priority=2)
	public void Test2()
	{
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
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
	
	@AfterClass
	public void closure()
	{
		driver.quit();
	}

}
