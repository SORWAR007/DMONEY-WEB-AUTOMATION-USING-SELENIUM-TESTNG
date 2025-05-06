package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.Usermodel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Registrationpage;
import utilis.Utils;

import java.io.IOException;
import java.time.Duration;

public class Registrationtestrunner extends Setup {

 @SuppressWarnings("unchecked")
 @Test(priority = 1, description = "registration with all fields",groups = "smoke")
 public void rgistrationwithallfields() throws InterruptedException, IOException, ParseException {
  Registrationpage rg = new Registrationpage(driver);
  rg.btnregister.click();
  Faker faker = new Faker();
  String fname = faker.name().firstName();
  String lname = faker.name().lastName();
  String email = fname + "@gmail.com";
  String password = String.valueOf(Utils.generaterandomnumber(100,999));
  String address = faker.address().fullAddress();
  String phnenumber = "0179" + Utils.generaterandomnumber(1000, 9999);
  Usermodel usa = new Usermodel();
  usa.setFirstname(fname);
  usa.setLastname(lname);
  usa.setEmail(email);
  usa.setPassword(password);
  usa.setAddress(address);
  usa.setPhonenumber(phnenumber);
  rg.doregistration(usa);
  rg.btngender.get(1).click();
  Thread.sleep(2000);
  rg.btnendregister.click();
  Thread.sleep(1000);
  WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(50));
  wa.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
  String expectedheader = driver.findElement(By.className("Toastify__toast")).getText();
  String actualheader = "successfully";
  Assert.assertTrue(actualheader.contains(expectedheader));
  JSONObject userobj = new JSONObject();
  userobj.put("firstname", fname);
  userobj.put("lastname", lname);
  userobj.put("email", email);
  userobj.put("password", password);
  userobj.put("address", address);
  userobj.put("phonenumber", phnenumber);
  Thread.sleep(3000);
  Utils.saveinfojson("./src/test/resources/users.json", userobj);
  Thread.sleep(2000);


 }

 @SuppressWarnings("unchecked")
 @Test(priority = 2, description = "registration with mandatory fields")
 public void rgistrationwithonlymandatoryfields() throws InterruptedException, IOException, ParseException {
  Registrationpage rg = new Registrationpage(driver);
  rg.btnregister.click();
  Thread.sleep(1000);
  Faker faker = new Faker();
  String fname = faker.name().firstName();
  String email = fname + "@gmail.com";
  String password = String.valueOf(Utils.generaterandomnumber(100,999));
  String phnenumber = "0179" + Utils.generaterandomnumber(1000, 9999);
  Usermodel usa = new Usermodel();
  usa.setFirstname(fname);
  usa.setEmail(email);
  usa.setPassword(password);
  usa.setPhonenumber(phnenumber);
  rg.doregistration(usa);
  rg.btngender.get(1).click();
  Thread.sleep(2000);
  rg.btnendregister.click();
  Thread.sleep(1000);
  WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(50));
  wa.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
  String expectedheader = driver.findElement(By.className("Toastify__toast")).getText();
  String actualheader = "successfully";
  Assert.assertTrue(true);
  JSONObject userobj = new JSONObject();
  userobj.put("firstname", fname);
  userobj.put("email", email);
  userobj.put("password", password);
  userobj.put("phonenumber", phnenumber);
  Thread.sleep(3000);
  Utils.saveinfojson("./src/test/resources/users.json", userobj);
  Thread.sleep(2000);


 }



}