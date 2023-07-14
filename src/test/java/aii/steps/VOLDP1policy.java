package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLDP1policy extends CommonMethods {


@When("User enters DP1 product selection information and effective date")
public void user_enters_dp1_product_selection_information_and_effective_date() {
		//product selection information was filled here
			sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
			selectDropdown(product.ddStateSelection, 1);
			selectDropdown(product.ddCarrierSelection, 1);
			wait(2);
			click(product.btnContinue);
			click(product.btnProductSelectionDp1);
	
}
@When("User enters all required information on DP1 quote screen")
public void user_enters_all_required_information_on_dp1_quote_screen() {
	//Quote Policy Chevron information was filled here
	
			selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
			sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
			sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
			selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
			wait(2);
			click(policyChevron.btnNoEmailRadio);
			selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
			selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypedp1"));
			selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupieddp1"));
			selectDropdownText(policyChevron.ddPropertyManaged, ConfigsReader.getProperty("propertymanaged"));
			selectDropdownText(policyChevron.ddShortTermRental, ConfigsReader.getProperty("shorttermrental"));
			wait(1);
			click(policyChevron.btnNext);
			wait(3);
			
}
@When("User enters all required information on DP1 dwelling screen")
public void user_enters_all_required_information_on_dp1_dwelling_screen() {
			
			sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
			wait(2);
			sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
			selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
			selectDropdownText(dwellingChevron.ddMediationArbitDp1,ConfigsReader.getProperty("mediation"));
			selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
			selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
			click(dwellingChevron.btnCalculate);
			wait(4);
			click(dwellingChevron.btnSave);
			click(dwellingChevron.btnNext);
}
@When("User enters all required information on DP1 review screen")
public void user_enters_all_required_information_on_dp1_review_screen() {
	
			selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.btnFullPaymentRadio);
			wait(3);
			
			
}
@When("User creates DP1 application")
public void user_creates_dp1_application() {
			click(reviewChevron.btnCreateApplication);
			wait(4);
	
	click(dwellingChevron.btnNext);

}

@When("User answers all underwriting questions for DP1")
public void user_answers_all_underwriting_questions_for_dp1 () throws Exception {
	
	fillDP1_UWQuestions();
	wait(1);
	click(uwquestionsChevron.nextButtonUw);
			
}
@Then("User validates that DP1 policy has been created successfully")
public void user_validates_that_dp1_policy_has_been_created_successfully() {
	
	WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
	
	if(validate.getText().equalsIgnoreCase("New Business")) {
		System.out.println("Test passed, DP1 NB policy has been created successfully");
	}
	else {
		System.out.println("Test failed!");
}


}

}
