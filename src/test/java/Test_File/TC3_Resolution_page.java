package Test_File;

import POM.Resolution_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;


public class TC3_Resolution_page extends TC1_Login_Page {

	@Test(priority = 1)
	public void Resolution_Main() throws InterruptedException {
		Resolution_POM Reso_object = new Resolution_POM(driver);

		
		try {
		
			Reso_object.resolution.click();

			Reso_object.add_Resolution.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			Reso_object.S_WorkSpace.click();

			Thread.sleep(2000);
			for (WebElement Ele1 : Reso_object.Sel_WorkSpace) {
				String S1 = Ele1.getAttribute("id");
				if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
					Ele1.click();
				}
			}
			Thread.sleep(3000);
			Reso_object.Reso_Name.sendKeys("Resolution_For_AzeusConvene");

			Reso_object.Reso_Type.click();

			Reso_object.Reo_Notes.sendKeys("All Participent Need to Join and Submit your Votes");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Reso_object.Voting_Deadline.click();
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

			Select Reminder1 = new Select(Reso_object.Send_Reminder);
			Reminder1.selectByIndex(5);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Reso_object.Create_Reso.click();

			Thread.sleep(3000);

			Reso_object.Accept_Reso.click();

			Thread.sleep(3000);

//			Reso.Organizer();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Reso_object.Add_Organizer.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("_MODAL_ADD_ORGANISER");

			Thread.sleep(3000);
			Reso_object.Org_Search.sendKeys("Core");

			Thread.sleep(4000);

			System.out.println(Reso_object.Org_Searched_user.size());
			int i = 0;
			for (i = 0; i <= Reso_object.Org_Searched_user.size(); i++) {
				if (i == 1 || i == 2 || i == 5) {
					Reso_object.Org_Searched_user.get(i).click();
				}
			}
			Thread.sleep(4000);

			Reso_object.O_Done.click();

			Thread.sleep(3000);

			Reso_object.O_Save.click();

			// Reso.Voter();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Reso_object.Add_Voters.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame("_MODAL_ADD_VOTER");

			Thread.sleep(3000);
			Reso_object.Voter_Search.sendKeys("Core");

			Thread.sleep(4000);

			System.out.println(Reso_object.Voter_Searched_user.size());
			int i1 = 0;
			for (i1 = 0; i1 <= Reso_object.Voter_Searched_user.size(); i1++) {
				if (i1 == 1 || i1 == 2 || i1 == 5) {
					Reso_object.Voter_Searched_user.get(i1).click();
				}
			}
			Thread.sleep(4000);

			Reso_object.V_Done.click();

			Thread.sleep(3000);

			Reso_object.V_Save.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Reso.Additonal_Access();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Reso_object.Add_AC.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");

			Thread.sleep(4000);

			System.out.println(Reso_object.Voter_Searched_user.size());

			Reso_object.AAC_Search.sendKeys("ben");

			Thread.sleep(4000);

			Reso_object.AAC_Searched_user.click();

			Thread.sleep(3000);

			Reso_object.AAC_Done.click();

			Thread.sleep(3000);

			Reso_object.AAC_Save.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Reso_object.Upload_File2.click();

			driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			String File = System.getProperty("user.dir")+"\\Test Files\\test.txt";
					
			Reso_object.Select_File2.sendKeys(File);

			Thread.sleep(3000);

			Reso_object.M_File2.click();

			Thread.sleep(4000);

			Reso_object.M_File_Save.click();

			Thread.sleep(4000);

		} catch (Exception e) {
			Assert.fail();
		}

	}


}