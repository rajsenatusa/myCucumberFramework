package aii.steps;

import aii.testbase.BaseClass;
import aii.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static Scenario scenario;
	@Before
	public void start(Scenario scenario) {
		BaseClass.setUp();
		Hooks.scenario= scenario;
		scenario.log("****LAUNCH BROWSER****");

	}

	@After
	public void end(Scenario scenario) {
		
	
		//add information to the scenario
		
		byte[] picture;
		Hooks.scenario= scenario;
		
		//we want to store the screenshots in different locations if the scenario fails/passes

		if(scenario.isFailed())
		{
			//get the screenshot using the takeScreenshot method
			picture  = CommonMethods.takeScreenshot("failed/" + scenario.getName());
		}
		else
		{
			picture = CommonMethods.takeScreenshot("passed/"+ scenario.getName());
		}
		
		scenario.attach(picture, "image/png", scenario.getName());
		
		BaseClass.tearDown();
		
	}

}
