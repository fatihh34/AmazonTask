package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonUrunSayfasi {
    public AmazonUrunSayfasi(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='add-to-cart-button']")
    public WebElement urunuSepeteEkleme;

    @FindBy(xpath = "sc-product-image")
    public WebElement urunSayfasi;

    @FindBy(xpath = "(//*[@class='a-offscreen'])[1]")
    public WebElement urunSayfasindakiFiyat;


}
