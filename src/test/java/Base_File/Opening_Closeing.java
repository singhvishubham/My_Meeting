package Base_File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opening_Closeing {
	public Logger logger;
	public ResourceBundle RB; //Java Utill Pakage
	public  static WebDriver driver;
	@Parameters("browser")
	@BeforeClass()
	public void Intial_Setup(String br) {
		RB=ResourceBundle.getBundle("config"); //Load Config.properties File
		logger=LogManager.getLogger(this.getClass());
		
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(Options);
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions Options1 = new EdgeOptions();
			Options1.addArguments("--remote-allow-origins=*");
			 driver = new EdgeDriver(Options1);
		} else {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions Options2 = new FirefoxOptions();
			Options2.addArguments("--remote-allow-origins=*");
			 driver = new FirefoxDriver(Options2);

		}

		
		
		
		driver.get(RB.getString("URL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass()
	public void Closing_Convene() {
		driver.close();

	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshot\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}