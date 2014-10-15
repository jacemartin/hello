package com.java.ex.hello;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  String adminUsername = "admin";
  String adminPass = "Password2";
  String pan = "4519950022000000007";
  String cardHolder = "jace";
  String issuerName = "Banco Brazil";
  String vcasBME = "/coffeehouse/MerchantHandler2";

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://visa.ci.modirum.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testABegin() throws Exception {
    driver.get(baseUrl + "/mdpayacs-admin/login/login.htm");
    driver.findElement(By.id("j_username")).clear();
    driver.findElement(By.id("j_username")).sendKeys(adminUsername);
    driver.findElement(By.id("j_password")).clear();
    driver.findElement(By.id("j_password")).sendKeys(adminPass);
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Authentication Admin")).click();
    driver.findElement(By.linkText(issuerName)).click();
    driver.findElement(By.linkText("testbrasilia")).click();
    driver.findElement(By.linkText("jacerule")).click();
    new Select(driver.findElement(By.id("auth.id"))).selectByVisibleText("SMS Only");
    driver.findElement(By.xpath("//input[@value='Save']")).click();
    driver.findElement(By.linkText("Issuer: Banco Brazil")).click();
    driver.findElement(By.linkText("Test Card Range")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    new Select(driver.findElement(By.id("authenticationMethod.id"))).selectByVisibleText("SMS Only");
    driver.findElement(By.xpath("//input[@value='Update']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}