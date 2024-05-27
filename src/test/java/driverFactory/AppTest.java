package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtils;

public class AppTest extends AppUtil
{
    String inputpath="./FileInput/CostomerPage.xlsx";
    String outputpath="./FileOutput/DataDrivenResults.xlsx";
    ExtentReports report;
    ExtentTest logger;
    String TestData="Customer";
    @Test
    public void startTest()throws Throwable
    {   report=new ExtentReports("./target/ExtentReports/Customer.html");
    	ExcelFileUtils xl=new ExcelFileUtils(inputpath);
       int rc=xl.rowcount(TestData);
       for(int i=1;i<=rc;i++)
       {
    	   logger=report.startTest("Customers Module");
    	   logger.assignAuthor("Rama");
    	   
    	   String Cname=xl.getcelldata(TestData, i, 0);
    	   String Address=xl.getcelldata(TestData, i, 1);
    	   String City=xl.getcelldata(TestData, i, 2);
    	   String Country=xl.getcelldata(TestData, i, 3);
    	   String Cperson=xl.getcelldata(TestData, i, 4);
    	   String Pnumber=xl.getcelldata(TestData, i, 5);
    	   String Email=xl.getcelldata(TestData, i, 6);
    	   String Mnumber=xl.getcelldata(TestData,i, 7);
    	   String Notes=xl.getcelldata(TestData, i, 8);
    	   CustomerPage cus=PageFactory.initElements(driver,CustomerPage.class);
    	   boolean res= cus.addCustomer(Cname, Address, City, Country, Cperson, Pnumber, Email, Mnumber, Notes);
    	   logger.log(LogStatus.INFO, Cname+"   "+Address+"  "+City+" "+Country+"  "+Cperson+"  "+Pnumber+"  "+Email+"  "+Mnumber+" "+Notes);
    	   if(res)
    	   {
    		   xl.setCellData(TestData, i, 9,"Pass", outputpath);
    		   logger.log(LogStatus.PASS,"Cstomer Number is Found in Table");
    	   }else
    	   {
    		  xl.setCellData(TestData, i, 9, "Fail",outputpath);
    		  logger.log(LogStatus.FAIL,"Customer Number is Not Found In Table");
    		  File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		  FileUtils.copyFile(Screen,new File("./target/Screenshot/Customer.png"));
    	   }
    	   
       }
       report.endTest(logger);
       report.flush();
    	
    }
    
}
