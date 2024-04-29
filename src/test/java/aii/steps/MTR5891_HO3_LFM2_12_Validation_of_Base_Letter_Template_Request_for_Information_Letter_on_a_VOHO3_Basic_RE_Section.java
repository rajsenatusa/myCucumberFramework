package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5891_HO3_LFM2_12_Validation_of_Base_Letter_Template_Request_for_Information_Letter_on_a_VOHO3_Basic_RE_Section
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String RequestInformation_Letter;
	static String RequestInformationLetter;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on policy information screen <mtr5891>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5891() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO3 quote screen <mtr5891>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr5891() {
		// Quote Policy Chevron information was filled here
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, ("AAA"));
		wait(1);
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(2);

	}

	@When("User enters all required information on HO3 dwelling screen <mtr5891>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5891() {
		// Quote Dwelling information was filled here
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		dwellingChevron.txtCoverageA.clear();
		dwellingChevron.txtCoverageA.sendKeys("500000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5891>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr5891()
			throws Exception {

		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		click(closeoutChevron.btnIssueNB);
		wait(3);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));
		wait(3);
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
		wait(1);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number <mtr5891>")
	public void User_searches_for_Policy_Number_mtr5891() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User selecks Correspondence Form as 'Request for Information Letter'")
	public void User_selecks_Correspondence_Form_as_Advance_Payment_Letter() throws Exception {
		wait(1);
		selectDropdownText(correspondance.ddSelectCorrespondance, "Interactive - Request For Information Letter");
		wait(4);
		click(correspondance.btnAdd);
		wait(5);

	}

	@Then("User verifies 'Request for Information Letter")
	public void User_verifies_Request_for_Information_Letter_in_Claim_File() throws Exception {
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Request for Information Letter");
		Hooks.scenario.log("Request for Information Letter displays successfully!");
		wait(1);

	}
	@Then("User verifies 'Request for Information Letter' in Claim File")
	public void User_verifies_Request_Information_Letter_in_Claim_File() throws Exception {
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Request For Information Letter");
		Hooks.scenario.log("Request for Information Letter displays successfully!");
		wait(1);

	}

	@When("User clicks on 'Request for Information Letter'")
	public void User_clicks_on_Request_for_Information_Letter() throws Exception {
		wait(1);
		clickOnAnyPolicyFileTabForm(driver, "Request For Information Letter");
		wait(1);
	}

	@Then("User verifies 'Request for Information Letter' displays")
	public void User_verifies_Request_for_Information_Letter_displays() throws Exception {
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Hooks.scenario.log("Request for Information Letter displays successfully!");
		attachScreenShot(driver);
		wait(1);
		RequestInformation_Letter = PdfComparator.makePdf(driver, "Request_ Information_Letter.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RequestInformation_Letter);

		wait(20);
		RequestInformationLetter = SmartPDFComparator2.getPDFtextByArea(FileLocation + RequestInformation_Letter, 1, 0,
				0, 800, 800);

		PdfComparator.verifyFormData(driver, RequestInformationLetter, "Cause of Loss: Hail");
		PdfComparator.verifyFormData(driver, RequestInformationLetter, "Dear John Richards");
		PdfComparator.verifyFormData(driver, RequestInformationLetter, "Insured Location: 1163 Oak Bluff DR");
		wait(10);

	}
}