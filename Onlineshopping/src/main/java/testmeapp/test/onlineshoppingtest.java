package testmeapp.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeapp.utility.drivers;

@Test
public class onlineshoppingtest {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest logger;
	
	
	 
	 
	@AfterTest
    public void endReportAfterTest() {
		reports.flush();
		
	}
    
    @AfterMethod
    public void getResultAfterMethod(ITestResult result) {

		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,  result.getMethod().getMethodName()+"test is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, result.getMethod().getMethodName()+"test is failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, result.getMethod().getMethodName()+"test is skipped");
		}
    
    }
    	
    @BeforeTest
    public void startReportBeforeTest() {
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		
		String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		reporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("hostname","localhost");
		reports.setSystemInfo("Environment","Testing Env");
		reports.setSystemInfo("Username","aswani.kumar.avilala");
		
		reporter.config().setDocumentTitle("The title of the document is here");
		reporter.config().setReportName("Next Gen Testing Report");
		reporter.config().setTheme(Theme.DARK);
		

		
	}
    
    @Test(priority =3)
    public void testCart() throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	Actions action=new Actions(driver);
    	action.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
    	action.click(driver.findElement(By.partialLinkText("Electronics"))).perform();
    	action.click(driver.findElement(By.partialLinkText("Travel Kit"))).perform();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	action.click(driver.findElement(By.partialLinkText("Add to cart"))).perform();
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    }
    	
    @Test(priority =2)
    public void testLogin() {
    	   driver=drivers.getDriver("chrome");
    	   driver.get("http://10.232.237.143:443/TestMeApp/");
    	  driver.findElement(By.partialLinkText("SignIn")).click();
    	
    	String title=driver.getTitle();
    	Assert.assertTrue(title.contains("Login"));
    	driver.findElement(By.id("userName")).sendKeys("satyara");
    	driver.findElement(By.id("password")).sendKeys("satya123");
    	driver.findElement(By.cssSelector("input[value='Login']")).click();
    	logger=reports.createTest("Pass Test");
		Assert.assertTrue(true);
   	}
    @Test(priority =4)
    public void testPayment() {
    	Actions act=new Actions(driver);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.click(driver.findElement(By.partialLinkText("Cart"))).perform();
		act.click(driver.findElement(By.partialLinkText("Checkout"))).perform();
		act.click(driver.findElement(By.cssSelector("input[value='Proceed to Pay']"))).perform();
		
		act.click(driver.findElement(By.xpath("//*[@id=\"swit\"]/div[7]/div/label"))).perform();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.cssSelector("input[value='Continue']")).click();
		act.click(driver.findElement(By.partialLinkText("Continue"))).perform();
		driver.findElement(By.id("userName")).sendKeys("123456");
		driver.findElement(By.id("userName")).sendKeys("Pass@456");
		logger=reports.createTest("Skip Test");
		throw new SkipException("Explicitly throw new Skip Exception");

    	
    	
		
   	}
  /*  @Test(priority = 1)
    public void testRegistration() {
    	
    	
    driver=drivers.getDriver("chrome");
 driver.get("http://10.232.237.143:443/TestMeApp/");
driver.findElement(By.partialLinkText("SignIn")).click();
	
	driver.findElement(By.id("userName")).sendKeys("taran1121");
	driver.findElement(By.id("firstName")).sendKeys("satyaranjan");
	driver.findElement(By.id("lastName")).sendKeys("rout");
	
	driver.findElement(By.id("password")).sendKeys("satya123");
	driver.findElement(By.id("pass_confirmation")).sendKeys("satya123");
	driver.findElement(By.cssSelector("input[value='Male']")).click();
	driver.findElement(By.id("emailAddress")).sendKeys("satya@email.com");
	driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");
	driver.findElement(By.id("dob")).sendKeys("01/23/1990");
	driver.findElement(By.id("address")).sendKeys("Bangalore marathahalli");
	Select questions=new Select(driver.findElement(By.id("securityQuestion")));
	questions.selectByVisibleText("What is your favour color?");
	driver.findElement(By.id("answer")).sendKeys("Red");
	driver.findElement(By.cssSelector("input[value='Register']")).click();

    
    	
    	
		
	
   	}*/
    
    
    
}
