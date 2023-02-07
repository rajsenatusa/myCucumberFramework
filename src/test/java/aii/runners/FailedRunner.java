package aii.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		features = "@target/failed.txt",
		glue = "com.neotech.steps"
		)


public class FailedRunner {

}
