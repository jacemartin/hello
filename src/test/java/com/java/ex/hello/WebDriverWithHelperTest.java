package com.java.ex.hello;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;

public class WebDriverWithHelperTest implements SauceOnDemandSessionIdProvider {

    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
        "jaceqmartin", "87334f8c-4d83-4909-9b5b-60843d1675e5");

    /**
     * JUnit Rule that marks the Sauce Job as passed/failed when the test succeeds or fails.
     * You can see the pass/fail status on your [Sauce Labs test page](https://saucelabs.com/tests).
     */
    public @Rule
    SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

    /**
     * JUnit Rule that will record the test name of the current test. This is referenced when creating the 
     * {@link DesiredCapabilities}, so the Sauce Job is created with the test name.
     */
    public @Rule TestName testName = new TestName();

    private WebDriver driver;

    private String sessionId;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "17");
        // Note: XP is tested as Windows 2003 Server on the Sauce Cloud
        capabilities.setCapability("platform", Platform.XP); 
        capabilities.setCapability("name",  testName.getMethodName());
        this.driver = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        this.sessionId = ((RemoteWebDriver)driver).getSessionId().toString();
    }

    public String getSessionId() {
        return sessionId;
    }

    @Test
    public void webDriverWithHelper() throws Exception {
        driver.get("http://www.amazon.com/");
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}