package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonHomePage {

    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@id='sp-cc-rejectall-link']")
    public WebElement cerezleriKaldirma;

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//*[@class='a-section aok-relative s-image-tall-aspect'])[1]")
    public WebElement rastgeleSecilenUrun;

    @FindBy(xpath = "(//*[@class='a-price-whole'])[1]")
    public WebElement secilenUrununFiyati;

    @FindBy(xpath = "//*[text()='250 – 500 TL']")
    public WebElement fiyatAralikCkeckBox;

    @FindBy(xpath = "(//*[@class='s-image'])[1]")
    public WebElement urunListesindeIlkSecilecekUrun;

    @FindBy(xpath = "//*[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSayfasindaListelenenUrunSayisi;

    @FindBy(xpath = "//*[@id='productTitle']")
    public WebElement secilenUrunBilgisi;

    @FindBy(xpath = "//*[@class='a-section a-spacing-none aok-align-center']")
    public WebElement secilenUrununTutarBilgisi;

    //@FindBy(xpath = "(//*[@class='a-offscreen'])[2]")
    //public WebElement secilenUrununTutarBilgisi;

}
