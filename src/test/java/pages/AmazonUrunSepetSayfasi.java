package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonUrunSepetSayfasi {
    public AmazonUrunSepetSayfasi(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement urunuSepetFiyati;

    @FindBy(xpath = "//*[@class='a-button a-spacing-top-base a-button-span12 a-button-base celwidget']")
    public WebElement sepet;

    @FindBy(xpath = "//*[@class='a-button-text a-declarative']")
    public WebElement dropdown;

    @FindBy(xpath = "//*[@id='quantity_2']")
    public WebElement dropdown2;

    @FindBy(xpath = "//*[@id='sc-subtotal-label-buybox']")
    public WebElement urunAdetiIki;





}
