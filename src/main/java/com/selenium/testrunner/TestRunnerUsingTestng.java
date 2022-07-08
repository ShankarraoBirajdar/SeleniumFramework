package com.selenium.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "features" }, glue = { "com.selenium.stepsdefination" })
public class TestRunnerUsingTestng extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass
	public void setupClass() throws Exception{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
//	@Test(dataProvider = "features")
//	public void my_test() {
//		
//	}
	
	@AfterClass
	public void tearDown() {
		testNGCucumberRunner.finish();
	}
}
