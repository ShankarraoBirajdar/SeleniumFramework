package com.selenium.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "features" },
glue = { "com.selenium.stepsdefination" }
,monochrome = true,
tags = "@Regression",
plugin = {"pretty", "html:target/cucumber-report/TestNG/cucumber.html",
        "json:target/cucumber-report/TestNG/cucumber.json",
        "junit:target/cucumber-report/TestNG/cucumber.xml"}
		)
public class TestRunnerUsingTestng extends AbstractTestNGCucumberTests {


//	private TestNGCucumberRunner testNGCucumberRunner;
//	
//	@BeforeClass(alwaysRun = true)
//	public void setupClass() throws Exception{
//		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	}
//	
//	@Test(groups = "cucumber",description = "Run Cucumber Features", dataProvider = "features")
//	public void feature(FeatureWrapper featureWrapper) {
//		testNGCucumberRunner.runScenario();
//	}
	
//	@DataProvider
//    public Object[][] features(){
//        return testNGCucumberRunner.provideScenarios();
//    }
//	
//	@AfterClass(alwaysRun=true)
//	public void tearDown() {
//		testNGCucumberRunner.finish();
//	}
}



//@CucumberOptions(
//        features = "src/main/java/Features",
//        glue = {"stepDefinitions"},
//        tags = {"~@Ignore"},  tags = "@Regression,@ignore",
//        format = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "rerun:target/cucumber-reports/rerun.txt"
//        },plugin = "json:target/cucumber-reports/CucumberTestReport.json")