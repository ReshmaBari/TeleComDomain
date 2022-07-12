package kiteTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import kitePOM.KiteHomePage;
import kitePOM.KiteLoginPage;
import kitePOM.KitePinPage;
import kiteUtility.Utility123;
import kiteBase.Base123;

public class TestLoginLogoutUsingPropertyFile extends Base123 {
	KiteLoginPage page1;
	KitePinPage page2;
	KiteHomePage page3;
	int TCID=12;
	
	@BeforeClass
	public void browserSetup() throws IOException
	{
		Reporter.log("Launching Browser", true);
		browserInitialize();
		page1= new KiteLoginPage(driver);
		page2= new KitePinPage(driver);
		page3= new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	public void LoginApplication() throws InterruptedException, IOException 
	{
		Reporter.log("Application Logged in", true);
		page1.sendUserName(Utility123.getDatafromPropertiesFile("UN"));
		page1.sendPassword(Utility123.getDatafromPropertiesFile("PWD"));
		page1.ClickOnLoginBtn();
		
		page2.sendPin(Utility123.getDatafromPropertiesFile("PIN"));
		page2.clickOnContinueBtn();
		
		
		
	}
		
  @Test
  public void ValidateUserID() throws IOException
  {
	
		 Reporter.log("Running "+TCID, true);
	
	 String ActualUserID = page3.getActualUserName(); 
	 String ExpectedUserID = Utility123.getDatafromPropertiesFile("UN1");
	 
	 Assert.assertEquals(ActualUserID, ExpectedUserID,"User ID not matching TC failed");
	 
	 Reporter.log("User ID matching TC Passed ", true);
	 
	  Utility123.captureScreenShot(driver, TCID);
	 
  }
  
  @AfterMethod
  public void LogOutFormApplication(ITestResult result) throws InterruptedException, IOException
  {
	  if(result.getStatus()==ITestResult.FAILURE)
		  
	  {
		
		  Utility123.captureScreenShot(driver,TCID);
	  }
	
	  Thread.sleep(2000);
	
	  Reporter.log("Looging out ", true);
	 
	  page3.getActualUserName();
	  page3.logOut();
  }
  
  @AfterClass
  public void CloseBroswer() throws InterruptedException
  {
	  Thread.sleep(2000);
	  Reporter.log("Closing Browser ", true);
	  driver.close();
	  
  }

}
