
package Test_File;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base_File.Opening_Closeing;
import POM.Login_POM;
import POM.Meeting_POM;

public class TC1_Login_Page extends Opening_Closeing  {

	
	@Test(priority=0)
	public void Login() throws InterruptedException {
		logger.info("***Starting_TC1_Login_Page***");
		Login_POM LP = new Login_POM(driver);
		logger.info("***Core User login***");
		LP.C_Username(RB.getString("Username"));
		LP.C_Password(RB.getString("Password"));
		LP.Final_Login();
		
		Thread.sleep(4000);
		
	}	
		@Test(priority=1)
	
		public void Meeting() throws InterruptedException {
			
			try {
			Meeting_POM  Meeting = new Meeting_POM(driver);
			Meeting.Acc_Button();
			
			
			boolean targetpage=Meeting.getConfirmMessage();
		
			
			Thread.sleep(4000);
			
			Meeting.New_Meeting();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Meeting.My_Workspace();
			

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Meeting.Select_Workspace();
			
			Meeting.Type();
			
			Meeting.M_Name("20230827_Meeting Portal Test");
			
			Meeting.Calender();
			
			Thread.sleep(3000);
		//Meeting.M_Vanue("Logix Tower Noida");
		//With help of COnfig File Please Refer  Base_File ---> Opening_Closing
			Meeting.M_Vanue(RB.getString("Vanue"));
			
			Meeting.Alert();
			Thread.sleep(3000);
		Meeting.Sc_Meeting();
			Thread.sleep(3000);		
			//logger.info("****Logout from Meeting page***");
			//Meeting.C_Logout();
			}
			catch(Exception e) {
				Assert.fail();
			}
		}
}
