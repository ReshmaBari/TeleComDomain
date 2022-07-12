package kitePOM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ValidateKiteAppName {
	WebDriver driver;
	Sheet mySheet;
	KiteLoginPage login;
	KiteHomePage home;
	KitePinPage pin;

	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (7)\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		// opt.addArguments("Incognito");

		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://kite.zerodha.com/");
		Reporter.log("Browser is launch", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

		File myfile = new File("D:\\Selenium\\MyData.xlsx");
		mySheet = WorkbookFactory.create(myfile).getSheet("Sheet3");

		login = new KiteLoginPage(driver);
		pin = new KitePinPage(driver);
		home = new KiteHomePage(driver);

	}

	@BeforeMethod
	public void loginToKiteApp() throws InterruptedException {
		String UN = mySheet.getRow(2).getCell(0).getStringCellValue();
		String PWD = mySheet.getRow(2).getCell(1).getStringCellValue();
		String PIN = mySheet.getRow(2).getCell(2).getStringCellValue();

		login.sendUserName(UN);
		Reporter.log("sending userName", true);

		login.sendPassword(PWD);
		Reporter.log("sending password", true);

		login.ClickOnLoginBtn();
		Reporter.log("clicking on login btn", true);

		pin.sendPin(PIN);
		Reporter.log("sending pin", true);

		pin.clickOnContinueBtn();
		Reporter.log("clicking On Continue Btn", true);

	}

	@Test
	public void validateUserName() {
		String expectedUN = mySheet.getRow(2).getCell(0).getStringCellValue();
		String actualUN = home.getActualUserName();

		Reporter.log("validating User Name", true);
		Assert.assertEquals(actualUN, expectedUN, "Actual and Expected UN are not matching TC Failed");
		Reporter.log("Actual and Expected UN are matching TC is passed", true);

	}

	@AfterMethod
	public void logoutFromKiteApp() throws InterruptedException {
		home.logOut();
		Reporter.log("logging out", true);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		Reporter.log("closing browser ", true);
		driver.close();
	}
}