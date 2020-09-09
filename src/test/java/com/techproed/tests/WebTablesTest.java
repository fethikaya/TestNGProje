package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {


    public void giris() {

        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager2");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void table() {
        giris();  // Normal methodu çağırıp kullanabiliriz

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tüm bilgiler
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());


        // Tüm başlıkları alabiliriz.

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar) {
            System.out.println(baslik.getText());
        }


    }

    @Test
    public void tumSatirlar() {
        giris();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  Tüm satırları bulma
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        //List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr[12]"));  // Sadece 12 satırı alır
        for (WebElement satir : tumSatirlar) {
            System.out.println(satir.getText());
        }

    }

    @Test
    public void tumHucreler() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Tum Hucreleri alma
        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement hucre : tumHucreler) {
            System.out.println(hucre.getText());
        }
    }

    @Test
    public void belirliBirSutunYazdirma() {
        giris();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // //tbody/tr/td[4] -> Burada 4. sütun'u yazdırıyoruz.
        // buradaki 4 sayısını değiştirerek istediğimiz kolon(sütun)'u yazdırabiliriz.

        List<WebElement> dorduncuSutun = driver.findElements(By.xpath("//tbody/tr/td[4]"));

        for (WebElement veri : dorduncuSutun) {
            System.out.println(veri.getText());
        }
    }

    @Test
    public void calistir(){
        giris();
        hucreYazdir(3,5);
        hucreYazdir(2,7);
        hucreYazdir(8,4);
        hucreYazdir(5,2);
    }

    public void hucreYazdir (int satir, int sutun){
        // //tbody/tr[4]/td[6]

        String xpathDegerim = "//tbody/tr["+ satir +"]/td[\"+ sutun +\"]";

        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());

        // Dinamik bir metod oluşturduk. onu cağırarak, datasının almak isteğmiiz hücenin
        // satır ve sutun numarasını girerek alabiliyoruz.
    }


}