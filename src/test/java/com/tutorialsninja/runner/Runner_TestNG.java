package com.tutorialsninja.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = {"src/test/resources/features"},
		glue = {"com.tutorialsninja.stepdefinitions", "com.tutorialsninja.hooks"},
		tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegistration or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddToCart or @TutorialsNinjaLogout",
		plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
		
		)


public class Runner_TestNG extends AbstractTestNGCucumberTests {
	

}

