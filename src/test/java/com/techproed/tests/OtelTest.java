package com.techproed.tests;

import com.techproed.pages.OtelPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OtelTest extends TestBase {


    public void giris () {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager2");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test () {
        giris();
        OtelPage fhcTripHotelCreatePage = new OtelPage(driver);

        fhcTripHotelCreatePage.kodNo.sendKeys("1234");
        fhcTripHotelCreatePage.adress.sendKeys("Çıkmaz sk.");
        fhcTripHotelCreatePage.email.sendKeys("techproed@techproed.com");
        fhcTripHotelCreatePage.hotelAdi.sendKeys("Techproed");
        fhcTripHotelCreatePage.telefon.sendKeys("1223454534");

        Select select = new Select(fhcTripHotelCreatePage.idDroup);
        select.selectByIndex(2);

        fhcTripHotelCreatePage.save.click();



    }
}