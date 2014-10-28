//package com.java.ex.hello;
//
//import static org.junit.Assert.*;
//
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;
//
///**
// * @author jacemartin
// * Con run with the integration of maven, Jenkins, and Saucelabs
// */
//
//public class SauceLabsTest {
//
//	private WebDriver driver;
//	private String baseUrl;
//
//	@Before
//	public void setUp() throws Exception {
//		// Choose the browser, version, and platform to test
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("version", "5");
//		capabilities.setCapability("platform", Platform.XP);
//
//		baseUrl = "https://visa-admin.test.modirum.com/";
//
//		// Create the connection to Sauce Labs to run the tests
//		this.driver = new RemoteWebDriver(
//				new URL(
//						"http://jaceqmartin:87334f8c-4d83-4909-9b5b-60843d1675e5@ondemand.saucelabs.com:80/wd/hub"),
//				capabilities);
//	}
//
//	@Test
//	public void webDriver() throws Exception {
//		
//		driver.get(baseUrl
//				+ "/mdpayacs-admin/login/login.htm;jsessionid=9D50776B9479318ECB3B20A0F08AED03");
//		driver.findElement(By.id("j_username")).clear();
//		driver.findElement(By.id("j_username")).sendKeys("testjace");
//		driver.findElement(By.id("j_password")).clear();
//		driver.findElement(By.id("j_password")).sendKeys("Password1");
//		driver.findElement(By.id("button")).click();
//		driver.findElement(By.linkText("Authentication Admin")).click();
//		driver.findElement(By.linkText("Royal Bank of Canada")).click();
//		driver.findElement(By.linkText("TestRule")).click();
//		driver.findElement(By.linkText("always no")).click();
//		driver.findElement(By.xpath("//input[@value='Cancel']")).click();
//		driver.findElement(By.linkText("Logout")).click();
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//	}
//
//}