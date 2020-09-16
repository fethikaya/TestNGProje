package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {


    @BeforeMethod
    public void giris (){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager2");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test (  groups = {"fhctrip", "hotelolusturma"} )
    //(dependsOnMethods = "giris")  beforemethod yerine bu şekilde de yapılabilir
    public void hotelCreat (){

        WebElement kodNo = driver.findElement(By.id("Code"));
        kodNo.sendKeys("34080");

        WebElement hotelAdi = driver.findElement(By.id("Name"));
        hotelAdi.sendKeys("Taksim");

        WebElement addres = driver.findElement(By.id("Address"));
        addres.sendKeys("İstiklal Cad. No:86 Taksim / İstanbul ");

        WebElement telefon = driver.findElement(By.id("Phone"));
        telefon.sendKeys("0212 563 89 74");

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("info@takcimotel.com");


        WebElement dropDownList = driver.findElement(By.id("IDGroup"));
        Select sec = new Select(dropDownList);
        sec.selectByIndex(2);

       WebElement save = driver.findElement(By.id("btnSubmit"));
        save.click();



        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
       // Assert.assertTrue(basariliYazisi.isDisplayed());  // Burada onay vermedi çünkü biraz beklemek gerekiyor, onay 1 saniye sonra geliyor

        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement onayYazi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(onayYazi.isDisplayed());


    }

}
