package kitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KitePinPage {
	//Data members
		@FindBy(id="pin")private WebElement PIN;
		@FindBy(xpath ="//button[contains(text(),'Continue')]")private WebElement continueBtn;
		
		//2.constructor
		
		public KitePinPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//3 methods
		public void sendPin(String pin)
		{
			PIN.sendKeys(pin);
		}
		public void clickOnContinueBtn()
		{
			continueBtn.click();
		}

		

		
			
		}

