
package Test_File;

import POM.Meeting_POM;
import org.testng.annotations.Test;
import Base_File.Opening_Closeing;
import POM.Login_POM;

public class TC1_Login_Page extends Opening_Closeing  {

	
	@Test(priority=0)
	public void Login() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("***Starting_TC1_Login_Page***");
		Login_POM LP = new Login_POM(driver);
		logger.info("***Core User login***");
		LP.C_Username(RB.getString("Username"));
		LP.C_Password(RB.getString("Password"));
		LP.Final_Login();
		
		Thread.sleep(4000);
		LP.Acc_Button();
	}	
		}
