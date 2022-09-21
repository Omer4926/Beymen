package com.beymen.pages;

import com.beymen.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ÜrünSayfası {

    public ÜrünSayfası(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//span[@class='m-productCard__desc'])[1]")
    public WebElement ürünSeçildi;

    @FindBy(xpath = "//ins[@id='priceNew']")
    public WebElement ürünSayfasıFiyatı;
}
