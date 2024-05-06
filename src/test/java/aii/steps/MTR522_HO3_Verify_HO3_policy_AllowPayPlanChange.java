package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MTR522_HO3_Verify_HO3_policy_AllowPayPlanChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String app_Tx_Policy_Claim_Num;
	static String policyNum;
	static String nextDate;
	static String nextDate2;
	static LocalDateTime newDate = currentDate.plusDays(35);
	static LocalDateTime newDate2 = currentDate.plusDays(15);
	static String currentDue;
	static String IFrameTransactionAction;

	@When("User sets Number Days From Effective Date Allowed Pay Plan to <5> days")
	public void user_sets_number_days_from_effective_date_allowed_pay_plan_to5() {
		sendText(userLookup.txtDaysAllowedPayPlan, "5");
		wait(1);
	}

	@When("User sets Number of Allowed Pay Plan to <2> and validates numbers display")
	public void user_sets_number_of_allowed_pay_plan_to2_and_validates_numbers_display() throws Exception {
		sendText(userLookup.txtNumberAllowedPayPlan, "2");
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@Given("User login to Spin a Standard Agent <AG8134>")
	public void User_login_to_Spin_a_Standard_Agent_AG8134() throws Throwable {
		sendText(login.username, "AG8134");
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.btnSignIn);
		wait(1);
	}

	@When("User clicks user code as AG8134 and validates agent code will display")
	public void User_clicks_user_code_as_AG8134_and_validates_agent_code_will_display() throws Exception {
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "AG8134");
		Hooks.scenario.log("User code displays successfully!");
		attachScreenShot(driver);
		wait(1);
		click(driver.findElement(By.linkText("AG8134")));
		wait(1);

	}

	@When("User clicks Change Pay Plan")
	public void User_clicks_Change_Pay_Plan() {
		click(billingChevron.lnkChangePayPlan);
		wait(2);
	}

	@When("User changes Pay Plan to <8 Payment Plan> <mtr522>")
	public void user_changes_pay_plan_to_8_mtr553() throws Exception {
		attachScreenShot(driver);
		wait(1);
		click(reviewChevron.btn8PaymentPlan);
		wait(3);
		attachScreenShot(driver);
		// user clicks process and do payment plan change
		click(reviewChevron.btnProcess);
		wait(4);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr522>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr522()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches policy for <mtr522>")
	public void user_searches_policy_for_mtr522() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User changes system date to current date <mtr522>")
	public void User_changes_system_date_to_current_date_mtr522() throws Exception {

		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));

//		wait(3);
//		click(dashboard.btnAdmin);
//		click(dashboard.btnChangeDate);
//		wait(3);
//		sendText(product.txtNewDate, dtf.format(currentDate));
//		click(dashboard.btnChangeNewDate);
//		wait(3);
//		sendText(product.txtNewBookDate, dtf.format(currentDate));
//		click(dashboard.btnChangeBookDate);
//		wait(3);

	}

	@When("User gets next action date and changes system date as next 3 days <mtr522>")
	public void user_gets_next_action_date_and_changes_system_date_as_next_3_days_mtr522() throws Exception {

		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(3)));

	}

	@When("User selects endorsement date as system date plus 3 days")
	public void User_selects_endorsement_date_as_system_date_plus_3_days() {
		wait(2);
		
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(3)));
		wait(3);
		click(dashboard.btnStart);
		click(dashboard.btnStart);

	}

	@When("User selects Pay Plan Type as Automated Credit Card")
	public void User_selects_Pay_Plan_Type_as_Automated_Credit_Card() throws Exception {

		selectDropdownText(billingChevron.PayPlanFilterType, "Automated Credit Card");

		wait(2);
	}

	@When("User changes Pay Plan to <4 Payment Plan> <mtr522>")
	public void user_changes_pay_plan_to_4_mtr553() throws Exception {
		click(reviewChevron.btnPayPlan4);
		wait(3);
		attachScreenShot(driver);
	}

	@When("User enters Pay Plan Information")
	public void User_enters_Pay_Plan_Information() throws Exception {

		sendText(billingChevron.PaymentDay, "22");
		attachScreenShot(driver);
//		click(billingChevron.btnCreditCardDetails);
//		click(billingChevron.CreditCardPrompCheckBox);
//		click(billingChevron.CreditCardPromptDivOk);
		wait(2);
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		wait(2);

	}

	@And("User clicks Process <mtr522>")
	public void User_clicks_Process_mtr522() {
		click(billingChevron.ProcessBtn);

	}

	@And("User clicks Endore button")
	public void User_clicks_Endore_button() {
		click(reviewChevron.btnEndorse);
//		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(3)));
//		click(dashboard.btnStart);
//		wait(2);
	}

	@When("User clicks Endore Policy button")
	public void User_clicks_Endore_Policy_button() {
		closeoutChevron.btnEndorsePolicy.click();
		wait(1);
	}
	
	@When("User selects endorsement date as system date plus 3 days <mtr522>")
	public void User_selects_endorsement_date_as_system_date_plus_3_days_mtr522() {

		
		wait(3);
		
		switchToWindow(driver, "IFrameTransactionAction");
		
		wait(3);
 
		
//		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(3)));				
//		wait(3);
		
		
		driver.findElement(By.xpath("//input[@id='TransactionEffectiveDt']")).sendKeys("3/24/2024");
		
		wait(3);
		driver.findElement(By.id("TransactionEffectiveDt")).clear();
		wait(3);
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(3)));				
		wait(3);
		click(dashboard.btnStart);

	}
	@When("User clicks Change Pay Plan <mtr522>")
	public void User_clicks_Change_Pay_Plan_mtr522() {
		click(billingChevron.PayPlanFilter);
		wait(2);
	}
	@When("User validates 'Change Pay Plan' hyperlink is not longer visable to Agent")
	public void User_validates_Change_Pay_Plan_hyperlink_is_not_longer_visable_to_Agent() throws Exception {
		verify_AnyText_NotVisible(driver, "Change Pay Plan");
		attachScreenShot(driver);
		wait(1);
	}
	@When("User validates 'Payment Plan' cannot be edited to Agent")
	public void User_validates_Payment_Plan_cannot_be_edited_to_Agent() throws Exception {
		verify_AnyText_NotVisible(driver, "Payment Plan");
		attachScreenShot(driver);
		wait(1);
		
	}
	@When("User sets Number Days From Effective Date Allowed Pay Plan to <0> days <mtr522>")
	public void user_sets_number_days_from_effective_date_allowed_pay_plan_to0_mtr522() {
		sendText(userLookup.txtDaysAllowedPayPlan, "0");
		wait(1);
	}

	@When("User sets Number of Allowed Pay Plan to <0> and validates numbers display <mtr522>")
	public void user_sets_number_of_allowed_pay_plan_to0_and_validates_numbers_display__mtr522() throws Exception {
		sendText(userLookup.txtNumberAllowedPayPlan, "0");
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}
		
}
	
	
	

