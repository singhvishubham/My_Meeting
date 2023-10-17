package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Review_Room_POM extends Base_Class {

	public Review_Room_POM(WebDriver driver) {
		super(driver);
	}

	/* Initial Review Room Web Page Elements */

	@FindBy(id = "REVIEW_ROOM")
	public  WebElement Review_Room;

	@FindBy(id = "BTN_ADD_NEW_MEETING")
	public  WebElement Add_RR;

	// Main Creating Review Room

	@FindBy(xpath = "//div[@class='selectize-input items not-full has-options']")
	public WebElement RR_Workspace;

	@FindBy(xpath = "//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]")
	public List<WebElement> Select_WS;

	@FindBy(id = "REVIEW_ROOM_PURPOSE")
	public WebElement RR_Types;

	@FindBy(name = "TITLE")
	public WebElement RR_Title;

	@FindBy(id = "PURPOSE")
	public WebElement RR_Descriptions;

	@FindBy(xpath = "//a[@id='add-due-date-link']")
	public WebElement RR_DueDate;

	@FindBy(xpath = "//input[@name='BTN_SAVE_MEETING']")
	public WebElement RR_Create;

	@FindBy(xpath = "//div[@id='hide-unpublished-notif-btn']")
	public WebElement RR_Draft;

	// Organizer Section

	@FindBy(xpath = "//div[@id='neworganiserRow']//a")
	public WebElement RR_Organizer1;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement RR_O_Search;

	@FindBy(xpath = "//input[@value='Add']")
	public List<WebElement> Seach_Org;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement RR_Org_Done;

	@FindBy(xpath = "//div[@id='SEC_organiserS']//*[text()='Save']")
	public WebElement RR_Org_Save;

	// Reviewer Section

	@FindBy(xpath = "//div[@class='mt-item sortable-item new-attendee-row']//a")
	public WebElement RR_Reviewers;

	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement RR_R_Search;

	@FindBy(xpath = "//input[@value='Add']")
	public List<WebElement> Seach_Rev;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement RR_RR_Done;

	@FindBy(xpath = "//div[@id='SEC_ATTENDEES']//*[text()='Save']")
	public WebElement RR_RR_Save;

	
	//Additional Access
	
	@FindBy(xpath="//div[@id='ADDITIONAL_ACCESS']//a")
	public WebElement RR_Add_Acc;
	
	@FindBy(xpath = "//input[@id='SEARCH']")
	public WebElement RR_Add_Acc_Search;

	@FindBy(xpath = "//input[@value='Add']")
	public WebElement Seach_Add_Acc1;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	public WebElement RR_Add_Acc_Done;

	@FindBy(xpath = "//div[@id='SEC_ADDITIONAL_ACCESS']//*[text()='Save']")
	public WebElement RR_Add_Acc_Save;

	
	//Upload FIle in Review Room
	
	@FindBy(xpath="//div[@class='attach-file attach-file-new']//a")
	public WebElement File_Upload_RR;
	
	@FindBy(xpath = "//input[@id='file-input-1']")
	public WebElement File_Select;

	@FindBy(xpath = "//input[@name='BTN_UPLOAD']")
	public WebElement M_UFile;

	
	@FindBy(xpath="//div[@id='agenda-section-header']//*[text()='Save']")
	public WebElement RR_SaveFile;
	
	
	//For Sign Off 
	@FindBy(id="REVIEW_SEQ")
	public WebElement Sign_OffRR;
	
	public void Home_ReviewRoom() throws InterruptedException {

		Thread.sleep(5000);

	
	}

}
