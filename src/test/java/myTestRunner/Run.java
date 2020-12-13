package myTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "D:\\coding\\cogni\\CaseStudy\\src\\test\\java\\featureFiles\\test.feature",
		glue= {"stepDefinition"},
		dryRun= false,
		stepNotifications= true
		)

public class Run {

}
