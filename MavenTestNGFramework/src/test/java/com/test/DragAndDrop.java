package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DragAndDrop {

    WebDriver driver;
    Properties prop = new Properties();


    @BeforeClass
    public void Initialization() throws IOException {

        driver = new ChromeDriver();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
        prop.load(fis);

        driver.get(prop.getProperty("GURU_URL"));

        driver.manage().window().maximize();

    }

    @Test
    public void dragAnddrop() {


        WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));

        WebElement To = driver.findElement(By.id("bank"));

        WebElement Source = driver.findElement(By.id("fourth"));

        WebElement Dest = driver.findElement(By.id("amt7"));

        Actions act = new Actions(driver);

        act.dragAndDrop(From, To).perform();

        act.dragAndDrop(Source, Dest).perform();

    }

   @AfterClass
    public void closure() {
        driver.quit();
    }

}
