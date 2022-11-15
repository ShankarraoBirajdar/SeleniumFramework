package com.selenium.testrunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)			
@CucumberOptions(features={"features"},glue={"com.selenium.stepsdefination"},
monochrome = true,
plugin = {"pretty", "html:target/cucumber-report/Junit/cucumber.html",
        "json:target/cucumber-report/Junit/cucumber.json",
        "junit:target/cucumber-report/Junit/cucumber.xml"})						
public class TestRunnerUsingJunit 			
{	


}

//@CucumberOptions(
//        strict = true,
//        monochrome = true,
//        glue = "src.test.java.com.mobile.automation.framework.stepDefinition",
//        features = "src/test/resources/feature",
//        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
//                "json:target/cucumber-report/cucumber.json",
//                "junit:target/cucumber-report/cucumber.xml"})


//private static WebDriver driver;
//
//@Before
//private static void startBrowser() {
//	WebDriverManager.chromedriver().browserVersion("102.0.5005.63").setup();
//	 driver = new ChromeDriver();
//}
//
//@After
//private void tearDown() {
//	driver.quit();
//}