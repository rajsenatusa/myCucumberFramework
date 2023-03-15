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
	
	 
	@Given("I signin Spin as Standard Agent")
	public void i_signin_spin_as_standard_agent() throws Throwable {
//		myTest("my", "my123");
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
						 
		String date =  dtf.format(currentDate.plusDays(Integer.parseInt(Days)));
		
		String policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		
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
	
	@Given("I finalize and process")
	public void finalize_process() {
		click(reviewChevron.btnFinalize);
		wait(2);
				
		click(closeoutChevron.btnIssueNB);
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
	
	@Given("I fill the address details of {string} and {string}")
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
	
	
	@Given("I add {string} {string} {string} coverage")
	public void i_add_coverage(String coverage, String locator, String value) {
		addNewCoverage(coverage, locator, value);
	}

	@Given("I modify {string} {string} coverage")
	public void i_modify_coverage(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	



}
