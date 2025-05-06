package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userdetailspage {
    @FindBy(xpath="//button[text()='Edit']")
     public   WebElement btnedit;
    @FindBy(xpath = "//li[normalize-space()='Profile']")
    public  WebElement btnprofile;
    @FindBy(xpath = "//button[normalize-space()='Upload Image']")
    public WebElement btnuploadimage;
    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement btnupdate;


    public Userdetailspage(WebDriver driver)

    {
        PageFactory.initElements(driver,this);

    }
    

}
