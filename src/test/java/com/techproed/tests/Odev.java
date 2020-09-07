package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Odev {
    WebDriver driver;


    @BeforeClass
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown (){
       driver.quit();
    }

    @Test (dependsOnMethods = "googleTest")
    public void facebookTest (){
        driver.get("http://facebook.com");
    }

    @Test (dependsOnMethods = "amazonTest")
    public void googleTest () {
        driver.get("http://google.com");
    }

    @Test (priority = 2)
    public void amazonTest (){
    driver.get("http://amazon.com");

    SoftAssert softNesne = new SoftAssert();

    String baslik = driver.getTitle();
        System.out.println(baslik);
    softNesne.assertTrue(baslik.contains("Online"));
    softNesne.assertFalse(baslik.contains("Dukkan"));
    softNesne.assertEquals("Computer",baslik);
    softNesne.assertAll();


    }


}
