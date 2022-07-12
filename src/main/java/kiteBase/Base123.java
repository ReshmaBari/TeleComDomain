package kiteBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import kiteUtility.Utility123;

public class Base123 {
	static public WebDriver driver;
	public void browserInitialize() throws IOException 
	{
		//ChromeOptions opt=new ChromeOptions();
		
		//opt.addArguments("--disable-notification--");
		 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32 (7)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Utility123.getDatafromPropertiesFile("URL"));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
			


}
}
