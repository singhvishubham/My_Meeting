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

	/*public void click_resolution() {

		resolution.click();

		add_Resolution.click();
	}*/

	@FindBy(xpath = "//input[@aria-label='Workspace']")
	WebElement S_WorkSpace;

	@FindBy(xpath = "//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]")
	List<WebElement> Sel_WorkSpace;

	@FindBy(id = "SUBJ")
	WebElement Reso_Name;

	// Show of Hands Resolution.
	@FindBy(id = "rd_RESOLN_TYPE_N")
	WebElement Reso_Type;

	// Secret Ballot Resolutions.

	// @FindBy(id = "rd_RESOLN_TYPE_A")
	// WebElement SB_Reso;

	@FindBy(id = "NOTES_TO_VOTERS")
	WebElement Reo_Notes;

	@FindBy(id = "ADD_DUE_DT_BTN")
	WebElement Voting_Deadline;

	@FindBy(id = "ALERT_TIME")
	WebElement Send_Reminder;

	@FindBy(id = "BTN_CREATE")
	WebElement Create_Reso;

	@FindBy(xpath = "//div[@class='qtip-content']//button[@id='btn-yes']")
	WebElement Accept_Reso;

	public void Add_Resolution() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S_WorkSpace.click();

		Thread.sleep(2000);
		for (WebElement Ele1 : Sel_WorkSpace) {
			String S1 = Ele1.getAttribute("id");
			if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
				Ele1.click();
			}
		}
		Thread.sleep(3000);
		Reso_Name.sendKeys("Resolution_For_AzeusConvene");

		Reso_Type.click();

		Reo_Notes.sendKeys("All Participent Need to Join and Submit your Votes");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Voting_Deadline.click();
		String Month = "November 2023";
		String Day = "14";
		while (true) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			String S2 = driver.findElement(By.xpath("//td[@class='title']")).getText();
			System.out.println(S2);

			if (S2.contains(Month)) {
				break;
			}
			driver.findElement(By.xpath("//*[text()='›']")).click();
		}
		List<WebElement> AllDates = driver.findElements(By.xpath("//tbody//tr[@class='daysrow']//td"));
		for (WebElement mydt : AllDates) {
			if (mydt.getText().contains(Day)) {
				mydt.click();
			}
		}

		driver.findElement(By.id("DUE_TIME_STRING")).click();
		driver.findElement(By.xpath("//*[@id='SEC_RESOLUTION_INFO']/div[2]/ul/li[46]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Select Reminder1 = new Select(Send_Reminder);
		Reminder1.selectByIndex(5);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Create_Reso.click();

		Thread.sleep(3000);

		Accept_Reso.click();

		Thread.sleep(3000);
	}

	@FindBy(id = "ADD_ORGANISERS_BTN")
	WebElement Add_Organizer;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement Org_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	List<WebElement> Org_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	WebElement O_Done;

	@FindBy(xpath = "//div[@id='SAVE_ORGANISERS_BUTTON']")
	WebElement O_Save;

	public void Organizer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Add_Organizer.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("_MODAL_ADD_ORGANISER");

		Thread.sleep(3000);
		Org_Search.sendKeys("Core");

		Thread.sleep(4000);

		System.out.println(Org_Searched_user.size());
		int i = 0;
		for (i = 0; i <= Org_Searched_user.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Org_Searched_user.get(i).click();
			}
		}
		Thread.sleep(4000);

		O_Done.click();

		Thread.sleep(3000);

		O_Save.click();
	}

	@FindBy(id = "ADD_VOTERS_BTN")
	WebElement Add_Voters;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement Voter_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	List<WebElement> Voter_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	WebElement V_Done;

	@FindBy(xpath = "//div[@id='SAVE_VOTERS_BUTTON']")
	WebElement V_Save;

	public void Voter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Add_Voters.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("_MODAL_ADD_VOTER");

		Thread.sleep(3000);
		Voter_Search.sendKeys("Core");

		Thread.sleep(4000);

		System.out.println(Voter_Searched_user.size());
		int i = 0;
		for (i = 0; i <= Voter_Searched_user.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Voter_Searched_user.get(i).click();
			}
		}
		Thread.sleep(4000);

		V_Done.click();

		Thread.sleep(3000);

		V_Save.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@FindBy(id = "ADD_ADDTL_ACCESS_BTN")
	WebElement Add_AC;

	@FindBy(xpath = "//input[@id='SEARCH']")
	WebElement AAC_Search;

	@FindBy(xpath = "//tbody//tr//td//input[@value='Add']")
	WebElement AAC_Searched_user;

	@FindBy(xpath = "//input[@id='BTN_DONE']")
	WebElement AAC_Done;

	@FindBy(xpath = "//div[@id='SAVE_ADDTL_ACCESS_BUTTON']")
	WebElement AAC_Save;

	
	public void Additonal_Access() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Add_AC.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");


		Thread.sleep(4000);

		System.out.println(Voter_Searched_user.size());
		
		AAC_Search.sendKeys("ben");
		
		Thread.sleep(4000);
		
		AAC_Searched_user.click();
		
		Thread.sleep(3000);
		

		AAC_Done.click();

		Thread.sleep(3000);

		AAC_Save.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[@id='document-list']//img[@class='add-document-file']")
	WebElement Upload_File2;
	
	@FindBy(xpath="//input[@id='file-input-1']")
	WebElement Select_File2;
	
	@FindBy(xpath="//input[@name='BTN_UPLOAD']")
	WebElement M_File2;
	
	
	@FindBy(xpath="//div[@id='SAVE_DOCUMENTS_BUTTON']")
	WebElement M_File_Save;
	
	 public void Upload_File() throws InterruptedException {
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 Upload_File2.click();
		 
		 driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 		 
		 Select_File2.sendKeys("C:\\Users\\ssing\\Desktop\\Test Files\\test.txt");
		 
		 Thread.sleep(3000);
		 
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
