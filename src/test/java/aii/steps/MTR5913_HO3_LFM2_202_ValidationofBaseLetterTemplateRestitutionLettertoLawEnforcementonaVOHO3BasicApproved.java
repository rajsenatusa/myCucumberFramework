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

public class MTR5913_HO3_LFM2_202_ValidationofBaseLetterTemplateRestitutionLettertoLawEnforcementonaVOHO3BasicApproved
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	static String RestitutionLawEnf_Letter;
	static String RestitutionLawEnfLetter;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on policy information screen <mtr5913>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5913() {

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

	@When("User enters all required information on HO3 quote screen <mtr5913>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr5913() {
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

	@When("User enters all required information on HO3 dwelling screen <mtr5913>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5913() {
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

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5913>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr5207()
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

	@When("User Searchs for Policy Number <mtr5913>")
	public void User_searches_for_Policy_Number_mtr5913() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets Loss Date as current date")
	public void User_sets_Loss_Date_as__current_date() {
		sendText(driver.findElement(By.id("Claim.LossDt")), dtf.format(currentDate));
		click(claim.btnSave);
	}

	@When("User enters all required Loss Notice Information for Hail")
	public void User_enters_all_required_Loss_Notice_Information_for_Hail() {
		wait(1);
		selectDropdownText(lossNoticeInfo.lstLossCause, "Hail");
		wait(1);
		selectDropdownText(lossNoticeInfo.lstCQHomeHabitable, "Yes");
		selectDropdownText(lossNoticeInfo.hailHomeDamaged, "Fence");
		selectDropdownText(lossNoticeInfo.hailSoftMetalDmg, "Yes");
		selectDropdownText(lossNoticeInfo.lstAuthorityContacted, "Sheriff's Office");
		sendText(lossNoticeInfo.lstAuthorityName, "Sheriff Mike");
		sendText(lossNoticeInfo.lstCaseNumber, "12345");
		sendText(lossNoticeInfo.claimDescription, "Test");
		selectDropdownText(lossNoticeInfo.claimDamagedInd, "Yes");

	}

	@When("User clicks Complete button")
	public void User_clicks_Complete_button() {
		wait(1);
		click(lossNoticeInfo.complete);
		wait(1);
	}

	@Then("User verifies the loss location is set to insured location")
	public void User_verifies_the_loss_location_is_set_to_insured_location() throws Exception {
		wait(1);
		click(claim.claimInformation);
		scrollToElement(claim.txtClaimLossDesc);
		verify_AnyfirstText_IsDisplayed(driver, "1163 Oak Bluff DR");
		Hooks.scenario.log("Property address displays successfully!");
		wait(1);
	}

	@Then("User verifies the Authority information")
	public void User_verifies_the_Authority_information() throws Exception {
		wait(3);
		click(claim.claimInformation);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Sheriff's Office	Authority Name	Sheriff Mike	Case Number	12345");
		Hooks.scenario.log("Authority information displays successfully!");
		wait(1);
	}

	@When("User clicks Correspondence")
	public void User_clicks_Correspondence() {
		wait(1);
		click(correspondance.correspondence);
		wait(1);
	}

	@When("User selecks Correspondence Form as 'Restitution Letter to Law Enforcement'")
	public void User_selecks_Correspondence_Form_as_Restitution_Letter_to_Law_Enforcement() throws Exception {
		wait(1);
		selectDropdownText(correspondance.ddSelectCorrespondance, "Interactive - Restitution Law Enforcement Letter");
		wait(4);
		click(correspondance.btnAdd);
		wait(5);

	}

	@Then("User verifies the fields can Edit and Enter")
	public void User_verifies_the_fields_can_EditEnter() throws Exception {
		scrollToElement(correspondance.outputItem1Description);
		wait(1);
		Hooks.scenario.log("The fields can Edit/Enter successfully!");
		attachScreenShot(driver);
		wait(1);

	}

	@When("Use enters Assigned Adjuster as Shannan Triplett")
	public void Use_enters_Assigned_Adjuster_as_Shannan_Triplett() {
		click(claim.wizardOverview);
		wait(1);
		click(claim.moreActionsDropdownButton);
		wait(1);
		click(claim.btnStartTransaction);
		wait(1);
		click(claim.navigateClaimantSync1);
		wait(1);
		sendText(claim.assignedAdjusterProviderNumber, "CA0ST1");
		wait(1);
		click(claim.save);
		click(claim.btnFinalize);
		wait(1);
		click(claim.btnProcess);
	}

	@When("User clicks Process Correspondence")
	public void User_clicks_Process_Correspondence() {
		wait(1);
		click(correspondance.btnProcessCorrespondence);
		wait(1);
	}

	@When("User clicks Claim File")
	public void User_clicks_Claim_File() {
		wait(1);
		click(claim.claimFile);
		wait(1);
	}

	@Then("User verifies 'Interactive Restitution Law Enforcement Letter' in Claim File")
	public void User_verifies_Interactive_Restitution_Law_Enforcement_Letter_in_Claim_File() throws Exception {
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Restitution Law Enforcement Letter");
		Hooks.scenario.log("Restitution Law Enforcement Letter displays successfully!");
		wait(1);

	}

	@When("User clicks on 'Interactive Restitution Law Enforcement Letter'")
	public void User_clicks_on_Interactive_Restitution_Law_Enforcement_Letter() throws Exception {
		wait(1);
		clickOnAnyPolicyFileTabForm(driver, "Interactive - Restitution Law Enforcement Letter");
		wait(1);
	}
	
	@Then("User verifies 'Interactive Restitution Law Enforcement Letter' displays")
	public void User_verifies_Interactive_Restitution_Law_Enforcement_Letter_displays() throws Exception {
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Hooks.scenario.log("Restitution Law Enforcement Letter displays successfully!");
		attachScreenShot(driver);
		wait(1);		
		RestitutionLawEnf_Letter = PdfComparator.makePdf(driver, "Restitution_Law_Enforcement.pdf");
	
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RestitutionLawEnf_Letter);

		wait(20);
		RestitutionLawEnfLetter = SmartPDFComparator2.getPDFtextByArea(FileLocation + RestitutionLawEnf_Letter, 1, 0, 0, 800, 800);
		
		PdfComparator.verifyFormData(driver, RestitutionLawEnfLetter,
				"Cause of Loss: Hail");
		PdfComparator.verifyFormData(driver, RestitutionLawEnfLetter,
				"Dear Sheriff Mike");
		PdfComparator.verifyFormData(driver, RestitutionLawEnfLetter, "Insured Location: 1163 Oak Bluff DR");
		wait(10);
		
	
	
	

	}

}