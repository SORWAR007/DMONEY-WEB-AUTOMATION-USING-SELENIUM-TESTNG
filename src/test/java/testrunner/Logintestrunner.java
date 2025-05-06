package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Addcostpage;
import pages.Loginpage;
import pages.Userdetailspage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Logintestrunner extends Setup {


    @Test
    public void adminloginwrongpassword() throws InterruptedException {
        Loginpage lg=new Loginpage(driver);

        lg.dologin("admin@test.com","admi123");

        String expectedheader=driver.findElement(By.tagName("p")).getText();
        String actualheader="Invalid email or password";
        Assert.assertEquals(expectedheader, actualheader);
        Thread.sleep(2000);
        clearcreds();

    }

    @Test(priority = 1,description = "admin login")
    public void adminlogin() throws InterruptedException {
        Loginpage lg=new Loginpage(driver);

        lg.dologin("admin@test.com","admin123");

        String expectedheader=driver.findElement(By.xpath("//h2[normalize-space()='Admin Dashboard']")).getText();
        String actualheader="Admin Dashboard";
        Assert.assertEquals(expectedheader, actualheader);
        lg.dologout();
        Thread.sleep(2000);
        clearcreds();

    }

//@Test
    public void adminloginfromterminal()
    {
        Loginpage lg=new Loginpage(driver);

        lg.dologin(System.getProperty("email"),System.getProperty("password"));
        String expectedheader=driver.findElement(By.xpath("//h2[normalize-space()='Admin Dashboard']")).getText();
        String actualheader="Admin Dashboard";
        Assert.assertEquals(expectedheader, actualheader);
        lg.dologout();
        clearcreds();

    }

    // @Test
    public void adminloginfromterminalandcheckingfromJson() throws IOException, ParseException {
        Loginpage lg = new Loginpage(driver);
        lg.dologin("admin@test.com", "admin123");
       // lg.dologin(System.getProperty("email"),System.getProperty("password"));
        String expectedheader = driver.findElement(By.xpath("//h2[normalize-space()='Admin Dashboard']")).getText();
        String actualheader = "Admin Dashboard";
        Assert.assertEquals(expectedheader, actualheader);
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[1]"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(0).getText(); // assuming order: first name, email, phone
            String emailFromUI = cells.get(2).getText();
            String phone = cells.get(3).getText();

            System.out.println("Extracted from UI:");
            System.out.println("First Name: " + firstName);
            System.out.println("Email: " + emailFromUI);
            System.out.println("Phone: " + phone);


            JSONParser js = new JSONParser();
            JSONArray ar = (JSONArray) js.parse(new FileReader("./src/test/resources/users.json"));
            JSONObject as = (JSONObject) ar.get(ar.size() - 1);
            String firstname = (String) as.get("firstname");
            String email = (String) as.get("email");
            String phonenumber = (String) as.get("phonenumber");
            Assert.assertEquals(firstName, firstname);
            Assert.assertEquals(emailFromUI, email);
            Assert.assertEquals(phone, phonenumber);
            lg.dologout();
            clearcreds();

        }

    }

    @Test(priority = 4,description = "login from last user of json file and upload image")
    public void loginandupdateprofileimage() throws IOException, ParseException, InterruptedException {
        Loginpage lg = new Loginpage(driver);
//        JSONParser js = new JSONParser();
//        JSONArray ar = (JSONArray) js.parse(new FileReader("./src/test/resources/users.json"));
//        JSONObject as = (JSONObject) ar.get(ar.size() - 1);
//        String email = (String) as.get("email");
//        String password = (String) as.get("password");
        lg.dologin("Thomasena@gmail.com","-861999");
        lg.btnprofilemenuitem.click();
        Userdetailspage us = new Userdetailspage(driver);
        us.btnprofile.click();
        us.btnedit.click();
        WebElement addFile = driver.findElement(By.className("upload-input"));
        addFile.sendKeys("C:/Users/JISAN/Documents/pic.jpg");
        Thread.sleep(2000);
        us.btnuploadimage.click();
        us.btnupdate.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();



    }

    public void clearcreds()
    {

        Loginpage lg= new Loginpage(driver);
        lg.txtemail.sendKeys(Keys.CONTROL,"a");
        lg.txtemail.sendKeys(Keys.BACK_SPACE);
        lg.txtpassword.sendKeys(Keys.CONTROL,"a");
        lg.txtpassword.sendKeys(Keys.BACK_SPACE);


    }




}
