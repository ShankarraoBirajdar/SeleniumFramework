package com.selenium.support;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.repository.ReadConfig;

public class GenericFunctions extends BaseTest {

	private static GenericFunctions genericFunctions = null;
	private static ReadConfig readConfig = ReadConfig.getInstance();

	private GenericFunctions() {
	}

	public static GenericFunctions getInstance() {
		if (genericFunctions == null) {
			genericFunctions = new GenericFunctions();
		}
		return genericFunctions;
	}

	public void openUrl(String url) {
		driver.get(readConfig.getConfigProperty(url));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void logOut() {
		clickOn("logout", "homepage");
	}

	public void getScreenshot() throws IOException {

		/* File */
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(getFileName());
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");

		/* Bytes */
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		byte[] byteArr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//		File destFile = new File(getFileName());
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");

		/* Base64 */
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		String base64code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
//		byte[] byteArr = Base64.getDecoder().decode(base64code);
//		File destFile = new File(getFileName());
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");

	}

	public static String getFileName() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String formattedDate = myDateObj.format(myFormatObj);
		return "./Screenshots/img1" + formattedDate + ".jpg";
	}

	public void sendKeys(String value, String fieldName, String screenName) {
		System.out.println(readConfig.getLocator(screenName, fieldName));
		WebElement locator = driver.findElement(By.id(readConfig.getLocator(screenName, fieldName)));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
	}

	public void clickOn(String fieldName, String screenName) {
		System.out.println(readConfig.getLocator(screenName, fieldName));
		WebElement locator = driver.findElement(By.xpath(readConfig.getLocator(screenName, fieldName)));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
