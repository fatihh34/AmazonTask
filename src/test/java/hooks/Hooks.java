package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class Hooks {


    /*
    Hooks : Her bir Scenario yada Scenario Outline dan ONCE yada SONRA calismasmasini istedigim metotlar konur
    @Before ve @After metotlarini icerir
    Burda onemli olan raporlama isleminin ekran goruntusuyle birlikde Hooks yardimiyla yapilmasidir
     */
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    @Before
    public void setUpScenarios(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

    }
    @After
    public void tearDownScenarios(Scenario scenario) throws InterruptedException {

//        Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            Thread.sleep(1000);
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//                       ekran goruntusu    file tipi                  ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());
            Driver.closeDriver();
        }
        //Driver.closeDriver();
    }
}
