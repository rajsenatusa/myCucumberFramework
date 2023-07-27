package aii.steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TOMHPD_EN_Policy extends CommonMethods {

		@Then("User verifies EN TOMHPD policy has been created successfully")
		public void User_verifies_EN_TOMHPD_policy_has_been_created_successfully() {	    	   						
			String expected = "Endorsement";
			String actual = historyChevron.txtEndorsement.getText();
			Assert.assertEquals("Test failed!", expected, actual);
		}
		
}
