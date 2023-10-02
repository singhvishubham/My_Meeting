package All_code;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All_Resolution {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(Options);
		WebDriverWait MyWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://test-v58.azeusconvene.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("LOGIN_ID")).sendKeys("core1");
		driver.findElement(By.id("PWD")).sendKeys("test1234");
		driver.findElement(By.xpath("//input[@id='BTN_SIGN_IN']")).click();

		Thread.sleep(3000);
		WebElement TC = MyWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCEPT_BTN")));
		TC.click();

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='RESOLUTIONS']")).click();
        Thread.sleep(4000);

        //click on add resolution
        driver.findElement(By.xpath("//*[@id='BTN_CREATE_RESOLUTIN']")).click();
        // reso.Add_Resolution();

        
        
        
        
        //click on worskspce and select value
        // ob.My_Workspace();
        driver.findElement(By.xpath("//input[@aria-label='Workspace']")).click();
        List<WebElement> Ele = driver.findElements(By.xpath("//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]"));
        for (WebElement Ele1 : Ele) {
           // System.out.println(Ele1.getAttribute("id"));
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

        //select the time
        driver.findElement(By.id("DUE_TIME_STRING")).click();
//        Select select_value =  new Select(driver.findElement(By.xpath("//input[@id='DUE_TIME_STRING']")));
//        select_value.selectByValue("11:30 AM");
        driver.findElement(By.xpath("//*[@id=\"SEC_RESOLUTION_INFO\"]/div[2]/ul/li[46]")).click();


        //select reminder time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.findElement(By.id("ALERT_TIME")).click();
        Select select_alert_time = new Select(driver.findElement(By.id("ALERT_TIME")));
        select_alert_time.selectByIndex(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        // String parentWindowHandle = driver.getWindowHandle();
        //select create resolution
        driver.findElement(By.id("BTN_CREATE")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(2000);

        
        //resolution in draft prompt handle
        //click on OK button

//        driver.switchTo().activeElement();
//        Set<String> windowHandles = driver.getWindowHandles();
//
//// Switch to the pop-up window
//        for (String handle: windowHandles) {
//            if (!handle.equals(parentWindowHandle)) {
//                driver.switchTo().window(handle);
//                break;
//            }
//        }
        driver.findElement(By.xpath("//div[@class='qtip-content']//button[@id='btn-yes']")).click();
        //click on do not show again
        //driver.findElement(By.id("btn-no")).click();


        //add organiser
        String Org_title = driver.findElement(By.id("organiser-section-header-title")).getText();
        try {
            if (Org_title.equals("Organisers")) {

                driver.findElement(By.id("ADD_ORGANISERS_BTN")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

               //search User
                driver.switchTo().frame("_MODAL_ADD_ORGANISER");
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).click();
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).sendKeys("core");
                Thread.sleep(3000);
                List<WebElement> User_data = driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
                System.out.println(User_data.size());
                
                int i = 0;
                for (i = 0; i <= User_data.size(); i++) {
                    if (i == 1 || i == 2 || i == 5) {
                        User_data.get(i).click();
                    }

                }
                
                //click on Done button
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.xpath("//*/input[@id='BTN_DONE']")).click();
            }
        } catch (Exception e) {
            System.out.println("The error is : " + e.getMessage());
        }


        
        //add Voters
        String Voters = driver.findElement(By.id("voter-section-header-title")).getText();
        try {
            if (Voters.equals("Voters")) {

                driver.findElement(By.id("ADD_VOTERS_BTN")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                //search User

                driver.switchTo().frame("_MODAL_ADD_VOTER");
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).click();
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).sendKeys("core");
                Thread.sleep(3000);
                List<WebElement> Voters_data = driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
                System.out.println(Voters_data.size());
                int j = 0;
                for (j = 0; j <= Voters_data.size(); j++) {
                    if (j == 4 || j == 2 || j == 9) {
                        Voters_data.get(j).click();
                    }

                }
                //click on Done button
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.xpath("//*/input[@id='BTN_DONE']")).click();
            }
        } catch (Exception e) {
            System.out.println("The error is : " + e.getMessage());
        }


//add Additional access
        String AccessEdit = driver.findElement(By.id("section-header-title")).getText();
        try {
            if (AccessEdit.equals("Additional Access")) {

                driver.findElement(By.id("ADD_ADDTL_ACCESS_BTN")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                //search User

                
                driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).click();
                driver.findElement(By.xpath("//div[@id='GridSearchTextBoxContainerSEARCH']//input[@id='SEARCH']")).sendKeys("core");
                Thread.sleep(3000);
                List<WebElement> Access_data = driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
                System.out.println(Access_data.size());
                int k = 0;
                for (k = 0; k <= Access_data.size(); k++) {
                    if (k == 6 || k == 3 || k == 8) {
                        Access_data.get(k).click();
                    }

                }
                
                //Clikc on done button
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                driver.findElement(By.xpath("//*[@id=\"BTN_DONE\"]")).click();

                //save the data
                driver.findElement(By.id("SAVE_ADDTL_ACCESS_BUTTON")).click();
            }
        } catch (Exception e) {
            System.out.println("The error is : " + e.getMessage());
        }

        //Document Upload
        String Docs = driver.findElement(By.id("document-section-header-title")).getText();
        try {
            if (Docs.equals("Documents")) {

                driver.findElement(By.xpath("//[@id=\"document-list\"]/div[1]/table/tbody/tr/td[2]/img[2]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


                
                driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");
                WebElement upload = driver.findElement(By.xpath("//*[@id=\"file-input-1\"]"));
                upload.sendKeys("C:\\Users\\ssing\\Desktop\\Test Files\\test.txt");



                driver.findElement(By.id("BTN_UPLOAD")).click();

                //Save Document
                driver.findElement(By.id("SAVE_DOCUMENTS_BUTTON")).click();
            }
        } catch (Exception e) {
            System.out.println("The error is : " + e.getMessage());
        }

}
}