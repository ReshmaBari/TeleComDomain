package kitePOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KiteHomePage {
	//1 Data Members
	
			@FindBy(xpath ="//span[@class='user-id']")private WebElement userName;
			@FindBy(xpath ="//a[@target='_self']")private WebElement logOutBtn;
			
			
			// Constructor
			
			public KiteHomePage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			
			//methods
			
			public void ValidateUserName(String expectedUserID)
			{
				String expectedUserName=expectedUserID;
				String actualUserName=userName.getText();
				
				
				if(expectedUserName.equals(actualUserName))
				{
					System.out.println("actual And Expecated user Id is matching TC is passed");
				}
				else
				{
					System.out.println("actual And Expecated user Id is not matching TC is Failed");
				}
			}
			
			//to get actual UserName
			public String getActualUserName()
			{
				String actualUserName=userName.getText();
				return actualUserName;
			}
			
			public void logOut() throws InterruptedException
			{
				userName.click();
				Thread.sleep(1000);
				logOutBtn.click();
				System.out.println("add same command");
			}


			
			


			
}
