package kiteUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility123 {
	
	public static void captureScreenShot(WebDriver driver,int TCID) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\Selenium\\Screenshot\\"+TCID+".png");
		FileHandler.copy(src,dest);
	}
	
	public static String getDatafromPropertiesFile(String key) throws IOException
	{
		Properties abc=new Properties();
		FileInputStream Myfile=new FileInputStream("C:\\Users\\GANESH\\eclipse-workspace\\SeleniumProject\\PropertiesFile.properties");
		
		abc.load(Myfile);
		String value = abc.getProperty(key);
		return value;
		
	}

}
