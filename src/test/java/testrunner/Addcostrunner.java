package testrunner;

import config.Csvdataset;
import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Addcostpage;
import pages.Loginpage;

import java.time.Duration;


public class Addcostrunner extends Setup {


   // @Test(dataProvider = "itemdataset", dataProviderClass = Csvdataset.class, description = "reading items description from csv file")
    public void cost(String itemname, String amount, String purchasedate, String month, String remark) throws InterruptedException {


        Loginpage lg = new Loginpage(driver);
        lg.dologin("Thomasena@gmail.com", "-861999");
        Addcostpage ad = new Addcostpage(driver);
        ad.btnaddcost.click();
        ad.addingcost(itemname, amount, purchasedate, month, remark);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        ad.btnsubmit.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        lg.dologout();

    }

    @Test(priority = 2, description = "Print and validate the total cost dynamically",groups ="smoke")
    public void printCost() throws InterruptedException {
        Loginpage lg = new Loginpage(driver);
        lg.dologin("Thomasena@gmail.com", "-861999");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Total Cost: 6600 TK']")));
        String elText = el.getText();
        String extractedCost = elText.replaceAll("[^0-9]", "");
        System.out.println("Extracted total cost: " + extractedCost);
        String expectedCost = getExpectedTotalCost();
        Assert.assertEquals(extractedCost, expectedCost, "Total cost does not match expected value.");
        lg.dologout();
    }

    public String getExpectedTotalCost() {

        int calculatedTotal = 6600;
        return String.valueOf(calculatedTotal);
    }


    @Test(priority = 3, description = "search item by name",groups = "smoke")
    public void serachitems() {

        Loginpage lg = new Loginpage(driver);
        lg.dologin("Thomasena@gmail.com", "-861999");
        Addcostpage as = new Addcostpage(driver);
        as.btnsearch.sendKeys("laptop");
        WebElement as1 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        String as2 = as1.getText();
        String actualamount = "1200";
        Assert.assertEquals(as2, actualamount);
        lg.dologout();
    }

}


