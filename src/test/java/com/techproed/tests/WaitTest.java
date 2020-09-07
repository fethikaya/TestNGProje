package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void imhlicitlyWait (){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removButton.click();

        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));

    }
}
