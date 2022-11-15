package com.selenium.stepsdefination;

import com.selenium.support.BaseTest;
import com.selenium.support.GenericFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class StepsDefination {
	
	private  GenericFunctions genericFunctions = GenericFunctions.getInstance();
	
  @Given("^I Open Broswer$")
  public void launchBrowser() throws Throwable {
	  BaseTest.setup();
	  
  }

  @When("^I Navigate to saucedemo Application$")
  public void openUrl() throws Throwable {
	  genericFunctions.openUrl("url");
  }
  
  @When("^I Enter \"([^\"]*)\" into \"([^\"]*)\" present in \"([^\"]*)\"$")
  public void sendKeys(String value, String fieldName, String screenName) throws Throwable {
	  genericFunctions.sendKeys(value, fieldName,screenName);
  }
  
  @When("^I click \"([^\"]*)\" present in \"([^\"]*)\"$")
  public void clickOn(String fieldName, String screenName) throws Throwable {
	  genericFunctions.clickOn(fieldName, screenName);
  }
  
  @When("^I Log Out$")
  public void logOut() throws Throwable {
	  genericFunctions.logOut();
  }
  
  @When("^I Close Broswer$")
  public void closeBrowser() throws Throwable {
	  BaseTest.tearDown();
  }

  
}
