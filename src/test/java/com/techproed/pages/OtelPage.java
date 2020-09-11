package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OtelPage {
    WebDriver driver;

    public OtelPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy ( id = "Code" )
        public WebElement kodNo;

        @FindBy (id = "Name")
        public WebElement hotelAdi;

        @FindBy ( id = "Address")
        public WebElement adress;

        @FindBy (id = "Phone")
        public WebElement telefon;

        @FindBy ( id = "Email")
        public WebElement email;

        @FindBy ( id = "IDGroup")
        public WebElement idDroup;



        @FindBy ( id = "btnSubmit")
        public WebElement save;
}
