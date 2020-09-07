package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi (){

        System.out.println(System.getProperty("user.dir"));  // Dosya yolu verir
        System.out.println(System.getProperty("user.home")); // Kulanıcının ana klasorunu verir

        String kullaniciDosyaYolu = System.getProperty("user.dir");
        // C:/Users/isimsiz/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
        Assert.assertTrue(varMi);  // test başarılı oldu. Böyle bir dosya buldu

    }

    @Test
    public void dosyaUpLoad (){  //bilgisayardan websayfasına dosya yükleme

        // C:\Users\Fethi\Desktop\Dosya\logo.png  // (yüklencek dosyamızın bulunduu adres)

        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaYukle = driver.findElement(By.id("file-upload"));
        dosyaYukle.sendKeys("C:\\Users\\Fethi\\Desktop\\Dosya\\logo.png");
        // Böylece dosya yolu yazarak, dosyayı eklemeyi sağlıyoruz.

        WebElement uploudButtonu = driver.findElement(By.id("file-submit"));
        uploudButtonu.click();

        WebElement dogrulama = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(dogrulama.isDisplayed());
    }

    @Test
    public void dosyaDownlaod () throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        // C:\Users\Fethi\Downloads\Amsterdam.jpg
        WebElement amsterdam = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdam.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:\\Users\\Fethi\\Downloads\\Amsterdam.jpg"));

        Assert.assertTrue(varMi);

    }
}
