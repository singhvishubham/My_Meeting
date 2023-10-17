package POM;

import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Resolution_POM extends Base_Class {

	public Resolution_POM(WebDriver driver) {
		super(driver);
	}

	  
	
	@FindBy(xpath = "//span[@id='LogoSubtitle']")
	WebElement message;

	@FindBy(xpath = "//*[@id='RESOLUTIONS']")
	public WebElement resolution;

	@FindBy(xpath = "//*[@id=\"BTN_CREATE_RESOLUTIN\"]")
	public WebElement add_Resolution;

	
	/* Resolution home page Web Elements  */
	
	@FindBy(xpath = "//input[@aria-label='Workspace']")
	public WebElement S_WorkSpace;

	@FindBy(xpath = "//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]")
	public List<WebElement> Sel_WorkSpace;

	@FindBy(id = "SUBJ")
	public WebElement Reso_Name;

	// Show of Hands Resolution.
	@FindBy(id = "rd_RESOLN_TYPE_N")
	public WebElement Reso_Type;

	// Secret Ballot Resolutions.
	// @FindBy(id = "rd_RESOLN_TYPE_A")
	// WebElement SB_Reso;

	@FindBy(id = "NOTES_TO_VOTERS")
	public WebElement Reo_Notes;

	@FindBy(id = "ADD_DUE_DT_BTN")
	public WebElement Voting_Deadline;

	@FindBy(id = "ALERT_TIME")
	public WebElement Send_Reminder;

	@FindBy(id = "BTN_CREATE")
	public WebElement Create_Reso;

	@FindBy(xpath = "//div[@class='qtip-content']//button[@id='btn-yes']")
	public WebElement Accept_Reso;

	
	/* Organizer  Web Elements  */

	@FindBy(id = "ADD_ORGANISERS_BTN")
	public WebElement Add_Organizer;

	@FindBy(xpath = "//input[@id='SEARCH']")
	 public WebElement Org_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public List<WebElement> Org_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	public WebElement O_Done;

	@FindBy(xpath = "//div[@id='SAVE_ORGANISERS_BUTTON']")
	public WebElement O_Save;

	/* Voters Web Elements  */
	
	@FindBy(id = "ADD_VOTERS_BTN")
	 public WebElement Add_Voters;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement Voter_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public List<WebElement> Voter_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	public WebElement V_Done;

	@FindBy(xpath = "//div[@id='SAVE_VOTERS_BUTTON']")
	public WebElement V_Save;

	/* Additional Access Web Elements*/
	
	@FindBy(id = "ADD_ADDTL_ACCESS_BTN")
	public WebElement Add_AC;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement AAC_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	public WebElement AAC_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	public WebElement AAC_Done;

	@FindBy(xpath = "//div[@id='SAVE_ADDTL_ACCESS_BUTTON']")
	public WebElement AAC_Save;
	
	
/* Upload File Web Elements  */
	
	@FindBy(xpath="//div[@id='document-list']//img[@class='add-document-file']")
	public  WebElement Upload_File2;
	
	@FindBy(xpath="//input[@id='file-input-1']")
	public WebElement Select_File2;
	
	@FindBy(xpath="//input[@name='BTN_UPLOAD']")
	public WebElement M_File2;
	
	
	@FindBy(xpath="//div[@id='SAVE_DOCUMENTS_BUTTON']")
	public WebElement M_File_Save;
	
	
	public boolean getConfirmMessage() {
		try {
			return (message.isDisplayed());
		} catch (Exception e) {
			return (false);
		}

	}
}
