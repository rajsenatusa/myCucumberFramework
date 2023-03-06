package aii.steps;

import aii.testbase.BaseClass;
import aii.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void start(Scenario scenario) {
		BaseClass.setUp();
		
		scenario.log("****LAUNCH BROWSER****");
		scenario.log("-----------------------");
		scenario.log(""+scenario.getName()+Thread.currentThread().getId()+"");
		scenario.log("-----------------------");

	}

	@After
	public void end(Scenario scenario) {
		
	
		//add information to the scenario
		
		byte[] picture;
		
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
