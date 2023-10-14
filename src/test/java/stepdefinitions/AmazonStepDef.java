package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonHomePage;
import pages.AmazonUrunSayfasi;
import pages.AmazonUrunSepetSayfasi;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AmazonStepDef {

    AmazonHomePage amazonHomePage= new AmazonHomePage();
    AmazonUrunSayfasi amazonUrunSayfasi= new AmazonUrunSayfasi();
    AmazonUrunSepetSayfasi amazonUrunSepetSayfasi= new AmazonUrunSepetSayfasi();
    ReusableMethods reusableMethods= new ReusableMethods();
    @Given("Amazon sitesine giddily")
    public void amazon_sitesine_giddily() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        amazonHomePage.cerezleriKaldirma.click();
    }

        @Then("Kullanici Arama kutucuğuna “glasses” kelimesi girer ve arama yapar")
        public void kullanici_arama_kutucuğuna_glasses_kelimesi_girer_ve_arama_yapar() {
            amazonHomePage.aramaKutusu.sendKeys("glasses", Keys.ENTER);
        }

            @Then("Kullanici Arama kutucuguna girilen “glasses” kelimesini siler")
            public void kullanici_arama_kutucuguna_girilen_glasses_kelimesini_siler() {
                amazonHomePage.aramaKutusu.clear();
            }
            @Then("Kullanici Arama kutucuguna “sun glasses” kelimesini girer ve enter tusuna basar")
            public void kullanici_arama_kutucuguna_sun_glasses_kelimesini_girer_ve_enter_tusuna_basar() {
                amazonHomePage.aramaKutusu.sendKeys("sun_glasses",Keys.ENTER);

            }
            @Then("Kullanici sonuca göre sergilenen urunlerden rastgele bir urunu secer")
            public void kullanici_sonuca_gore_sergilenen_urunlerden_rastgele_bir_urunu_secer() {
                amazonHomePage.rastgeleSecilenUrun.click();
                reusableMethods.waitFor(3);

            }

    @Then("Secilen urunun fiyati 400TL den fazlaysa, arama ekranina geri donulur,{string} fiyat araligi secilir ve tekrar aranir. Ilk secenek secilir")
    public void secilen_urunun_fiyati_400tl_den_fazlaysa_arama_ekranina_geri_donulur_fiyat_araligi_secilir_ve_tekrar_aranir_ılk_secenek_secilir(String string) {
        String fiyat = amazonHomePage.secilenUrununFiyati.getText();
        int fiyatInt = Integer.parseInt(fiyat);

        //fiyat değişkeni containerına attığım ürün fiyatı 400 den büyükse sayfa 1 geri sayfa dönndürülür
        if (fiyatInt > 300)
            Driver.getDriver().navigate().back();

        //ürünlerin listelendiği sayfada 250-500 fiyat aralığı seçilerek sonuçlar filtrelendi
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(2);
        amazonHomePage.fiyatAralikCkeckBox.click();
        //reusableMethods.waitFor(3);

        //arama sayfasında listelenen ürün sayısı txt dosyasına yazdırıldı
        //List<WebElement> products= amazonHomePage.aramaSayfasindaListelenenUrunSayisi));
        String urunSayisi = amazonHomePage.aramaSayfasindaListelenenUrunSayisi.getText();

        reusableMethods.waitFor(2);

        //filtreleme sonrası listede yer alan ilk urun secilir
        amazonHomePage.urunListesindeIlkSecilecekUrun.click();
        reusableMethods.waitFor(2);
        //Seçilen ürünün bilgisi
        String urunBilgisi = amazonHomePage.secilenUrunBilgisi.getText();

        //Seçilen ürünün tutar bilgisi
        String tutarBilgisi = amazonHomePage.secilenUrununTutarBilgisi.getText();


            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("product_info.txt"));
                writer.write("Listelenen Ürün Sayısı: " + urunSayisi + "\n");
                writer.write("Seçilen Ürün: " + urunBilgisi + "\n");
                writer.write("Ürün Fiyatı: " + tutarBilgisi + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }}
    @Then("Kullanici seçilen urunu sepete ekler")
    public void kullanici_seçilen_urunu_sepete_ekler() {
        amazonUrunSayfasi.urunuSepeteEkleme.click();

    }
    @Then("Kullanici urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugunu karsilastirir")
    public void kullanici_urun_sayfasindaki_fiyat_ile_sepette_yer_alan_urun_fiyatinin_dogrulugunu_karsilastirir() {

        amazonUrunSepetSayfasi.sepet.click();
        reusableMethods.waitFor(2);

      String urunSepetFiyati=  amazonUrunSepetSayfasi.urunuSepetFiyati.getText();
        System.out.println("urunSepetFiyati = " + urunSepetFiyati);
        reusableMethods.waitFor(2);

        //urunun sayfadaki fiyatına ulaşmak için ürüne tıklanır
        amazonUrunSayfasi.urunSayfasi.click();
        reusableMethods.waitFor(2);

        //urun sayfasındaki ürün fiyatının texti alınır
        String urunSayfaFiyati=amazonUrunSayfasi.urunSayfasindakiFiyat.getText();
        System.out.println("urunSayfaFiyati = " + urunSayfaFiyati);

        Assert.assertTrue(urunSayfaFiyati.equals(urunSepetFiyati));

    }
//    @Then("Kullanici adet arttirarak urun adedinin {int} oldugunu dogrular")
//    public void kullanici_adet_arttirarak_urun_adedinin_oldugunu_dogrular(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
 //   }

            }








