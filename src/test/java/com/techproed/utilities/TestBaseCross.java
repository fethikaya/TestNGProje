package com.techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {

    protected WebDriver driver;

    @Parameters ("browser")
    // Bize parametre olarak borowser gelecek ve biz de o porametreyi kullancağız
    // bu parametra xml dosyasında gelecek

    @BeforeMethod
    public void setUp  (@Optional String browser){
        // @optianal olurda borwser gelmeme ihtimalıni karşı oluşturduyoruz.
        // parametro olarak browser gelmezse buna rağmen çalışacaktır
        driver = DriverCross.getDriver( browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown (){
        DriverCross.closeDriver();
    }

}
