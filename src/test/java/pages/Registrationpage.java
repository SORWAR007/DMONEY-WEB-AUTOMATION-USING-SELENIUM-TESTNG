package pages;

import config.Usermodel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Registrationpage {

    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement btnregister;

    @FindBy(id= "firstName")
    WebElement txtfirstname;

    @FindBy(id= "lastName")
    WebElement txtlastName;

    @FindBy(id= "email")
    WebElement txtemail;

    @FindBy(id= "password")
    WebElement txtpassword;

    @FindBy(id= "phoneNumber")
    WebElement txtphonenumber;

    @FindBy(id= "address")
    WebElement txtaddress;

    @FindBy(name = "gender")
    public List<WebElement> btngender;

    @FindBy(xpath =" //input[@type='checkbox']")
    WebElement btnauthcheckbox;

    @FindBy(id= "register")
    public WebElement btnendregister;

    public Registrationpage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);

    }

    public void doregistration(Usermodel us)

    {

        txtfirstname.sendKeys(us.getFirstname());
        txtlastName.sendKeys(us.getLastname()!=null?us.getLastname():" ");
        txtemail.sendKeys(us.getEmail()!=null? us.getEmail() :" ");
        txtpassword.sendKeys(us.getPassword()!=null? us.getPassword() :" ");
        txtphonenumber.sendKeys(us.getPhonenumber()!=null?us.getPhonenumber():" ");
        txtaddress.sendKeys(us.getAddress()!=null? us.getAddress() :" ");
        btnauthcheckbox.click();



    }



}
