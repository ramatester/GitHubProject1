package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage 
{ WebDriver driver;
public CustomerPage (WebDriver driver) 
{
	this.driver=driver;

}
@FindBy(xpath="(//a[contains(.,'Customers')])[2]")
WebElement objcustomerlink;
@FindBy(xpath="(//span[@data-caption='Add'])[1]")
WebElement objAddicon;
@FindBy(name="x_Customer_Number")
WebElement objcustomernumber;
@FindBy(name="x_Customer_Name")
WebElement objcustomername;
@FindBy(name="x_Address")
WebElement objAddress;
@FindBy(name="x_City")
WebElement objcity;
@FindBy(name="x_Country")
WebElement objcountry;
@FindBy(name="x_Contact_Person")
WebElement objcontactperson;
@FindBy(name="x_Phone_Number")
WebElement objphonenumber;
@FindBy(name="x__Email")
WebElement objemail;
@FindBy(name="x_Mobile_Number")
WebElement objmobilenumber;
@FindBy(name="x_Notes")
WebElement objnotes;
@FindBy(id="btnAction")
WebElement objclickAddBtn;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement objclickConfirmok;
@FindBy(xpath="(//button[contains(.,'OK')])[6]")
WebElement objclickAlertok;
@FindBy(xpath="//span[@data-caption='Search']")
WebElement objclicksearchpanel;
@FindBy(xpath="//input[@id='psearch']")
WebElement objsearchtextbox;
@FindBy(xpath = "//button[@id='btnsubmit']")
WebElement objclicksearchBtn;
@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
WebElement webtable;

public boolean addCustomer(String Cname,String Address,String City,String Country,String Cperson,String Pnumber,
		String Email,String Mnumber,String Notes)throws Throwable
{
	Actions ac=new Actions(driver);
	ac.moveToElement(this.objcustomerlink).click().perform();
	ac.pause(4000);
	ac.moveToElement(this.objAddicon).click().perform();
	String Exp_Data=objcustomernumber.getAttribute("value");
	this.objcustomername.sendKeys(Cname);
	this.objAddress.sendKeys(Address);
	this.objcity.sendKeys(City);
	this.objcountry.sendKeys(Country);
	this.objcontactperson.sendKeys(Cperson);
	this.objphonenumber.sendKeys(Pnumber);
	this.objemail.sendKeys(Email);
	this.objmobilenumber.sendKeys(Mnumber);
	this.objnotes.sendKeys(Notes);
	ac.moveToElement(this.objclickAddBtn).click().perform();
	ac.pause(3000);
	ac.moveToElement(this.objclickConfirmok).click().perform();
	Thread.sleep(3000);
	ac.moveToElement(this.objclickAlertok).click().perform();

	if(!objsearchtextbox.isDisplayed())
		objclicksearchpanel.click();
	objsearchtextbox.clear();
     objsearchtextbox.sendKeys(Exp_Data);
	objclicksearchBtn.click();

	String Act_data = webtable.getText();
	if(Act_data.equals(Exp_Data))

	
	
	{  Reporter.log(Exp_Data+"           "+Act_data,true);
	return true;

	}else
	{
		Reporter.log(Exp_Data+"            "+Act_data,true);
		return false;

	}

}
}




