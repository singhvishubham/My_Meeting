package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Meeting_POM extends Base_Class {

	public Meeting_POM(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@id='LogoSubtitle']")
	WebElement message;

	@FindBy(id = "BTN_NEW")
	public WebElement Scadule_NM;

	@FindBy(xpath = "//input[@aria-label='Workspace']")
	public WebElement W_Click;

	@FindBy(xpath = "//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]")
	public List<WebElement> Ele;

	@FindBy(id = "MEETING_TYPE")
	public WebElement M_Type;

	@FindBy(xpath = "//textarea[@name='TITLE-en_GB']")
	public WebElement Meeting_Name;

	@FindBy(xpath = "//div[@class='date-picker']")
	public WebElement Cal;

	@FindBy(id = "VENUE")
	public WebElement M_Vanue;

	@FindBy(id = "ALERT_TIME")
	public WebElement M_Reminder;

	@FindBy(xpath = "//input[@name='BTN_SAVE_MEETING']")
	public WebElement Scadule_Meeting;

	// Organizer POM

	@FindBy(xpath = "//a[@class='helper-ui line-height-25 text-decoration-none mt-add-organiser']")
	public WebElement Add_Organizer;

	@FindBy(id = "SEARCH")
	public WebElement Search_Organizer;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public List<WebElement> Adding_Org;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement Org_Done;

	@FindBy(xpath = "//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	public WebElement Org_Save;

	@FindBy(xpath = "//a[@class='helper-ui text-decoration-none line-height-25 mt-add-contributor']")
	public WebElement Agenda_CON;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement Age_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public List<WebElement> Adding_AC;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement AC_Done;

	@FindBy(xpath = "//div[@class='mt-section-buttons contrib-section-buttons']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	public WebElement AC_Save;

	@FindBy(xpath = "//a[@class='helper-ui line-height-25 mt-add-attendee']")
	public WebElement Participent;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement part_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public List<WebElement> Adding_Part;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement Part_Done;

	@FindBy(xpath = "//div[@id='SEC_ATTENDEES']//div[@class='mtsection-save-btns mtsection-btns-no-indent']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	public WebElement Part_Save;

	@FindBy(xpath = "//a[@class='helper-ui text-decoration-none line-height-25 mt-add-additional-access']")
	public WebElement Additonal_Acc;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement AAC_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public WebElement Adding_AAC;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement AAC_Done;

	@FindBy(xpath = "//div[@id='SEC_ADDITIONAL_ACCESS']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	public WebElement AAC_Save;

	@FindBy(xpath = "//div[@class='attach-file attach-file-dummy']")
	public WebElement Upload_File;

	@FindBy(xpath = "//input[@id='file-input-1']")
	public WebElement File_Select;

	@FindBy(xpath = "//input[@name='BTN_UPLOAD']")
	public WebElement M_UFile;

	@FindBy(xpath = "//div[@class='agenda-item mt-box add-agenda-row new-agenda-row zoom-1']//div[@class='add-file-to-agenda-container']")
	public WebElement Upload_File2;

	@FindBy(xpath = "//input[@id='file-input-1']")
	public WebElement Select_File2;

	@FindBy(xpath = "//input[@name='BTN_UPLOAD']")
	public WebElement M_File2;

	@FindBy(xpath = "//div[@class='agenda-section-subheader']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	public WebElement M_File_Save;

	public void Upload_Meeting_File() throws InterruptedException {
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
