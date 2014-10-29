package com.java.ex.hello;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//test
@RunWith(Suite.class)
@SuiteClasses({ //*WebDriverDemoShootoutTest.class, WebDriverTest.class,
		WebDriverWithHelperTest.class })
public class AllTests {

}
