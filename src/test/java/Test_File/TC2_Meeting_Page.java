package Test_File;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.Meeting_POM;

public class TC2_Meeting_Page extends TC1_Login_Page {

	@Test(priority = 1)

	public void Meeting() throws InterruptedException {

		try {
			Meeting_POM Meeting = new Meeting_POM(driver);
	
			boolean targetpage = Meeting.getConfirmMessage();

			Thread.sleep(4000);

			//Meeting.New_Meeting();
			
			Meeting.Scadule_NM.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			Meeting.W_Click.click();
			
			Thread.sleep(3000);
			
			for (WebElement Ele1 : Meeting.Ele) {
				System.out.println(Ele1.getAttribute("id"));
				String S1 = Ele1.getAttribute("id");
				if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
					Ele1.click();
				}

			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			Select Drop = new Select(Meeting.M_Type);
			Drop.selectByVisibleText("Board");

			Meeting.Meeting_Name.sendKeys("20230827_Meeting Portal Test_NOIDA_IND");
			
			Meeting.Cal.click();

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
			
			Meeting.M_Vanue.sendKeys("Manila");
			
			//Using Config Files
			//Meeting.M_Vanue(RB.getString("Vanue"));
			
			Select Reminder1 = new Select(Meeting.M_Reminder);
			Reminder1.selectByIndex(2);

			Meeting.Scadule_Meeting.click();

			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Meeting.Meeting_Org();

			Meeting.Add_Organizer.click();
			driver.switchTo().frame("_MODAL_ADD_organiser");
			Meeting.Search_Organizer.sendKeys("core");
			Thread.sleep(4000);
			System.out.println(Meeting.Adding_Org.size());
			int i = 0;
			for (i = 0; i <= Meeting.Adding_Org.size(); i++) {
				if (i == 1 || i == 2 || i == 5) {
					Meeting.Adding_Org.get(i).click();
				}
			}
			Thread.sleep(4000);

			Meeting.Org_Done.click();

			Thread.sleep(4000);

			Meeting.Org_Save.click();
			
			Thread.sleep(3000);
			
			
			
			
			
			//Meeting.Meeting_AC();
			
			Meeting.Meeting_part();

			Meeting.Additional_Access();
			
			
			Meeting.Upload_Meeting_File();
			// logger.info("****Logout from Meeting page***");
			// Meeting.C_Logout();
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
