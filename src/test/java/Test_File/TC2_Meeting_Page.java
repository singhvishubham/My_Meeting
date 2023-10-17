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

			// Meeting.New_Meeting();

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
				System.out.println(S1);

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

			 Meeting.M_Vanue.sendKeys(RB.getString("Vanue"));
			 

			Select Reminder1 = new Select(Meeting.M_Reminder);
			Reminder1.selectByIndex(2);

			Meeting.Scadule_Meeting.click();

			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Meeting.Meeting_Org();
			

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

			// Meeting.Meeting_AC();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Meeting.Agenda_CON.click();

			Thread.sleep(3000);
			driver.switchTo().frame("_MODAL_ADD_contributor");
			Thread.sleep(4000);
			Meeting.Age_Search.sendKeys("Convene");

			Thread.sleep(4000);
			System.out.println(Meeting.Adding_AC.size());
			int i1 = 0;
			for (i1 = 0; i1 <= Meeting.Adding_AC.size(); i1++) {
				if (i1 == 1 || i1 == 2 || i1 == 5) {
					Meeting.Adding_AC.get(i1).click();
				}
			}
			Thread.sleep(3000);

			Meeting.AC_Done.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Meeting.AC_Save.click();

			// Meeting.Meeting_part();
			Meeting.Participent.click();
			driver.switchTo().frame("_MODAL_ADD_ATTENDEE");

			Thread.sleep(4000);
			Meeting.part_Search.sendKeys("core");

			Thread.sleep(4000);
			System.out.println(Meeting.Adding_Part.size());
			int i11 = 0;
			for (i11 = 0; i11 <= Meeting.Adding_Part.size(); i11++) {
				if (i11 == 1 || i11 == 2 || i11 == 5) {
					Meeting.Adding_Part.get(i11).click();
				}
			}

			Thread.sleep(3000);

			Meeting.Part_Done.click();

			Thread.sleep(3000);

			Meeting.Part_Save.click();

			// Meeting.Additional_Access();
			Thread.sleep(5000);
			Meeting.Additonal_Acc.click();
			driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");

			Thread.sleep(4000);
			Meeting.AAC_Search.sendKeys("ben");

			Thread.sleep(4000);
			Meeting.Adding_AAC.click();
			Thread.sleep(3000);

			Meeting.AAC_Done.click();

			Thread.sleep(3000);

			Meeting.AAC_Save.click();

			Thread.sleep(5000);

			// Meeting.Upload_Meeting_File();
			Meeting.Upload_File.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");

			String[] File_Path = { "C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.txt",
					"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.pptx",
					"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.docx" };
			for (String filePath : File_Path) {
				Meeting.File_Select.sendKeys(filePath);
			}

			Thread.sleep(5000);
			
			Meeting.M_UFile.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Meeting.Upload_File2.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");

			Meeting.Select_File2.sendKeys("C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.txt");

			Thread.sleep(4000);

			Meeting.M_File2.click();

			Thread.sleep(4000);

			Meeting.M_File_Save.click();

			Thread.sleep(4000);

			// logger.info("****Logout from Meeting page***");
			// Meeting.C_Logout();
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
