package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO5_Policy extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	
	@When("User enters all required information on HO5 policy information screen")
	public void user_enters_all_required_information_on_ho5_policy_information_screen() {
		wait(2);
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, ConfigsReader.getProperty("georgiaaddress"));
		sendText(quote.txtZipCode, ConfigsReader.getProperty("georgiazipcode"));
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters HO5 product selection information and effective date as current date")
	public void user_enters_ho5_product_selection_information_and_effective_date_as_current_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdownText(product.ddStateSelection, "Georgia");
		selectDropdown(product.ddCarrierSelection, 1);
		wait(1);
		click(product.btnContinue);
		wait(2);
	}
	@When("User enters all required information on HO5 quote screen")
	public void user_enters_all_required_information_on_ho5_quote_screen() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("gapreviouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("gaconstructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("gaoccupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		click(policyChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO5 dwelling screen")
	public void user_enters_all_required_information_on_ho5_dwelling_screen() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("gayearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("gasquarefeet"));
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("garoofmetarial"));
		wait(2);
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
		selectDropdownText(dwellingChevron.ddFireAlarm, "None");
		selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on HO5 review screen")
	public void user_enters_all_required_information_on_ho5_review_screen() {
		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}
	@When("User creates HO5 application")
	public void user_creates_ho5_application() {

		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(dwellingChevron.btnNext);
	}
	@When("User answers all underwriting questions for HO5")
	public void user_answers_all_underwriting_questions_for_ho5() throws Exception {
		fillHO5_UWQuestions();
		wait(1);
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
	}
	@Then("User validates that HO5 policy has been created successfully")
	public void user_validates_that_ho5_policy_has_been_created_successfully() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO5 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		Hooks.scenario.log("New Business HO5 policy has been created successfully");
		attachScreenShot(driver);
	}
	
//----------------------------ooooooooooo----------------------------------------------------------------------	
	@Then("User creates HO5 policy with passing information from excel {string} sheet")
	public void User_creates_ho5_policy_with_passing_information_from_excel_sheet(String ho5customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLHO3.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, ho5customerInfo);

		
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
				wait(2);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				selectDropdownText(policyChevron.ddNewPurchase, "Yes");
				selectDropdownText(policyChevron.ddMaritalStatus, "Single");
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
				click(policyChevron.btnSave);
				wait(4);
				wait(1);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				sendText(dwellingChevron.txtSquareFeet, "2000");
				wait(3);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				wait(2);
				selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
				selectDropdownText(dwellingChevron.ddFireAlarm, "None");
				selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
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
				fillHO5_UWQuestions();
				wait(1);

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
				wait(3);
				click(closeoutChevron.btnIssueNB);
				wait(7);
				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, HO5 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);

				getPolicyNumber(driver);

				// Close unnecessary tabs
				closeUnnecessaryTabs();

				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("gaagentusername"));
				sendText(login.password, ConfigsReader.getProperty("gaagentpassword"));
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
