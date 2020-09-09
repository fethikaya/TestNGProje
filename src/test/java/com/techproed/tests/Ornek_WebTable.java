package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {

    @Test
    public void test01 (){

        // 1. "http://fhctrip-qa.com/admin/HotelRoomAdmin" bu adrese gidiniz.
        // 2. Tbody'nin içerisinde kaç satır var, satır sayısını ekrana yazdırınız.
        //    tbody/tr -> findElements
        // 3. Üçüncü satırdaki verileri ekrana yazdırınız.
        //    tbody/tr[3]


        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager2");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!" + Keys.ENTER);


       List<WebElement> bodySatir = driver.findElements(By.xpath("//tbody/tr"));
           System.out.println(bodySatir.size());



        WebElement ucuncuSatir = driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(ucuncuSatir.getText());



    }

}
