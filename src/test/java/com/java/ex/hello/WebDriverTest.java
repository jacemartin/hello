package com.java.ex.hello;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverTest {

    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        baseUrl = "https://visa-admin.test.modirum.com/";
        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "5");
        capabilities.setCapability("platform", Platform.XP);
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://jaceqmartin:87334f8c-4d83-4909-9b5b-60843d1675e5@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @Test
    public void webDriver() throws Exception {
    	driver.get(baseUrl + "/mdpayacs-admin/login/login.htm");
        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys("testjace");
        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys("Password1");
        driver.findElement(By.id("button")).click();
        assertEquals("Visa Consumer Authentication Service", driver.findElement(By.cssSelector("td.issuername")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}