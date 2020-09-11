package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhsTripLoginTest extends TestBase {

    @Test
    public void fhsLogin (){
        driver.get(ConfigurationReader.getProperty("otel_link"));

        FhcTripLoginPage fhctrip = new FhcTripLoginPage(driver);

        fhctrip.userName.sendKeys(ConfigurationReader.getProperty("otel_email"));
        fhctrip.password.sendKeys(ConfigurationReader.getProperty("otel_sifre"));
        fhctrip.login.click();
    }
}
