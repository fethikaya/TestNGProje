package com.techproed.tests;


import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class JSExecutorTest {

    @Test
    public void amazonArama() throws InterruptedException {
        Driver.getDriver().get("http://amazon.com");

        // JS ile bir websayfasının başlığını alabiliyoruz..
        String baslik = JSExecutor.getTitleByJS();
        System.out.println(baslik);
        AmazonNewPage amazonNewPage = new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("samsung");

        // JS ile bir webelemente tıklayabiliyoruz..
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);
        Thread.sleep(2000);

        // JS ile bir websayfasının en altına gidebiliyoruz..
        JSExecutor.scrollDownByJS();
        Thread.sleep(2000);

        //belirlenen webelemnte kadar git
        WebElement fiyatlar = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(fiyatlar);

        // JS ile bir web elementin arka plan rengini değiştirebiliyoruz
        JSExecutor.flash(fiyatlar);


        WebElement condition = Driver.getDriver()
                .findElement(By.xpath("//*[.='Condition']"));
        // JS ile bir webelementin arkaplan rengini değiştirebiliyoruz..(SABİT)
        JSExecutor.changeColor("rgb(255,0,0" , condition);

        // JS ile isterseniz websayfasında JSAlert üretebiliyorsunuz..
        JSExecutor.generateAlert("Test BİTTİ ! Eyvah, selenium dersleri de bitti.. )");


    }
}
