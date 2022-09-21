package com.beymen.step_definitions;

import com.beymen.pages.Anasayfa;
import com.beymen.pages.SepetSayfası;
import com.beymen.pages.ÜrünSayfası;
import com.beymen.utilities.ConfigurationReader;
import com.beymen.utilities.Driver;
import com.beymen.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;


public class BeymenTestAdımları {

       Anasayfa anasayfa = new Anasayfa();
       ÜrünSayfası ürünSayfası = new ÜrünSayfası();
       SepetSayfası sepetSayfası = new SepetSayfası();
       ExcelUtil excelUtil = new ExcelUtil("UrunListesi.xlsx","Sheet1");
    @Given("Kullanıcı beymen anasayfasında.")
    public void kullanıcıBeymenAnasayfasında() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("Kullanıcı arama motoruna tıklar ve şort yazar.")
    public void kullanıcıAramaMotorunaTıklarVeŞortYazar() {
        String şort = excelUtil.getCellData(0,0);
        anasayfa.aramaMotoruKutusu.click();
        anasayfa.aramaMotoruKutusu.sendKeys(şort);
    }
    @And("Kullanıcı arama motorundaki kelimeyi siler.")
    public void kullanıcıAramaMotorundakiKelimeyiSiler() throws InterruptedException {
        Thread.sleep(2000);
        anasayfa.aramaMotoruKutusu.sendKeys(Keys.BACK_SPACE);
        anasayfa.aramaMotoruKutusu.sendKeys(Keys.BACK_SPACE);
        anasayfa.aramaMotoruKutusu.sendKeys(Keys.BACK_SPACE);
        anasayfa.aramaMotoruKutusu.sendKeys(Keys.BACK_SPACE);
    }

    @And("Kullanıcı arama motoruna gömlek yazar ve klavyeden ENTER butonuna tıklar.")
    public void kullanıcıAramaMotorunaGömlekYazarVeKlavyedenENTERButonunaTıklar() {
        String gomlek = excelUtil.getCellData(0,1);
        anasayfa.aramaMotoruKutusu.sendKeys(gomlek + Keys.ENTER);

    }
    @And("Kullanıcı ürün seçer ve ürüne tıklar.")
    public void kullanıcıÜrünSeçerVeÜrüneTıklar() {
        ürünSayfası.ürünSeçildi.click();
    }

    String beklenenFiyat = "";
    @And("Kullanıcı ürünün bedenini seçip sepete ekle butonuna tıklar.")
    public void kullanıcıÜrününBedeniniSeçipSepeteEkleButonunaTıklar() throws InterruptedException {
        beklenenFiyat=ürünSayfası.ürünSayfasıFiyatı.getText();
        sepetSayfası.ürünBedenSmall.click();
        sepetSayfası.sepetButonu.click();
        Thread.sleep(5000);
        sepetSayfası.sepetimButonu.click();
    }

    @Then("Ürün sayfasındaki ürünün fiyatıyla sepetteki ürünün fiyatını doğrulama")
    public void ürünSayfasındakiÜrününFiyatıylaSepettekiÜrününFiyatınıDoğrulama() {

        String gerçekSepetFiyatı=sepetSayfası.ürününSepetFiyatı.getText();

        Assert.assertEquals(beklenenFiyat,gerçekSepetFiyatı);
    }

    @And("Ürün adeti artırılır ve doğrulanır.")
    public void ürünAdetiArtırılırVeDoğrulanır() {

        Select select = new Select(sepetSayfası.ürünAdeti);
        select.selectByValue("2");

        Assert.assertTrue(sepetSayfası.ürünAdeti.getText().contains("2 adet"));

    }

    @And("Ürün silinir ve silindiği doğrulanır.")
    public void ürünSilinirVeSilindiğiDoğrulanır() {
        sepetSayfası.silButonu.click();

        String beklenenSepetDurumu="SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";
        String gerçekSepetDurumu=sepetSayfası.boşSepet.getText();

        Assert.assertEquals(beklenenSepetDurumu,gerçekSepetDurumu);


    }
}
