package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {

    }

    @Test
    public void IframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0); // index ile giriş yapıp yazı yazabildik

        WebElement paragnaf = driver.findElement(By.xpath("//p"));
        paragnaf.clear();
        paragnaf.sendKeys("Merhaba");
    }

    @Test
    public void IframeTest2() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr"); // id kullanarak geçiş yapabiiriz,
        WebElement paragnaf = driver.findElement(By.xpath("//p"));
        paragnaf.clear();
        paragnaf.sendKeys("Merhaba IFrame yöntem2");
    }

    @Test
    public void iframeTest3(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe 3.yöntem");
    }

    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
        driver.switchTo().defaultContent(); // Tekrar ana websayfasına dönmek için.
                                            // önce switchTo ile girdiğmiz iframden defoultContent() ile çıkmak gerekiyo.
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();
    }
}
