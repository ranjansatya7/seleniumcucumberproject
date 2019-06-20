package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class drivers {
	public static WebDriver getDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		else if (browser.equals("ie")) {
			
			System.getProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
			WebDriver driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
			
		}
		else
		{
			return null;
		}
		
		
	}

}
