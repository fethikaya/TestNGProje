package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    @Test (  groups = {"fhctrip", "hotelolusturma"} )
    public void test01 () {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginPage fhctrip = new FhcTripLoginPage(driver);

        fhctrip.userName.sendKeys("manager2");
        fhctrip.password.sendKeys("Man1ager2!");
        fhctrip.login.click();
    }
}


