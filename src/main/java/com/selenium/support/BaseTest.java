package com.selenium.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver = null;
	private static BaseTest baseTest = null;
	
	public static BaseTest getInstance() {
		if (baseTest == null) {
			baseTest = new BaseTest();
		}
		return baseTest;
	}

	@BeforeTest
	public static void setup() {
		
		Reporter.log("======Browser Session Started======", true);

		WebDriverManager.chromedriver().browserVersion("106.0.5249.91").setup();
		driver = new ChromeDriver();
	}

	@AfterTest
	public static void tearDown() {
		driver.quit();
		Reporter.log("======Browser Session Ended======", true);
	}

}
