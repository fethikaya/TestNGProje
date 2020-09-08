package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class Tekrar14 extends TestBase {

    @Test
    public void siftTusu (){
        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
     //   aramaKutusu.sendKeys("Selenium");

        Actions actions = new Actions(driver);
        actions.moveToElement(aramaKutusu).click().keyDown(Keys.SHIFT).sendKeys("selenium").perform();
    }

    @Test
    public void dasyaVarmi (){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String dosyaYulu = System.getProperty("user.dir");
        String pomXml = dosyaYulu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(dosyaYulu));
        System.out.println(varMi);
        Assert.assertTrue(varMi);
    }



}
