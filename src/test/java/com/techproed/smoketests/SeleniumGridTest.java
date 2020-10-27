package com.techproed.smoketests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {

@Test
    public void test () throws MalformedURLException {

    //  İşlem 3 adımdan oluşacak
    // 1. adım Desired Capabilities obje oluşturacağız

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);

        // 2. adım Chrom options belirle

    ChromeOptions options = new ChromeOptions();
    options.merge(cap);

    // 3 adım / Hub adresimizi giriyoruz
    String hubUrl = "http://192.168.2.103:4444/wd/hub";
    WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);

    driver.get("http://www.sopger.net");
    System.out.println(driver.getTitle());
  //  driver.quit();

}

}


//java -Dwebdriver.chrome.driver="C:\Users\Fethi\Desktop\Selenium\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.2.103:4444/grid/register/