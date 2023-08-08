package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;


public class TC15212_HO6_LLC_ESignature_Policy extends CommonMethods{
	static String Insured1_email = "aiicmodel@aiiflorida.com";
	static String Agent_email = "cyavas@aiiflorida.com";
	protected static String PolicyNum;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	
	@When("User sets payment type and sets E-signature")
	public void user_sets_payment_type_and_sets_e_signature() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		selectDropdownText(closeoutChevron.ddEsignature, "Yes");
		wait(1);
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_1_Include");
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Signer_3_Include");	
	}
	@When("User validates <Missing Required Information> error message has been displayed")
	public void user_validates_error_message_displayed() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(3);
		Assert.assertEquals(closeoutChevron.msgMissingFieldError, "Missing Required Information");
	}
	@When("User enters only agent first name for E-Signature and clicks issue new business button and validates error message")
	public void user_enters_only_agent_first_name() throws Exception {
		sendText(closeoutChevron.txtAgentFirstName, "Ted");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		Assert.assertEquals(closeoutChevron.msgMissingFieldError, "Missing Required Information");
	}
	@When("User enters only agent last name for E-Signature and clicks issue new business button and validates error message")
	public void user_enters_only_agent_last_name() throws Exception {
		sendText(closeoutChevron.txtAgentLastName, "Johnson");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		Assert.assertEquals(closeoutChevron.msgMissingFieldError, "Missing Required Information");
		sendText(closeoutChevron.txtInsuredEmail,Insured1_email);
		wait(1);
	}
	@When("User enters same email address for Agent and validates <Email address must be different for each Signer. Please update email address> error message")
	public void user_enters_same_email_address_for_agent() throws Exception {
		sendText(closeoutChevron.txtAgentEmail,Insured1_email);
		click(closeoutChevron.btnIssueNB);
		wait(3);
		Assert.assertEquals(closeoutChevron.msgMissingFieldError, "Email address must be different for each Signer. Please update email address.");
		sendText(closeoutChevron.txtInsuredEmail,Insured1_email);
		wait(1);
	}
	@When("User enters Agent Email address and clicks issue new business button and validates error message")
	public void user_enters_agent_email_address_clicks() throws Exception {
		sendText(closeoutChevron.txtAgentEmail,Agent_email);
		click(closeoutChevron.btnIssueNB);
		wait(3);
		Assert.assertEquals(closeoutChevron.msgMissingFieldError, "Missing Required Information");
	}
	@When("User enters Agent License Number and issues policy")
	public void user_enters_agent_license_number() throws Exception {
		sendText(closeoutChevron.txtAgentLicenseNumber,"AGENT001");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		getPolicyNumber(driver);
		
	     // Close unnecessary tabs
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       for (int i = tabs.size() - 1; i > 0; i--) {
           driver.switchTo().window(tabs.get(i));
           driver.close();
       }

       // Switch back to the main page
       driver.switchTo().window(tabs.get(0));
	}
	@When("User clicks eSignature Chevron")
	public void user_clicks_esignature_chevron() throws Exception {
		click(driver.findElement(By.id("Tab_ESignature")));
		wait(3);
	}
	@When("User validates Cancel label and Refresh button is visible")
	public void user_validates_cancel_label_and_refresh() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Cancel");
		verify_AnyButton_IsVisible(driver, "Refresh");
	}
	@When("User validates status has been displayed as Sent for Agent and Insured")
	public void user_validates_status_has_been_displayed() throws Exception {
		Assert.assertEquals(closeoutChevron.txtAgentStatus, "Sent");
		Assert.assertEquals(closeoutChevron.txtInsuredStatus, "Sent");
	}
	@When("User validates Insured and Agent Email addresses have been displayed")
	public void user_validates_insured_and_agent_email_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, Insured1_email);
		verify_AnyText_IsVisible(driver, Agent_email);
	}
	@When("User validates Application<e-signed> is not visible")
	public void user_validates_application_is_not_visible() throws Exception {
		verify_AnyText_NotVisible(driver, "Application (e-signed)");
	}
}
