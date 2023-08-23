package Test_File;

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
			//logger.info("****Logout from Meeting page***");
			//Meeting.C_Logout();
			}
			catch(Exception e) {
				Assert.fail();
			}
		}
}
