package com.selenium.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver = null;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().browserVersion("102.0.5005.63").setup();
		driver = new ChromeDriver();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
