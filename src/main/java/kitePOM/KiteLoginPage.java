package kitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KiteLoginPage {
	     //1 data Members
		@FindBy(id="userid")private WebElement userName;
		@FindBy(id="password")private WebElement password;
		@FindBy(xpath ="//button[@type='submit']") private WebElement loginbtn;
		@FindBy(xpath ="//span[contains(text(),'Password should be')]") private WebElement PasswordErrorMsg;
		@FindBy(xpath ="//span[contains(text(),'User ID should')]") private WebElement UserIdErrorMsg;

		
		//2 Constructor
		
		public KiteLoginPage (WebDriver driver) 
		{
		PageFactory.initElements(driver,this);
		}
		
		//3 methods
		
		public void sendUserName(String UserName) throws InterruptedException
		{
			Thread.sleep(1000);
			userName.sendKeys(UserName);
		}
		public void sendPassword(String passWord)
		{
			password.sendKeys(passWord);
		}
		
		public void ClickOnLoginBtn()
		{
			loginbtn.click();
		}
		
		public String getUserIdErrorMsg()
		{
			String ActualUserIdErrorMsg=UserIdErrorMsg.getText();
			return ActualUserIdErrorMsg;
			
		}
		
		public String getPasswordErrorMsg()
		{
			String ActualPasswordErrorMsg = PasswordErrorMsg.getText();
			return ActualPasswordErrorMsg;
		}

}
