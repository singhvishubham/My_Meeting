package Base_File;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opening_Closeing {
	public Logger logger;
	public ResourceBundle RB; //Java Utill Pakage
	public WebDriver driver;
	@BeforeClass()
	public void Intial_Setup() {
		RB=ResourceBundle.getBundle("config"); //Load Config.properties File
		logger=LogManager.getLogger(this.getClass());
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Options);
		driver.get("https://test-v58.azeusconvene.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass()
	public void Closing_Convene() {
		driver.close();

	}
}
