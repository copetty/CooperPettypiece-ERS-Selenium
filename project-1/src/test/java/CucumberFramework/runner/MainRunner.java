package CucumberFramework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = {"C:\\Users\\copet\\OneDrive\\Desktop\\Project1\\project-1-copetty\\project-1\\src\\test\\java\\CucumberFramework\\featureFiles\\"},
		glue = {"CucumberFramework.steps"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter: target/report.html"}
		
		)
public class MainRunner {
	
	// class used to run all feature files

}
