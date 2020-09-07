package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){

    }

    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickAlert.click();

        String alertMesaj = driver.switchTo().alert().getText();
        System.out.println(alertMesaj);
        driver.switchTo().alert().accept();  // ok butununa bastı

    }

    @Test
    public void jsConfirmTest (){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickAlert.click();
        String aMesaj = driver.switchTo().alert().getText();
        System.out.println(aMesaj);
        driver.switchTo().alert().dismiss();  //Cancel buttuonuna bastı

    }

    @Test
    public void sendKeyTest (){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickAlert.click();
        String tMesaj = driver.switchTo().alert().getText();
        System.out.println(tMesaj);

        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        driver.switchTo().alert().accept();

    }
}
