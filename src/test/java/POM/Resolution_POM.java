package POM;

import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Resolution_POM extends Base_Class {

    public Resolution_POM(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@id='LogoSubtitle']")
    WebElement message;

    @FindBy(xpath = "//*[@id='RESOLUTIONS']")
    WebElement resolution;

    @FindBy(xpath = "//*[@id=\"BTN_CREATE_RESOLUTIN\"]")
    WebElement add_Resolution;

    public void click_resolution(){
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RESOLUTIONS\"]")));
        resolution.click();
    }

    public void Add_Resolution(){
        add_Resolution.click();
    }





    public boolean getConfirmMessage() {
        try {
            return (message.isDisplayed());
        } catch (Exception e) {
            return (false);
        }

    }
}
