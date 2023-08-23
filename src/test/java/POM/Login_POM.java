package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_POM extends Base_Class {

	public Login_POM(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//input[@id='LOGIN_ID']")
	WebElement User_Name;
	@FindBy(xpath = "//input[@id='PWD']")
	WebElement Password;
	@FindBy(id = "BTN_SIGN_IN")
	WebElement Click_Login;


	// Actions Methods

	public void C_Username(String UID) {
		User_Name.sendKeys(UID);
	}

	public void C_Password(String PWD) {
		Password.sendKeys(PWD);
	}

	public void Final_Login() {
		Click_Login.click();
	}


}
