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
	WebElement Add_Organizer;

	@FindBy(id = "SEARCH")
	WebElement Search_Organizer;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	List<WebElement> Adding_Org;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	WebElement Org_Done;

	@FindBy(xpath = "//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	WebElement Org_Save;

	public void Meeting_Org() throws InterruptedException {

		Thread.sleep(5000);
		Add_Organizer.click();
		driver.switchTo().frame("_MODAL_ADD_organiser");
		Search_Organizer.sendKeys("core");
		Thread.sleep(4000);
		System.out.println(Adding_Org.size());
		int i = 0;
		for (i = 0; i <= Adding_Org.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Adding_Org.get(i).click();
			}
		}
		Thread.sleep(4000);

		Org_Done.click();

		Thread.sleep(4000);

		Org_Save.click();
	}

	@FindBy(xpath = "//a[@class='helper-ui text-decoration-none line-height-25 mt-add-contributor']")
	WebElement Agenda_CON;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement Age_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	List<WebElement> Adding_AC;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	WebElement AC_Done;

	 @FindBy(xpath ="//div[@class='mt-section-buttons contrib-section-buttons']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	 WebElement AC_Save;

	public void Meeting_AC() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Agenda_CON.click();

		Thread.sleep(3000);
		driver.switchTo().frame("_MODAL_ADD_contributor");
		Thread.sleep(4000);
		Age_Search.sendKeys("Convene");

		Thread.sleep(4000);
		System.out.println(Adding_AC.size());
		int i = 0;
		for (i = 0; i <= Adding_AC.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Adding_AC.get(i).click();
			}
		}
		Thread.sleep(3000);

		AC_Done.click();

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 AC_Save.click();
	}

	@FindBy(xpath = "//a[@class='helper-ui line-height-25 mt-add-attendee']")
	WebElement Participent;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement part_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	List<WebElement> Adding_Part;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	WebElement Part_Done;

	@FindBy(xpath = "//div[@id='SEC_ATTENDEES']//div[@class='mtsection-save-btns mtsection-btns-no-indent']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	WebElement Part_Save;

	public void Meeting_part() throws InterruptedException {
		Participent.click();
		driver.switchTo().frame("_MODAL_ADD_ATTENDEE");

		Thread.sleep(4000);
		part_Search.sendKeys("core");

		Thread.sleep(4000);
		System.out.println(Adding_Part.size());
		int i = 0;
		for (i = 0; i <= Adding_Part.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Adding_Part.get(i).click();
			}
		}
		
		Thread.sleep(3000);

		Part_Done.click();

		
		Thread.sleep(3000);

		Part_Save.click();
	}

	@FindBy(xpath = "//a[@class='helper-ui text-decoration-none line-height-25 mt-add-additional-access']")
	WebElement Additonal_Acc;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement AAC_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	WebElement Adding_AAC;

	@FindBy(xpath = "//input[@name='BTN_DONE']")
	WebElement AAC_Done;

	@FindBy(xpath = "//div[@id='SEC_ADDITIONAL_ACCESS']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")
	WebElement AAC_Save;

	public void Additional_Access() throws InterruptedException {
		
		Thread.sleep(5000);
		Additonal_Acc.click();
		driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");

		Thread.sleep(4000);
		AAC_Search.sendKeys("ben");
		
		Thread.sleep(4000);
		Adding_AAC.click();
		Thread.sleep(3000);

		AAC_Done.click();

		Thread.sleep(3000);

		AAC_Save.click();
		
		Thread.sleep(5000); 
	}

	@FindBy(xpath = "//div[@class='attach-file attach-file-dummy']")
	WebElement Upload_File;
	
	@FindBy(xpath="//input[@id='file-input-1']")
	WebElement File_Select;
	
	@FindBy(xpath="//input[@name='BTN_UPLOAD']")
	WebElement M_UFile;
	
	@FindBy(xpath = "//div[@class='agenda-item mt-box add-agenda-row new-agenda-row zoom-1']//div[@class='add-file-to-agenda-container']")
	WebElement Upload_File2;
	
	
	@FindBy(xpath="//input[@id='file-input-1']")
	WebElement Select_File2;
	
	@FindBy(xpath ="//input[@name='BTN_UPLOAD']")
	WebElement  M_File2;
	
	@FindBy(xpath="//div[@class='agenda-section-subheader']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']" )
	WebElement M_File_Save;
	
	
	
	public void Upload_Meeting_File() throws InterruptedException
	{
		Upload_File.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");
		
		String[] File_Path= {
				"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.txt",
				"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.pptx",
				"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.docx"
		};
		 for (String filePath : File_Path) {
			 File_Select.sendKeys(filePath);
	        }
		
		 Thread.sleep(5000);
		 M_UFile.click();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		 
		 
		 Upload_File2.click();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
			driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");
			
		 Select_File2.sendKeys("C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.txt");

		 Thread.sleep(4000);
		 
		 
		 M_File2.click();
		 
		 Thread.sleep(4000);
		 
		 M_File_Save.click();
		 
		
		 Thread.sleep(4000);
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
