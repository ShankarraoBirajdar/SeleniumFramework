package com.selenium.stepsdefination;

import com.selenium.support.GenericFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepsDefination {
	
	private  GenericFunctions genericFunctions = GenericFunctions.getInstance();
	
  @Given("^Open Chome and Start Application$")
  public void given() throws Throwable {
	  genericFunctions.launchBrowser();
	  
  }

  @When("^I Navigate to saucedemo Application$")
  public void when() throws Throwable {
	  genericFunctions.openUrl("url");
  }

  
}
