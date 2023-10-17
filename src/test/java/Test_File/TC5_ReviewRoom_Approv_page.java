package Test_File;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Review_Room_POM;

public class TC5_ReviewRoom_Approv_page extends TC1_Login_Page {
	@Test(priority = 1)
	public void ReviewRoom_Main2() throws InterruptedException {
		Review_Room_POM RR_object = new Review_Room_POM(driver);

		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Reaching index page of Review Room
			RR_object.Review_Room.click();

			RR_object.Add_RR.click();

			Thread.sleep(3000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			RR_object.RR_Workspace.click();

			for (WebElement Ele1 : RR_object.Select_WS) {
				String S1 = Ele1.getAttribute("id");
				if (S1.contains("REL_COMPANY_ID-172") || S1.contains("REL_COMPANY_ID-109")) {
					Ele1.click();
				}

			}

			Thread.sleep(3000);
			Select Type_RR = new Select(RR_object.RR_Types);
			Type_RR.selectByIndex(1);

			Thread.sleep(3000);

			RR_object.RR_Title.sendKeys(RB.getString("RA"));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			RR_object.RR_Descriptions.sendKeys("Simple Review Room");

			RR_object.RR_DueDate.click();

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

			Thread.sleep(4000);

			RR_object.RR_Create.click();

			Thread.sleep(4000);

			RR_object.RR_Draft.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			RR_object.RR_Organizer1.click();

			driver.switchTo().frame("_MODAL_ADD_organiser");
			RR_object.RR_O_Search.sendKeys("core");

			Thread.sleep(3000);

			System.out.println(RR_object.Seach_Org.size());

			int i = 0;
			for (i = 0; i <= RR_object.Seach_Org.size(); i++) {
				if (i == 1 || i == 2 || i == 5) {
					RR_object.Seach_Org.get(i).click();
				}

			}
			Thread.sleep(4000);

			RR_object.RR_Org_Done.click();

			Thread.sleep(4000);

			RR_object.RR_Org_Save.click();

			Thread.sleep(3000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			RR_object.RR_Reviewers.click();

			driver.switchTo().frame("_MODAL_ADD_ATTENDEE");

			RR_object.RR_R_Search.sendKeys("convene");

			System.out.println(RR_object.RR_R_Search.getSize());

			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			int j = 0;
			for (j = 0; j <= RR_object.Seach_Rev.size(); j++) {

				if (j == 1 || j == 2) {
					RR_object.Seach_Rev.get(j).click();
				}

			}
			Thread.sleep(3000);
			RR_object.RR_RR_Done.click();

			Thread.sleep(3000);
			RR_object.RR_RR_Save.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			RR_object.RR_Add_Acc.click();

			driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");

			RR_object.RR_Add_Acc_Search.sendKeys("mariz 2");

			Thread.sleep(4000);

			RR_object.Seach_Add_Acc1.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			RR_object.RR_Add_Acc_Done.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			RR_object.RR_Add_Acc_Save.click();

			RR_object.File_Upload_RR.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");

			String[] File_Path = { "C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.txt",
					"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.pptx",
					"C:\\Users\\ssing\\Desktop\\Selenium\\My_Meeting\\Testing_Files\\test.docx" };
			for (String filePath : File_Path) {
				RR_object.File_Select.sendKeys(filePath);
			}
			Thread.sleep(3000);

			RR_object.M_UFile.click();

			Thread.sleep(5000);

			RR_object.RR_SaveFile.click();

		}

		catch (Exception e) {
			Assert.fail();

		}
	}

}
