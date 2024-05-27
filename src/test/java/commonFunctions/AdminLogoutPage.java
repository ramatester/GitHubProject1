package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage 
{
    @FindBy(xpath="(//a[text()=' Logout'])[2]")
    WebElement objlogout;
    public void adminLogout()
    {
    	objlogout.click();
    }
}
