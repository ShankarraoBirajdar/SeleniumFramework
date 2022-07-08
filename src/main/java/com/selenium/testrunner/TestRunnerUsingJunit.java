package com.selenium.testrunner;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)			
@CucumberOptions(features={"features"},glue={"com.selenium.stepsdefination"})						
public class TestRunnerUsingJunit 			
{	
	private static WebDriver driver;
	
	@Before
	private static void startBrowser() {
		WebDriverManager.chromedriver().browserVersion("102.0.5005.63").setup();
		 driver = new ChromeDriver();
	}
	
	@After
	private void tearDown() {
		driver.quit();
	}

}

//@CucumberOptions(
//        strict = true,
//        monochrome = true,
//        glue = "src.test.java.com.mobile.automation.framework.stepDefinition",
//        features = "src/test/resources/feature",
//        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
//                "json:target/cucumber-report/cucumber.json",
//                "junit:target/cucumber-report/cucumber.xml"})