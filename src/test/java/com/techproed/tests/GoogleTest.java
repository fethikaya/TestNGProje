package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void aramaTest () {
        driver.get("http://google.com");

        // Google page class'ın dan direk bir nesne oluşturduk, parametre olarak şuan driverı atıyoruz.

        GooglePage  googlePage = new GooglePage(driver);


        googlePage.aramaKutusu.sendKeys("selamlar");

    }
}
