package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUp {

    WebDriver driver;
    Properties prop = new Properties();

    @BeforeClass
    public void Initialization() throws IOException {
        driver = new ChromeDriver();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
        prop.load(fis);

        driver.get(prop.getProperty("QA_URL"));

        driver.manage().window().maximize();
    }

    @AfterClass
    public void closure()
    {
        driver.quit();
    }
}
