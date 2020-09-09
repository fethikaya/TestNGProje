package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {

    @Test
    public void sagTiklama(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        // bir webelement'e sağ tıklamak için bu kodu kullanırız.
        // actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.
        actions.contextClick(element).perform();
        actions.clickAndHold().perform();
    }
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
        actions.doubleClick(button).perform();
    }
    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
        actions.moveToElement(menu).perform();
    }

    @Test
    public void asagiYukari(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.ARROW_UP); // yukarı çıkar

    }

    @Test
    public void buyukKucukYazma (){
        driver.get("http://www.google.com");

        WebElement aramaKutusu = driver.findElement(By.name("q"));

       // aramaKutusu.sendKeys("merhaba live channel"); // Küçük harfle yazdı

     //   aramaKutusu.sendKeys(Keys.SHIFT + "Merhaba live hannel"); // Şifte basıl tutarak büyük yazar

        Actions actions = new Actions(driver);
        actions.moveToElement(aramaKutusu).click()
                .keyDown(Keys.SHIFT) //Shifte bastı, biz komut vermeyene kadar basılı tutar
                .sendKeys("Merhaba")
                .keyUp(Keys.SHIFT) // Şifte parmağını kaldırdı,
                .sendKeys(" nasıl gidiyor?"); // küçük yazdı


    }

    @Test
    public void dragAndDrag (){  // Maus ile sürükle ve bırak

        driver.get("http://www.google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));

        WebElement logo = driver.findElement(By.id("hplogo"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(logo,aramaKutusu).perform(); // Logo web elementini al ve arama kutusuna sürükle ve bırak

    }

}
