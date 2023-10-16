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

    @FindBy(xpath = "//*[@class='sc-product-image']")
    public WebElement urunSayfasi;

    @FindBy(xpath = "//*[@id=\"corePrice_feature_div\"]/div/span[1]/span[2]")
    public WebElement urunSayfasindakiFiyat;

    @FindBy(xpath = "(//*[@id='acrCustomerReviewText'])[1]")
    public WebElement denemekicinyorumlocate;


}
