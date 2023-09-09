package Test_File;

import POM.Meeting_POM;
import POM.Resolution_POM;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC3_Resolution_page extends TC1_Login_Page{

        Resolution_POM reso = new Resolution_POM(driver);
        Meeting_POM ob= new Meeting_POM(driver);
@Test(priority = 1)

        public void Resolution_Main() throws InterruptedException {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //click on resolution tab
       // reso.click_resolution();
       driver.findElement(By.xpath("//*[@id=\"RESOLUTIONS\"]")).click();
       Thread.sleep(4000);

       //click on add resolution
      driver.findElement(By.xpath("//*[@id=\"BTN_CREATE_RESOLUTIN\"]")).click();
      // reso.Add_Resolution();

       //click on worskspce
       ob.My_Workspace();
        }



}
