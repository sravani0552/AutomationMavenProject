package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void Initialization()
	{
	
	driver = new ChromeDriver();
	
	driver.get("https://demo.guru99.com/test/drag_drop.html");
	
	driver.manage().window().maximize();
	
	}

    @Test
	public void dragAnddrop()
	{
		
		
		WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		
		WebElement To = driver.findElement(By.id("bank"));
		
        WebElement Source = driver.findElement(By.id("fourth"));
		
		WebElement Dest = driver.findElement(By.id("amt7"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(From, To).perform();
		
		act.dragAndDrop(Source, Dest).perform();

	}
    
    @AfterClass
    public void closure()
    {
    	driver.quit();
    }

}
