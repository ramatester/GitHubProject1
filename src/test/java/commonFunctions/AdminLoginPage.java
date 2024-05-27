package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage 
{
    @FindBy(id="btnreset")
    WebElement objresetBtn;
    @FindBy(name="username")
    WebElement objuser;
    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement objpass;
    @FindBy(name="btnsubmit")
    WebElement objloginBtn;
    public void adminLogin(String user,String pass)
    {
    	objresetBtn.click();
    	objuser.sendKeys(user);
    	objpass.sendKeys(pass);
    	objloginBtn.click();
    }
    
}
