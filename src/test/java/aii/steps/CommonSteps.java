package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policy;
	static String date;
	static String appNum;
	
	 
	@Given("I signin Spin as Standard Agent")
	public void i_signin_spin_as_standard_agent() throws Throwable {
	 sendText(login.username, ConfigsReader.getProperty("username"));
	 sendText(login.password, ConfigsReader.getProperty("password"));
	 click(login.btnSignIn);
	 wait(1);	
	 
		
	}
	
	@Given("User search for {string}")
	public void user_with_logged_in_and_search_for(String policy) {
				 wait(1);
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);

		 wait(1);
	}
	
	@And("I start transaction on policy")
	public void i_start_transaction() {
		startTransaction();
	    
	}
	
	@Given("I select endorsement transaction on {string}")
	public void i_select_an_endorsement_transaction(String Days) throws Exception {
						 
		date =  dtf.format(currentDate.plusDays(Integer.parseInt(Days)));
		
		policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		startTransaction();
		
	    selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
	    click(dashboard.btnSelect);
	    sendText(dashboard.txtSelectDate, date);
	    click(dashboard.btnStart);
	    click(dashboard.btnStart);
	      
	    
	}
	
	@Given("I finalize and process the transaction")
	public void finalize_process() {
		click(reviewChevron.btnFinalize);
		wait(2);
				
		click(closeoutChevron.btnIssueNB);
		wait(5);
	}


	@Given("I navigate to policyfile screen")
	public void i_navigate_to_policyfile_screen() {
	
		click(policyFileChevron.btnPolicyFilePage);
		Hooks.scenario.log("Policyfile tab selected");
		
	}
	
	
	@Given("I navigate to dwelling screen")
	public void i_navigate_to_dwelling_screen() {
	
		click(specialChevron.btnDwellingWiz);
		Hooks.scenario.log("Dwelling tab selected");
		
	}
	

	@Given("I start transaction as a New Customer")
	public void i_start_transaction_as_a_new_customer_common() {
			   
		wait(1);
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(1);
		dashboard.btnNewQuote.click();
		WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
		selectDropdownText(element, "Individual");
		
	}
	
	@When("I select the product from Product Selection List as {string}")
	public void i_enter_prod_selection_information_common(String Product) {
		//product selection information
		switch (Product) {
		case "HO3":
			click(product.btnProductSelectionHo3); 
			break;
		case "GOC":	
			click(product.btnProductSelectionGoc);
			break;
		case "DP1":	
			click(product.btnProductSelectionDp1);	
			break;
		case "DP3":	
			click(product.btnProductSelectionDp3);	
			break;
			
		}
		
		}
	
	@And("I change date of system {string}")
	public void i_validate_change_Date(String Days) throws Exception {
			
		changeDate(Days);
			 
	}
	
	@And("I enter Quote Information as effective date with {string} days difference and state {string} and {string} Insurance Carrier group")
	public void i_enter_quote_Information(String Days, String State, String CarrierGroup) throws Exception {
		
		String effectiveDate = changeDate(Days);	
					
		click(dashboard.lnkNewQuote);
		
		sendText(dashboard.txtEffectiveDate,effectiveDate);
		
		if (State.toUpperCase().contains("FL") || State.toUpperCase().contains("FLORIDA") ) {
			selectDropdown(dashboard.ddState, 1);
		}
		
		if (CarrierGroup.toUpperCase().contains("AI") || State.toUpperCase().contains("AMERICAN INTEGRITY INSURANCE GROUP") ) {
			selectDropdown(dashboard.ddCarrierGroup, 1);
		}
				
		wait(2);
		click(dashboard.btnNewQuoteStart);
		
	}
	
	@Given("I select the entity as {string}")
	public void i_select_the_entiry_as(String entity) {
		
		selectDropdownText(policyChevron.ddEntity, entity);
	}
	
	@And("I enter all required information on Insured information section")
	public void i_enter_all_required_information_on_customer_information_screen() {
	   
		//quote level information was filled here
		sendText(policyChevron.txtInsuredFirstName, ConfigsReader.getProperty("firstname"));
		sendText(policyChevron.txtInsuredLastName, ConfigsReader.getProperty("lastname"));
		sendText(policyChevron.txtInsuredBirthDt, ConfigsReader.getProperty("birthdate"));
		click(policyChevron.btnResetName);
		wait(2);
		}
	
	@Given("I fill the address details with {string} and zip {string}")
	public void i_fill_the_address_details_of(String address, String zip) {
//		sendText(quote.txtAddress, ));
		sendText(policyChevron.txtStreet, address);
		sendText(policyChevron.txtPostalCode, zip);
		wait(2);
		click(policyChevron.btnVerifyAddress);
		wait(2);
		click(policyChevron.btnSave);
		wait(2);
	}
	
	@And("I select {string} package")
	public void i_select_coverage(String typackage) {
	
	switch(typackage.toUpperCase()) {
	case "BASIC":
		click(dwellingChevron.radioBasicPackage);
		Hooks.scenario.log("Basic Package selected");
		break;
	case "INTEGRITY SELECT":
		click(dwellingChevron.radioIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
		break;
	}
	}
		
	@Given("I validate the default value of {string} {string} as {string}")
	public void i_validate_the_default_value_of_as(String coverage, String element, String expectedValue) {
	    
		CommonMethods.verifyAnyDropdownDefaultValue(coverage, element, expectedValue);
	}
	
	@Given("Navigate to Policy tab")
	public void navigate_to_policy_tab() {
		click(policyChevron.btnPolicyChevronLink);
	}
	
	
	@Given("I validate the following message should display {string}")
	public boolean i_validate_the_following_message_should_display(String text) {
		String value = "";
		try {
			
			List<WebElement> oCheckBox = driver.findElements(By.id("WarningIssues"));
			int size = oCheckBox.size();
	
			for(int i = 0; i < size; i++ )	{
			String msg = oCheckBox.get(i).getText();
			value = value.concat(msg);
			//Hooks.scenario.log(value+" concat is visible ");
				 
				if (value.contains(text)){
					 Hooks.scenario.log("Is visible : "+text);
					break;
					}	
			}
    		return true;   	

            } catch (Exception e) {
            	Hooks.scenario.log("Is not visible: " +  text);
            	e.printStackTrace();
            	return false;
            	
            }
	}
	
	
	@Given("I fill all the DP3 uw questions")
	public void i_fill_DP3uwQuestions() throws InterruptedException {
		Thread.sleep(3000);
		click(dwellingChevron.btnNext);
		wait(1);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question16, "No");  
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");  
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");  
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");	 
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");	
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");	
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}
	
	
	@Given("I fill all the HO3 uw questions")
	public void i_fill_HO3uwQuestions() throws InterruptedException {
		Thread.sleep(3000);
		click(dwellingChevron.btnNext);
		wait(1);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		selectDropdownText(uwquestionsChevron.ho3Question8, "No");
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		selectDropdownText(uwquestionsChevron.ho3Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question16, "No");
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}

	
	@When("I enter all the information on DP3 review screen")
	public void i_enter_all_required_information_on_dp3_review_screen() throws Exception {
		
		click(dwellingChevron.btnNext);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(2);
		clickNewCustomer(driver);
		click(dwellingChevron.btnSave);
		wait(2);
		
	}
	
	
		
	@Given("I fill all the details on Review screen for {string} product")
	public void i_fill_all_the_details_on_review_screen_for_product(String LOB) throws Exception {
	    
		click(dwellingChevron.btnNext);
		
		switch (LOB) {
				
		case "HO3":
			select_Direct_FullPayplanType();
			break;
			
		case "DP3":
			selectDropdownText(reviewChevron.ddOrderInsScore, "No");
			select_Direct_FullPayplanType();		
			break;		
			
		case "DP1":
			select_Direct_FullPayplanType();	
			break;		
			
		case "HO6":
			select_Direct_FullPayplanType();
			break;
			
		case "HO4":
			select_Direct_FullPayplanType();
			break;
			
		case "MHO":
			select_Direct_FullPayplanType();
			break;
			
		case "GOC":
			selectDropdownText(reviewChevron.ddOrderInsScore, "No");
			select_Direct_FullPayplanType();
			break;
			
		case "AIB":
			select_Direct_FullPayplanType();
			break;
			
		case "UMB":
			select_Direct_FullPayplanType();
			break;
			
		case "TO HO3":
			select_Direct_FullPayplanType();
			break;
			
		case "TO DP1":
			select_Direct_FullPayplanType();
			break;
			
		case "TO DP3":
			select_Direct_FullPayplanType();
			break;
			
		case "TO MHO":
			select_Direct_FullPayplanType();
			break;
			
		case "TO MHPD":
			select_Direct_FullPayplanType();
			break;
			
		default:
			throw new RuntimeException("Unable to find LOB");
		}
	}

	@Given("I create application for {string} product")
	public void i_create_application_for_product(String LOB) {
				
		if(LOB.equalsIgnoreCase("HO4") || LOB.equalsIgnoreCase("DP1") || LOB.equalsIgnoreCase("DP3") || 
				LOB.equalsIgnoreCase("GOC") || LOB.equalsIgnoreCase("AIB") || LOB.equalsIgnoreCase("UMB") || 
				LOB.equalsIgnoreCase("TO DP1") || LOB.equalsIgnoreCase("TO DP3") || LOB.equalsIgnoreCase("TO MHO") || 
				LOB.equalsIgnoreCase("TO HO3") || LOB.equalsIgnoreCase("TO MHPD") || LOB.equalsIgnoreCase("MHO")) {
				
			click(reviewChevron.btnCreateApplication);
			wait(3);
		
		}
		
		else
		{
			click(reviewChevron.btnCreateApplication);
			wait(4);
			click(reviewChevron.btnInsuranceScoreBox);
			click(reviewChevron.btnInsuranceScoreOk);
			wait(3);
			
		}
	    
	}

	@Given("I fill all the {string} product UW questions")
	public void i_fill_all_the_product_uw_questions(String LOB) throws Exception {
				
		switch (LOB) {
		
		case "HO3":
			fillHO3_UWQuestions();
			break;
			
		case "DP3":
			fillDP3_UWQuestions();	
			break;		
			
		case "DP1":
			fillDP1_UWQuestions();
			break;		
			
		case "HO6":
			fillHO6_UWQuestions();
			break;
			
		case "HO4":
			fillHO4_UWQuestions();
			break;
			
		case "MHO":
			fillMHO_UWQuestions();
			break;
			
		case "GOC":
			fillGOC_UWQuestions();
			break;
			
		case "AIB":
			fillBoat_UWQuestions();
			break;
			
		case "UMB":
			fillUMB_UWQuestions();
			break;
					
		default:
			throw new RuntimeException("Unable to find LOB");
		}
	}
	
	@Given("I renew policy {string} to next term through manual transaction")
	public void i_renew_policy_to_next_term(String policy) {
		 
			 wait(1);
			 sendText(dashboard.txtSearchBar, policy);
			 click(dashboard.search);
			 wait(1);
			 
			startTransaction();
			
		    selectDropdownText(dashboard.ddSelectTransaction, "Renewal");
		    click(dashboard.btnSelect);
		    click(dashboard.btnStart);
		    wait(1);
		    click(reviewChevron.btnFinalize);
		    click(closeoutChevron.btnIssueNB);
		 
	}
	
	@Given("I renew policy to next term through manual transaction")
	public void i_renew_policy_to_next_term_as_per_global_variable_variable_policy() {
	   
		 policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		 startTransaction();
			
	     selectDropdownText(dashboard.ddSelectTransaction, "Renewal");
   	     click(dashboard.btnSelect);
	     click(dashboard.btnStart);
         wait(1);
	     click(reviewChevron.btnFinalize);
	     click(closeoutChevron.btnIssueNB);
		
	}
	
	@Given("I reinstate  policy {string}")
	public void i_reinstate_policy(String policy) {
	    
		 wait(1);
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		startTransaction();
		
	    selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
	    click(dashboard.btnSelect);
	    click(dashboard.btnStart);
	    wait(1);
	    click(closeoutChevron.btnIssueNB);
	}
	
	@Given("I cancel  policy {string}")
	public void i_cancel_policy(String policy) {
		 wait(1);
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		startTransaction();
		
	    selectDropdownText(dashboard.ddSelectTransaction, "Cancellation");
	    click(dashboard.btnSelect);
	    selectDropdownText(policyChevron.ddCancellationType, "Company");
	    wait(1);
	    selectDropdownText(policyChevron.ddReasonType, "ABC Insured declined policy");
	    wait(1);
	    click(policyChevron.btnAdd);
	    wait(1);
	    click(dashboard.btnStart);
	    wait(1);
	    click(closeoutChevron.btnIssueNB);
	}
	
	@Given("I cancel policy through manual transaction")
	public void i_cancel_policy_through_manual_transaction() {
	   
		 policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		startTransaction();
		
	    selectDropdownText(dashboard.ddSelectTransaction, "Cancellation");
	    click(dashboard.btnSelect);
	    selectDropdownText(policyChevron.ddCancellationType, "Company");
	    wait(1);
	    selectDropdownText(policyChevron.ddReasonType, "ABC Insured declined policy");
	    wait(1);
	    click(policyChevron.btnAdd);
	    wait(1);
	    click(dashboard.btnStart);
	    wait(1);
	    click(closeoutChevron.btnIssueNB);
		
	}
	@Given("I reinstate policy through manual transaction")
	public void i_reinstate_policy_through_manual_transaction() {
	  
		 policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			
		 sendText(dashboard.txtSearchBar, policy);
		 click(dashboard.search);
		 wait(1);
		 
		 startTransaction();
			
		    selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
		    click(dashboard.btnSelect);
		    click(dashboard.btnStart);
		    wait(1);
		    click(closeoutChevron.btnIssueNB);
		 
	}

	

	@Given("I finalize the application or transaction")
	public void i_finalize_the_application() {
		click(reviewChevron.btnFinalize);
		Hooks.scenario.log("Finalize button clicked");
		wait(2);
	}

	@Given("I Issue new business with payment type {string}")
	public void i_issue_new_business_with_payment_type(String paymentType) {
		
		
		switch (paymentType.toLowerCase()) {
		
		case "none":
			selectDropdownText(closeoutChevron.ddPaymentType, "None");
			break;
			
		case "credit card":
			selectDropdownText(closeoutChevron.ddPaymentType, "Credit Card");
			makeCCPayment();			
			break;		
									
		default:
			throw new RuntimeException("Unable to find Payment type");
		}
		
		wait(1); 
		    click(closeoutChevron.btnIssueNB);
		    wait(4);
	}


	@And("I enter Policy General detail with Producer Code {string}")
	public void i_fill_all_the_details_on_PolicyGeneral(String producerCode) {
		sendText(policyChevron.txtProducerCodeSel, producerCode);
	    
	}
	
	@Given("I signin Spin as user {string} and password {string}")
	public void i_signin_spin_as_userfrom_featurefiles(String user, String Pwd) {
	 sendText(login.username, user);
	 sendText(login.password, Pwd);
	 click(login.btnSignIn);
	 wait(1);		
	}
	
	
	@Given("I submit the application for UW approval")
	public void i_submit_the_application_for_uw_approval() {
		appNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
		
		sendText(closeoutChevron.txtWorkflowComments, "Underwriting approval required for "+appNum);
		submitForApprovalWithDialog();
	}

	@Given("I submit the application for UW manager approval")
	public void i_submit_the_application_for_uw_manager_approval() {
		appNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
		
		submitForApproval();
	}
	
	
	@Given("I sign out")
	public void i_sign_out() {
		click(dashboard.btnUserMenu);
		wait(1);
		click(dashboard.btnSignOut);
		wait(2);
		Hooks.scenario.log("Sign out was clicked");
	}


}
