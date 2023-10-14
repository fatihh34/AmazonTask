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


    //  (//*[@class='a-offscreen'])[2]
    //*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']
    //*[@class='a-offscreen']
}
