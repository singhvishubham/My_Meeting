package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Meeting_POM<WebElements> extends Base_Class {

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

	@FindBy(id = "BTN_NEW")
	WebElement Scadule_NM;

	public void New_Meeting() {
		Scadule_NM.click();
	}

	@FindBy(xpath = "//input[@aria-label=\"Workspace\"]")
	WebElement W_Click;

	public void My_Workspace() {
		W_Click.click();
	}

	@FindBy(xpath = "//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]")
	List<WebElement> Ele;

	public void Select_Workspace() {
		for (WebElement Ele1 : Ele) {
			System.out.println(Ele1.getAttribute("id"));
			String S1 = Ele1.getAttribute("id");
			if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
				Ele1.click();
			}

		}
	}

	@FindBy(id = "MEETING_TYPE")
	WebElement M_Type;

	public void Type() {
		Select Drop = new Select(M_Type);
		Drop.selectByVisibleText("Board");

	}

	@FindBy(xpath = "//textarea[@name='TITLE-en_GB']")
	WebElement Meeting_Name;

	public void M_Name(String MNAME) {
		Meeting_Name.sendKeys(MNAME);
	}

	@FindBy(xpath = "//div[@class='date-picker']")
	WebElement Cal;

	public void Calender() {
		Cal.click();

		String Month = "May 2024";
		String Day = "14";
		while (true) {
			String S1 = driver.findElement(By.xpath("//td[@class='title']")).getText();

			if (S1.contains(Month)) {
				break;
			}
			driver.findElement(By.xpath("//*[text()='›']")).click();

		}
		List<WebElement> AllDates = driver.findElements(By.xpath("//tbody//tr[@class='daysrow']//td"));
		for (WebElement mydt : AllDates) {
			if (mydt.getText().equals(Day)) {
				mydt.click();
			}
		}

	}
	
	@FindBy(id="VENUE")
	WebElement M_Vanue;
	
	public void M_Vanue(String Vanue) {
		M_Vanue.sendKeys(Vanue);
	}
	
	@FindBy(id="ALERT_TIME")
	WebElement M_Reminder;
	
	public void Alert() {
		Select Reminder1 = new Select(M_Reminder);
		Reminder1.selectByIndex(2);
	}
	
	@FindBy(xpath="//input[@name='BTN_SAVE_MEETING']")
	WebElement Scadule_Meeting;
	
	public void Sc_Meeting() {
		Scadule_Meeting.click();
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
