package All_code;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Meeting {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(Options);
		WebDriverWait MyWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://test-v58.azeusconvene.com/jsp/mt/mt0102.jsp?MEETING_ID=3e635f34-ae79-4321-8bc7-1cb6e6dc9d94");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("LOGIN_ID")).sendKeys("core1");
		driver.findElement(By.id("PWD")).sendKeys("test1234");
		driver.findElement(By.xpath("//input[@id='BTN_SIGN_IN']")).click();

		WebElement TC = MyWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCEPT_BTN")));
		TC.click();
		

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Add Organizers in Meeting
		/*
		 * driver.findElement(By.xpath("//div[@id='neworganiserRow']//a")).click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * 
		 * driver.switchTo().frame("_MODAL_ADD_organiser");
		 * driver.findElement(By.id("SEARCH")).sendKeys("core"); Thread.sleep(3000);
		 * List<WebElement> element =
		 * driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
		 * System.out.println(element.size()); int i = 0; for (i = 0; i<=element.size();
		 * i++) { if (i == 1 || i == 2 || i == 5) { element.get(i).click(); } }
		 * 
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//input[@name='BTN_DONE']")).click();
		 * Thread.sleep(3000); driver.findElement(By.
		 * xpath("//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']"
		 * )).click();
		 */

		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath(
				"//div[@class='mt-item new-contributor-row line-height-30 mt-add-contributor-row row-first']//a"))
				.click();

		driver.switchTo().frame("_MODAL_ADD_contributor");

		driver.findElement(By.xpath("//input[@id='SEARCH']")).sendKeys("Convene");
		Thread.sleep(3000);
		List<WebElement> Agenda_Contributors = driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
		System.out.println(Agenda_Contributors.size());
		for (int i = 0; i <= Agenda_Contributors.size(); i++) {
			if (i == 1 || i == 2 || i == 5) {
				Agenda_Contributors.get(i).click();
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='BTN_DONE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")).click();

	*/
		/*
		
		driver.findElement(By.xpath("//a[@class='helper-ui line-height-25 mt-add-attendee']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("_MODAL_ADD_ATTENDEE");
		
		driver.findElement(By.xpath("//input[@id='SEARCH']")).sendKeys("Core");
		Thread.sleep(3000);
		List<WebElement> Add_Orgaizer = driver.findElements(By.xpath("//tbody//tr//td//input[@value='Add']"));
		System.out.println(Add_Orgaizer.size());
		
		for (int i = 0; i <= Add_Orgaizer.size(); i++) {
			if (i == 8 || i == 7 || i == 6) {
				Add_Orgaizer.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='BTN_DONE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")).click();
	*/
		
/*		driver.findElement(By.xpath("//a[@class='helper-ui text-decoration-none line-height-25 mt-add-additional-access']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("_MODAL_ADD_ADDITIONAL_ACCESS");
		
		driver.findElement(By.xpath("//input[@id='SEARCH']")).sendKeys("ben");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//tbody//tr//td//input[@value='Add']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='BTN_DONE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='section-header margin-bottom-0']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")).click();
*/
		
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='attach-file attach-file-dummy']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");
		
		WebElement File_Select = driver.findElement(By.xpath("//input[@id='file-input-1']"));
		Thread.sleep(4000);
		String[] File_Path= {
				"C:\\Users\\ssing\\Desktop\\Test Files\\test.txt",
				"C:\\Users\\ssing\\Desktop\\Test Files\\test.pptx",
				"C:\\Users\\ssing\\Desktop\\Test Files\\test.docx"
		};
		 for (String filePath : File_Path) {
			 File_Select.sendKeys(filePath);
	        }
		 WebElement  Upload_File=  driver.findElement(By.xpath("//input[@name='BTN_UPLOAD']"));
		 Thread.sleep(4000);
		 Upload_File.click();
		 
		 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='agenda-item mt-box add-agenda-row new-agenda-row zoom-1']//div[@class='add-file-to-agenda-container']")).click();
		 driver.switchTo().frame("_MODAL_FILE_SYS_SELECTION_UG");
			
			WebElement File_Select2 = driver.findElement(By.xpath("//input[@id='file-input-1']"));
			File_Select2.sendKeys("C:\\Users\\ssing\\Desktop\\Test Files\\test.txt");

			 WebElement  Upload_File2=  driver.findElement(By.xpath("//input[@name='BTN_UPLOAD']"));
			 Thread.sleep(4000);
			 Upload_File2.click();
			
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//div[@class='agenda-section-subheader']//button[@class='btni-highlight mtsection-btn-save mtsection-btn-spacer']")).click();

	}
		
		
	}

