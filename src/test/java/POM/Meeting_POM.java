package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Meeting_POM extends Base_Class {

	public Meeting_POM(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "ACCEPT_BTN")
	WebElement Accept;

	public void Acc_Button() {
		Accept.click();
	}

	@FindBy(xpath = "//span[@id='LogoSubtitle']")
	WebElement message;
	
	
	@FindBy(id="BTN_NEW") 
	WebElement Scadule_NM;

	
	
	public void New_Meeting() {
		Scadule_NM.click();
	}
	
	
		public boolean getConfirmMessage() {
		try {
			return (message.isDisplayed());
		} catch (Exception e) {
			return (false);
		}

	}

	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @FindBy(xpath = "//*[text()='Sign Out']") WebElement Click_Logout;
	 * 
	 * public void C_Logout() { Click_Logout.click(); }
	 */
