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

public class Convene_Full_Page {

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

		WebElement TC = MyWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCEPT_BTN")));

		
		TC.click();

		driver.findElement(By.xpath("//input[@id='BTN_NEW']")).click();

		driver.findElement(By.xpath("//input[@aria-label=\"Workspace\"]")).click();

		// driver.findElement(By.xpath("//input[@type='checkbox'][@id='REL_COMPANY_ID-109']")).click();
		Thread.sleep(5000);
		List<WebElement> element = driver.findElements(By
				.xpath("//div[@class='opt-chk checkbox']//input[@type='checkbox' and contains(@id,'REL_COMPANY_ID')]"));

		System.out.println(element.size());
		Thread.sleep(4000);

		for (WebElement Ele1 : element) {

			System.out.println((Ele1.getAttribute("id")));
			String S1 = Ele1.getAttribute("id");
			if (S1.equals("REL_COMPANY_ID-159") || S1.equals("REL_COMPANY_ID-158")) {
				Ele1.click();
			}
			
		}

		Thread.sleep(3000);

		WebElement Ele1 = driver.findElement(By.id("MEETING_TYPE"));
		Select Drop = new Select(Ele1);
		Drop.selectByVisibleText("Board");

		
		driver.findElement(By.xpath("//textarea[@name='TITLE-en_GB']")).sendKeys("Test-v58 MEeting Scadules");
		Thread.sleep(3000);

		String Month = "August 2024";
		String Day = "30";

		driver.findElement(By.xpath("//div[@class='date-picker']")).click();

		while (true) {
			String S1 = driver.findElement(By.xpath("//td[@class='title']")).getText();

			if (S1.equals(Month)) {
				break;
			}
			driver.findElement(By.xpath("//*[text()='›']")).click();

		}
		Thread.sleep(5000);
		List<WebElement> AllDates = driver.findElements(By.xpath("//tbody//tr[@class='daysrow']//td"));
		for (WebElement mydt:AllDates) {
			if (mydt.getText().equals(Day)) 
			{
				Thread.sleep(5000);
				mydt.click();
			}
		}
		
		driver.findElement(By.id("VENUE")).sendKeys("Noida NPX Tower");
		
		WebElement Reminder = driver.findElement(By.id("ALERT_TIME"));
		Select Reminder1 = new Select(Reminder);
		Reminder1.selectByIndex(2);
		
		driver.findElement(By.xpath("//textarea[@name='PURPOSE']")).sendKeys("Meeting after ling Time");
		driver.findElement(By.xpath("//textarea[@name='COMMENTARY']")).sendKeys("Please be on mute once you have turn that time Unmute THank YOu.");
		driver.findElement(By.xpath("//textarea[@name='ORGANISER_NOTES']")).sendKeys("Thank you for joining us..........! .");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='BTN_SAVE_MEETING']")).click();
		
		
		  driver.findElement(By.xpath("//div[@id='qtip-2']//button[@class='btni-highlight']")).click();

		
//		  WebElement MS = driver.findElement(By.xpath("//div[@id='qtip-2']//div[@id='custom-confirm-msg']"));
	//	  String S1="Do you really want to schedule the meeting after 6:00 AM?";
		  
		  
		//  if(MS.equals(S1)) {
				
		  //}
		 		
	}

}
