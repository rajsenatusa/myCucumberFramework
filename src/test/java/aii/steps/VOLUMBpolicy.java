package aii.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLUMBpolicy extends CommonMethods {

	@When("User enters UMB product selection information and effective date")
	public void user_enters_umb_product_selection_information_and_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
	}

	@When("User enters product selection information for UMB and {string}")
	public void user_enters_product_selection_information_for_umb_and_(String EffectiveDate) {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, EffectiveDate);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
	}

	@When("User answers previous policy written with AIIG questions")
	public void user_answers_previous_policy_written_with_aiig_questions() {
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
	}

	@When("User enters all required information on UMB quote screen")
	public void user_enters_all_required_information_on_umb_quote_screen() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(5);
		click(dwellingChevron.btnSave);
		wait(3);
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on UMB personal liability screen")
	public void user_enters_all_required_information_on_umb_personal_liability_screen() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, ConfigsReader.getProperty("umbliabilitycoverage"));
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, ConfigsReader.getProperty("uninsuredlimit"));
		sendText(umbrellaChevron.txtNumberOfAuto, ConfigsReader.getProperty("numberofauto"));
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User selects Umbrella Liability Coverage {string}")
	public void user_selects_umbrella_liability_coverage(String LiabilityCoverage) {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, LiabilityCoverage);
		wait(2);
	}

	@When("User selects Uninsured Limit {string}")
	public void user_selects_uninsured_limit(String UninsuredLimit) {

		selectDropdownText(umbrellaChevron.ddUninsuredLimit, UninsuredLimit);
	}

	@When("User enters Number of Auto {string}")
	public void user_enters_number_of_auto(String NumberOfAuto) {
		sendText(umbrellaChevron.txtNumberOfAuto, NumberOfAuto);
	}

	@When("User enters all required information on UMB review screen")
	public void user_enters_all_required_information_on_umb_review_screen() {
		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}
	@When("User answers all underwriting questions for UMB")
	public void user_answers_all_underwriting_questions_for_umb() {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion1, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion2, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion3, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion4, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion5, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion6, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion7, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion8, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion9, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion10, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion11, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion12, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion13, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion14, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion15, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion16, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion17, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion18, "No");
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}

	@When("User creates UMB application")
	public void user_creates_umb_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@Then("User validates that UMB policy has been created successfully")
	public void user_validates_that_umb_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Then("User creates UMB policy with passing information from excel {string} sheet")
	public void User_creates_umb_policy_with_passing_information_from_excel_sheet(String umbcustomerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLUMB.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, umbcustomerInfo);

		for (Map<String, String> dataMap : excelList) {

			if (!dataMap.containsValue("")) {
				String firstName = dataMap.get("FirstName");
				String lastName = dataMap.get("LastName");
				String birthDate = dataMap.get("BirthDate");
				String address = dataMap.get("Address");
				String zipcode = dataMap.get("Zipcode");
				String effDate = dataMap.get("EffectiveDate");
				String state = dataMap.get("State");
				String umbliabilitycoverage = dataMap.get("LiabilityCoverage");
				String uninsuredlimit = dataMap.get("UninsuredLimit");
				String numberofauto = dataMap.get("NumberOfAuto");

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
				click(product.btnProductSelectionUmb);

				// Quote Policy Chevron information was filled here
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				wait(5);
				click(dwellingChevron.btnSave);
				wait(3);
				clickTab(policyChevron.ddPolicyWrittenAiig);
				selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
				selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				click(policyChevron.btnNext);

				// liability coverage on quote screen
				selectDropdownText(umbrellaChevron.ddUmbLimitCov, umbliabilitycoverage);
				wait(2);
				selectDropdownText(umbrellaChevron.ddUninsuredLimit, uninsuredlimit);
				sendText(umbrellaChevron.txtNumberOfAuto, numberofauto);
				click(dwellingChevron.btnSave);
				wait(3);
				click(reviewChevron.btnReview);
				wait(3);

				// Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);
				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here
				fillUMB_UWQuestions();
				wait(1);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here

				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);

				// Closeout Chevron information was filled here

				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);

				// Validation

				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, VOL UMB policy has been created successfully");
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
