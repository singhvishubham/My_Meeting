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
		Resolution_POM ob = new Resolution_POM(driver);

		try {
			Resolution_POM Reso = new Resolution_POM(driver);

			//Reso.click_resolution();

			ob.resolution.click();

			ob.add_Resolution.click();


			//Reso.Add_Resolution();



				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				ob.S_WorkSpace.click();

				Thread.sleep(2000);
				for (WebElement Ele1 : ob.Sel_WorkSpace) {
					String S1 = Ele1.getAttribute("id");
					if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
						Ele1.click();
					}
				}
				Thread.sleep(3000);
				ob.Reso_Name.sendKeys("Resolution_For_AzeusConvene");

				ob.Reso_Type.click();

				ob.Reo_Notes.sendKeys("All Participent Need to Join and Submit your Votes");

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				ob.Voting_Deadline.click();
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

				Select Reminder1 = new Select(ob.Send_Reminder);
				Reminder1.selectByIndex(5);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

				ob.Create_Reso.click();

				Thread.sleep(3000);

				ob.Accept_Reso.click();

				Thread.sleep(3000);



			Reso.Organizer();

			Reso.Voter();

			Reso.Additonal_Access();

			Reso.Upload_File();

		} catch (Exception e) {
			Assert.fail();
		}

	}

	private void click_resolution() {
		// TODO Auto-generated method stub

	}
}