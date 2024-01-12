package aii.steps;

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

public class SCHO3Policy extends CommonMethods {
	@When("User enters SC HO3 product selection information and effective date")
	public void user_enters_sc_ho3_product_selection_information_and_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 2);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
	}

	@When("User enters all required information on SC HO3 quote screen")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen() {
		// Quote Policy Chevron information was filled here

		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("scproducerselection"));
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("scpreviouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");

		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on SC HO3 dwelling screen")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roof"));
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
		selectDropdownText(dwellingChevron.ddFireAlarm, "None");
		selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@And("User creates SC HO3 application")
	public void user_creates_sc_ho3_application() {
		click(driver.findElement(By.id("Bind")));
		wait(5);
	}

	@And("User clicks Continue button")
	public void User_clicks_Continue_button() {
		click(product.btnContinue);
	}

	@And("User enters SC state")
	public void User_enters_SC_state() {
		selectDropdown(product.ddStateSelection, 2);
	}

	@And("User enters SC Producer Code")
	public void User_enters_SC_Producer_Code() {
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("scproducerselection"));
	}

	@And("User clicks SC Prior Carrier")
	public void User_clicks_SC_Prior_Carrier() {
		wait(1);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("scpreviouscarrier"));
		wait(1);
	}

	@And("User enters SC Prior Policy Expiration Date")
	public void User_enters_SC_Prior_Policy_Expiration_Date() {
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
	}

	@And("User selects New Purchase")
	public void User_selects_New_Purchase() {
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
	}

	@And("User selects SC Marital Status")
	public void User_selects_SC_Marital_Status() {
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
	}

	@And("User selects Are any residents within the household smokers")
	public void User_selects_Are_any_residents_within_the_household_smokers() {
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
	}

	@And("User selects Number of residents aged 18 and over")
	public void User_selects_Number_of_residents_aged_18_and_over() {
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
	}

	@And("User selects Number of residents aged 17 and under")
	public void User_selects_Number_of_residents_aged_17_and_under() {
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");
	}

	@And("User selects Wood Burning Stove")
	public void User_selects_Wood_Burning_Stove() {
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
	}

	@And("User selects Opening Protection")
	public void User_selects_Opening_Protection() {
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
	}

	@And("User clicks Create Application")
	public void User_clicks_Create_Application() {
		reviewChevron.btnCreateApplication.click();
	}

	@And("User enters SC Dwelling Address")
	public void User_enters_Dwelling_Address() {
		wait(1);
		sendText(quote.txtAddress, ConfigsReader.getProperty("scaddress"));
		wait(1);
		sendText(quote.txtZipCode, ConfigsReader.getProperty("sczipcode"));
		wait(2);
		click(quote.btnVerifyAddress);
		wait(1);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(1);
	}

	@And("User clicks Underwriting Chevron")
	public void User_clicks_Underwriting_Chevron() {
		click(reviewChevron.btnUnderwriting);
		wait(3);
	}

	@And("User enters SC HO3 Pay Plan Type")
	public void User_enters_SCHO3_Pay_Plan_Type() {
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		reviewChevron.btnFullPaymentRadio.click();
		reviewChevron.btnCreateApplication.click();
	}

	@And("User verifies SC HO3 policy has been created successfully")
	public void User_verifies_SC_HO3_policy_has_been_created_successfully() {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

	@When("User answers all underwriting questions for SC HO3")
	public void user_answers_all_underwriting_questions_for_sc_ho3() throws Exception {
		click(policyChevron.btnNext);
		fillSCHO3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		// Application Dwelling information was filled here
		wait(3);
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
	}

	@Then("User validates that SC HO3 policy has been created successfully")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully() throws Exception {


		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);


	}

	@Then("User creates SC HO3 policy with passing information from excel {string} sheet")
	public void User_creates_sc_ho3_policy_with_passing_information_from_excel_sheet(String scho3customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/SCHO3.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, scho3customerInfo);

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
				String constructtype = dataMap.get("ConsType");
				String occupancytype = dataMap.get("Occupancy");
				String monthsoccp = dataMap.get("Months");
				String yearcons = dataMap.get("ConstYear");
				String roof = dataMap.get("RoofMat");
				String quality = dataMap.get("Quality");

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

				// quote
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("scproducerselection"));
				wait(2);
				click(dwellingChevron.btnSave);
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				selectDropdownText(policyChevron.ddNewPurchase, "Yes");
				selectDropdownText(policyChevron.ddMaritalStatus, "Single");
				wait(2);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddResidentSmokers, "No");
				selectDropdownText(policyChevron.ddNumberAdultResident, "1");
				selectDropdownText(policyChevron.ddNumberChildrenResident, "0");
				selectDropdownText(policyChevron.ddConstructionType, constructtype);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				wait(1);
				click(dwellingChevron.btnSave);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				sendText(dwellingChevron.txtSquareFeet, "1600");
				wait(3);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
				selectDropdownText(dwellingChevron.ddFireAlarm, "None");
				selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
				selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
				selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
				click(dwellingChevron.btnSave);
				wait(3);
				selectDropdownText(dwellingChevron.ddQualityGrade, quality);
				click(dwellingChevron.btnCalculate);
				wait(4);
				click(dwellingChevron.btnSave);
				click(dwellingChevron.btnNext);
				wait(3);

				// Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);

				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here

				fillSCHO3_UWQuestions();
				wait(1);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				wait(2);
				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);

				// Closeout Chevron information was filled here

				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);
				wait(4);
				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, SC HO3 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(3);
				// gets policy number and prints to the console
				getPolicyNumber(driver);

				// Close unnecessary tabs
				closeUnnecessaryTabs();

				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("adminusername"));
				sendText(login.password, ConfigsReader.getProperty("adminpassword"));
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
