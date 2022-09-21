package com.beymen.pages;

import com.beymen.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SepetSayfası {

    public SepetSayfası(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[contains(@id,'addBasket')]")
    public WebElement sepetButonu;

    @FindBy(xpath = "(//span[@class='m-variation__item -criticalStock'])[1]")
    public WebElement ürünBedenSmall;

    @FindBy(xpath = "(//span[@class='o-header__userInfo--text'])[3]")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//span[@class='m-productPrice__salePrice']")
    public WebElement ürününSepetFiyatı;

    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']")
    public WebElement ürünAdeti;

    @FindBy(xpath = "//button[@id='removeCartItemBtn0-key-0']")
    public WebElement silButonu;

    @FindBy(xpath = "//div[@id='emtyCart']//strong")
    public WebElement boşSepet;
}
