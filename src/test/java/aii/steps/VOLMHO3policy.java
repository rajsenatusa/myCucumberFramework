//updated on 07/14/2023 by Can Yavas

package aii.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLMHO3policy extends CommonMethods {
	
	@When("User enters MHO3 product selection information and effective date")
	public void user_enters_mho3_product_selection_information_and_effective_date() {
		//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionMho3);
				
	}
	@When("User enters all required information on MHO3 quote screen")
	public void user_enters_all_required_information_on_mho3_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
				sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
				click(policyChevron.btnPropertyTypePri);
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
				selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupiedmho3"));
				wait(1);
				click(policyChevron.btnNext);
				wait(3);
	}
	@When("User enters all required information on MHO3 dwelling screen")
	public void user_enters_all_required_information_on_mho3_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, ConfigsReader.getProperty("coveragea"));
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		
	}
	@When("User enters all required information on MHO3 review screen")
	public void user_enters_all_required_information_on_mho3_review_screen() {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(3);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
	}
	@When("User creates MHO3 application")
	public void user_creates_mho3_application() {
		
				click(reviewChevron.btnCreateApplication);
				wait(4);
				click(dwellingChevron.btnNext);
			
	}
	@When("User answers all underwriting questions for MHO3")
	public void user_answers_all_underwriting_questions_for_mho3() throws Exception {
		//Application Underwriting Questions Chevron was filled here

		fillMHO_UWQuestions();
		
		//Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarialmho3"));
		selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
		selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));
	}
	@Then("User validates that MHO3 policy has been created successfully")
	public void user_validates_that_mho3_policy_has_been_created_successfully() {
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, MHO3 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}
	}
	@And("User clicks VOL MHO3 policy")
	public void User_clicks_VOL_MHO3_policy() {
		click(product.btnProductSelectionMho3);
	}
	@And("User clicks Property Type as Private Property")
	public void User_clicks_Property_Type_as_Private_Property () {
		click(policyChevron.btnPropertyTypePri);
	}
	@And("User enters MHO3 Pay Plan Type")
	public void User_enters_MHO3_Pay_Plan_Type () {
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User verifies NB MHO3 policy has been created successfully")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully() {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test passed!", expected, actual);
	}
	@And("User clicks MHO3 Prior Carrier")
	public void User_clicks_MHO3_Prior_Carrier() {
		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
 		click(dwellingChevron.btnSave);
		wait(1);
	}	  
	@Then("User creates MHO3 policy with passing information from excel {string} sheet")
	public void User_creates_mho3_policy_with_passing_information_from_excel_sheet(String mho3customerInfo) throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLMHO3.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, mho3customerInfo);

		for (Map<String, String> dataMap : excelList) {

			if (!dataMap.containsValue("")) {
				String firstName = dataMap.get("FirstName");
				String lastName = dataMap.get("LastName");
				String birthDate = dataMap.get("BirthDate");
				String address = dataMap.get("Address");
				String zipcode = dataMap.get("Zipcode");
				String effDate = dataMap.get("EffectiveDate");
				String state = dataMap.get("State");
				String previousCarr = dataMap.get("PreviousCarrier");
				String previousExp = dataMap.get("PreviousExpDate");
				String phone = dataMap.get("Phone");
				String occupancytype = dataMap.get("Occupancy");
				String monthsoccp = dataMap.get("Months");
				String yearcons = dataMap.get("ConstYear");
				String roof = dataMap.get("RoofMat");
				String coveragea=dataMap.get("CoverageA");

				sendText(quote.txtFirstName, firstName);
				sendText(quote.txtLastName, lastName);
				wait(2);
				sendText(quote.txtBirthDate, birthDate);
				wait(2);
				click(quote.txtSearchName);
				sendText(quote.txtAddress, address);
				sendText(quote.txtZipCode, zipcode);
				wait(2);
				click(quote.btnVerifyAddress);
				wait(2);
				click(quote.btnCopyToMailAddress);
				click(quote.btnCopyToBillAddress);
				click(quote.btnSaveAndQuote);
				wait(2);

				// productSelection
				sendText(product.txtEffectiveDate, effDate);
				selectDropdownText(product.ddStateSelection, state);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionMho3);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				click(policyChevron.btnPropertyTypePri);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				wait(1);
				click(policyChevron.btnNext);
				wait(3);

				//dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				wait(2);
				sendText(dwellingChevron.txtCoverageA, coveragea);
				wait(2);
				click(dwellingChevron.btnSave);
				click(dwellingChevron.btnNext);
				

				// Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(3);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);

				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here

				fillMHO_UWQuestions();
				wait(1);
				

				// Application Dwelling information was filled here
				
				selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
				selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
				selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
				sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));

				// Closeout Chevron information was filled here

				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);
				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);
				wait(5);
				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, MHO3 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);
				getPolicyNumber(driver);

			     // Close unnecessary tabs
		        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		        for (int i = tabs.size() - 1; i > 0; i--) {
		            driver.switchTo().window(tabs.get(i));
		            driver.close();
		        }

		        // Switch back to the main page
		        driver.switchTo().window(tabs.get(0));
		        
				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.btnSignIn);
				wait(3);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(1);
				dashboard.btnNewQuote.click();
				WebElement element = driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");

			} else {
				break;
			}

		}

	}
	
}

