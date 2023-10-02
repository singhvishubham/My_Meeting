package Test_File;

import POM.Resolution_POM;
import org.openqa.selenium.By;
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
		try {
			Resolution_POM Reso = new Resolution_POM(driver);
			
			public void click_resolution() {

				Reso.resolution.click();

				Reso.add_Resolution.click();
			}

			Reso.Add_Resolution();
			
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