package com.beymen.pages;

import com.beymen.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Anasayfa {


    public Anasayfa(){

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//input[@class='default-input o-header__search--input']")
    public WebElement aramaMotoruKutusu;


}
