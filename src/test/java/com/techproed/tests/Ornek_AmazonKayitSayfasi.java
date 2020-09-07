package com.techproed.tests;

import com.techproed.utilities.TestBase;
import javafx.scene.shape.MoveTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {  // Day 14 / 6 Eylül 2020


    @Test
    public void test01 () {
        driver.get("http://amazon.com");

        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);

        //Mouse'u istedigimiz element'in uzerine gotururuz
        actions.moveToElement(element).perform();
        WebElement startHere = driver.findElement(By.partialLinkText("Start here"));
        startHere.click();

       String baslik = driver.getTitle();
        System.out.println(baslik);
        Assert.assertTrue(baslik.contains("Registration"));


    }


    @Test (dependsOnMethods = "test01")
    public void test02 (){


        WebElement yourName = driver.findElement(By.id("ap_customer_name"));
        yourName.sendKeys("Fethi Kaya");

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("fethikaya@gmail.com");

        WebElement sifre = driver.findElement(By.id("ap_password"));
        sifre.sendKeys("kaya1317");

        WebElement sifreTekrar = driver.findElement(By.id("ap_password_check"));
        sifreTekrar.sendKeys("kaya1317");

        WebElement girisButton = driver.findElement(By.id("continue"));
        girisButton.click();
    }
}
