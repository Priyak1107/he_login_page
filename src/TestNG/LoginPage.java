package TestNG;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeTest
	public void launchapp()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zelo-Tech-LP11\\Desktop\\random\\automation\\jar file\\chrome driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.navigate().to("https://www.hackerearth.com/");
	   driver.manage().window().maximize();
	}
	
	
	@Test
  public void login() throws Exception{
		report = new ExtentReports("C:\\Users\\Zelo-Tech-LP11\\Desktop\\automation report\\automation.html", Boolean.valueOf(false));
	      logger = report.startTest("Login Automation");
	      logger.log(LogStatus.INFO, "Login Automation check started");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("html/body/div[7]/section[1]/header/nav/ul/li[2]/a")).click();
		logger.log(LogStatus.PASS, "Login button selected successfuly");
		driver.findElement(By.xpath(".//*[@id='id_login']")).clear();
		driver.findElement(By.xpath(".//*[@id='id_login']")).sendKeys("priyakumari1107@gmail.com");
		logger.log(LogStatus.PASS, "User name entered successfully");
		driver.findElement(By.cssSelector("#modal-login-form > div.wrapper.small-wrapper > #id_password")).click();
		driver.findElement(By.cssSelector("#modal-login-form > div.wrapper.small-wrapper > #id_password")).clear();
		driver.findElement(By.cssSelector("#modal-login-form > div.wrapper.small-wrapper > #id_password")).sendKeys("123456");
		logger.log(LogStatus.PASS, "password entered successfully");
		driver.findElement(By.xpath(".//*[@id='modal-login-form']/div[4]/input")).click();
		
		try
		{
			driver.findElement(By.xpath(".//*[@id='challenges']/a"));
			logger.log(LogStatus.PASS, "Login successful");
			logger.log(LogStatus.INFO, "Login Automation Check Completed");
			Assert.assertTrue(true);
			
		}
		catch(Exception e){ 
			logger.log(LogStatus.FAIL, "Login failed");
			logger.log(LogStatus.INFO, "Login Automation check completed");
			Assert.assertTrue(false);
		}
			
		
		}
	
	@AfterTest
	public void quit() throws Exception
	{
		report.endTest(logger);
	    report.flush();
		Thread.sleep(5000);
		driver.close();
	}
  }

