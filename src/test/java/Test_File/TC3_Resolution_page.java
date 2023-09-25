package Test_File;

import POM.Meeting_POM;
import POM.Resolution_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC3_Resolution_page extends TC1_Login_Page {

    Resolution_POM reso = new Resolution_POM(driver);
    Meeting_POM ob = new Meeting_POM(driver);

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

        //click on worskspce and select value
        // ob.My_Workspace();
        driver.findElement(By.xpath("//input[@aria-label=\"Workspace\"]")).click();
        List<WebElement> Ele = driver.findElements(By.xpath("//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]"));
        for (WebElement Ele1 : Ele) {
            System.out.println(Ele1.getAttribute("id"));
            String S1 = Ele1.getAttribute("id");
            if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
                Ele1.click();
            }
        }
        //Given subject value
        driver.findElement(By.id("SUBJ")).sendKeys("Maths discussion");

        /*select voting method*/
        driver.findElement(By.id("rd_RESOLN_TYPE_N")).click();

        //select Secret ballot
        // driver.findElement(By.id("rd_RESOLN_TYPE_A")).click();

        //Notes for Voters
        driver.findElement(By.id("NOTES_TO_VOTERS")).sendKeys("Please attend the Meeting ");

        //voting Deadline
        driver.findElement(By.id("ADD_DUE_DT_BTN")).click();
        //driver.findElement(By.id("DUE_DT_EDITABLE")).click();

        //select calender value
        String Month = "November 2023";
        String Day = "14";
        while (true) {
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(3000));
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

        //select the time
        driver.findElement(By.id("DUE_TIME_STRING")).click();
//        Select select_value =  new Select(driver.findElement(By.xpath("//input[@id='DUE_TIME_STRING']")));
//        select_value.selectByValue("11:30 AM");
        driver.findElement(By.xpath("//*[@id=\"SEC_RESOLUTION_INFO\"]/div[2]/ul/li[46]")).click();


        //select reminder time
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(3000));
        driver.findElement(By.id("ALERT_TIME")).click();
        Select select_alert_time = new Select(driver.findElement(By.xpath("///*[@id=\"ALERT_TIME\"]")));
        select_alert_time.selectByIndex(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(3000));


        //select create resolution
        driver.findElement(By.id("BTN_CREATE")).click();

    }
    //Select Workspace
    //ob.Select_Workspace();
}



