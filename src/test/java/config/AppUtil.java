package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogoutPage;

public class AppUtil 
{
    public static WebDriver driver;
    public static Properties property;
    @BeforeTest
    public void setUp() throws Throwable
    {
    	property=new Properties();
    	property.load(new FileInputStream("./PropertyFiles/Environment.properties"));
    	if(property.getProperty("Browser").equalsIgnoreCase("chrome"))
    	{
    		driver=new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.get(property.getProperty("Url"));
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		AdminLoginPage login=PageFactory.initElements(driver,AdminLoginPage.class);
    		login.adminLogin("admin","master");
    		
    	}else
    	
    		if(property.getProperty("Browser").equalsIgnoreCase("firefox"))
    		{
    			driver=new FirefoxDriver();
    			driver.manage().window().maximize();
    			driver.get(property.getProperty("Url"));
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			AdminLoginPage login=PageFactory.initElements(driver,AdminLoginPage.class);
    			login.adminLogin("admin","master");
    		}
    		else
    		{
    			Reporter.log("Browser Value Is Not Matching",true);
    		
    	    }
    }
      @AfterTest
      public void tearDown() 
      {
    	  AdminLogoutPage logout=PageFactory.initElements(driver,AdminLogoutPage.class);
    	  logout.adminLogout();
    	  driver.quit();
      }
}
