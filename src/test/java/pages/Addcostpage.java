package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcostpage {

    @FindBy(className = "add-cost-button")
 public WebElement btnaddcost;
    @FindBy(id = "itemName")
    WebElement txtitemname;
    @FindBy(id = "amount")
    WebElement txtamount;
    @FindBy(id = "purchaseDate")
    WebElement txtdate;
    @FindBy(id="month")
    WebElement txtmonth;
   @FindBy(id="remarks")
   WebElement txtremarks;
   @FindBy(className ="submit-button")
   public WebElement btnsubmit;
   @FindBy(className = "search-input")
   public WebElement btnsearch;

   public  Addcostpage(WebDriver driver)
   {

       PageFactory.initElements(driver, this);

   }


   public void addingcost(String itemname, String amount, String purchasedate, String month, String remarks)
   {
       txtitemname.sendKeys(itemname);
       txtamount.sendKeys(amount);
       txtdate.sendKeys(purchasedate);
       txtmonth.sendKeys(month);
       txtremarks.sendKeys(remarks);



   }


}
