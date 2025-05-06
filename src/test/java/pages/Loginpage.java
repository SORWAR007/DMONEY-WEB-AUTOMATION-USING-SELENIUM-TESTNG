package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    @FindBy(id="email")
    public WebElement txtemail;


    @FindBy(id="password")
    public WebElement txtpassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")

    WebElement btnlogin;

    @FindBy(tagName = "svg")
    public WebElement btnprofilemenuitem;

    @FindBy(xpath = "//li[normalize-space()='Logout']")
   public WebElement btnprofilelogout;

    public Loginpage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void dologin(String email,String password)


    {
        txtemail.sendKeys(email);
        txtpassword.sendKeys(password);
        btnlogin.click();

    }

    public void dologout()
    {

        btnprofilemenuitem.click();
        btnprofilelogout.click();

    }


}
