package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleAramaPage {

    public GoogleAramaPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "q")
    public WebElement aramaKutusu;


    @FindBy ( tagName = "a" )
    public List<WebElement> tumLinkler;

    // tagnamesi 'a' olan tüm webelementlerini bulmak için tagname attributinu kullanılırız.
    // sonra tamamını liste çeklinde alırız.


}
