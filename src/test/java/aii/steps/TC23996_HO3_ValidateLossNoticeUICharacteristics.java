package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC23996_HO3_ValidateLossNoticeUICharacteristics extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String lossNum;
	static String claimNum;

	@When("User enters all required information on policy information screen <tc23996>")
	public void user_enters_all_required_information_on_policy_information_screen_tc23996() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters HO3 product selection information and current date as effective date <tc23996>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_tc23996() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <tc23996>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc23996() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		// click(dwellingChevron.btnSave);
		// waitImp(5);
		getInsuranceScore(driver, "Neutral");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO3 dwelling screen and add deductible windhail <tc23996>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc23996() {

		sendText(dwellingChevron.txtSquareFeet, "1500");
		//selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		//selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2022");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$15,000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		waitImp(3);
	}

	@When("User completes required information on dwelling chevron and updates dwelling type <tc23996>")
	public void user_completes_required_information_on_dwelling_chevron_tc23996() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <tc23996>")
	public void User_clicks_Finalize_button_tc23996() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc23996>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc23996()
			throws Exception {
		waitImp(5);
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

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User changes system date to current date plus 10 days <tc23996>")
	public void User_changes_system_date_to_current_date_plus_10_days_tc23996() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate.plusDays(10)));
	}

	@When("User searches for the policy number <tc23996>")
	public void user_searches_policy_for_tc23996() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates 'Loss Type' 'Loss Date' texts are visible and gets loss type of populated value")
	public void user_validates_loss_type_loss_date_texts_are_visible() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Loss Type*");
		verify_AnyfirstText_IsDisplayed(driver, "Loss Date*");
		getLossTypePopulatedValue(driver);
		attachScreenShot(driver);
	}

	@When("User sets loss date as current date plus 10 days <tc23996>")
	public void user_sets_loss_date_as_currentdate_plus10days_tc23996() {
		sendText(claim.txtLossDate, dtf.format(currentDate.plusDays(10)));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User validates Loss Notice Info Tile UI Labels")
	public void user_validates_Loss_Notice_Info_Tile_UI_Labels() throws Exception {

		verify_AnyfirstText_IsDisplayed(driver, "Loss Notice Information");
		verify_AnyfirstText_IsDisplayed(driver, "Insured Contact Information");
		verify_AnyfirstText_IsDisplayed(driver, "Property Information");

		// Verifying fields on Loss Notice Information tile
		verify_AnyfirstText_IsDisplayed(driver, "Loss Date*");
		verify_AnyfirstText_IsDisplayed(driver, "Reported Date*");
		verify_AnyfirstText_IsDisplayed(driver, "Reported By*");
		verifyAnyDropdownDefaultedValue(driver, "Claim.ReportedBy", "Insured");
		verifyAnyDropdownDefaultedValue(driver, "Claim.LossCauseCd", "Select...");
		verify_AnyfirstText_IsDisplayed(driver, "Loss Cause*");
		verify_AnyfirstText_IsDisplayed(driver, "Loss Time");
		verify_AnyfirstText_IsDisplayed(driver, "Reported Time*");
		verify_AnyfirstText_IsDisplayed(driver, "Causation Claim");
		verify_AnyfirstText_IsDisplayed(driver, "Hartford Steam Boiler/HSP");
		verify_AnyfirstText_IsDisplayed(driver, "Inspection Needed");
		verify_AnyfirstText_IsDisplayed(driver, "Estimating Source");
		verify_AnyfirstText_IsDisplayed(driver, "Party Preventing Inspection");
		verifyAnyDropdownDefaultedValue(driver, "Claim.PartyPreventingInspection", "Select...");
		verify_AnyfirstText_IsDisplayed(driver, "AOB Involved?");
		verify_AnyfirstText_IsDisplayed(driver, "Trenching");
		verify_AnyfirstText_IsDisplayed(driver, "Loss Cause*");
		verify_AnyfirstText_IsDisplayed(driver, "Is your home habitable?*");
		verify_AnyfirstText_IsDisplayed(driver, "Which authority was contacted?*");
		verify_AnyfirstText_IsDisplayed(driver, "Weather-related?*");
		verify_AnyfirstText_IsDisplayed(driver, "Wind/Hail Coverage?*");
		verify_AnyfirstText_IsDisplayed(driver, "Detailed Description*");
		verify_AnyfirstText_IsDisplayed(driver, "Comments");
		verify_AnyfirstText_IsDisplayed(driver, "Examiner");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQHomeHabitable", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.AuthorityContacted", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.WeatherRelatedInd", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.WindCoverage", "No");

		String[] inspection = { "Select...", "No", "Yes" };
		verifyAnyDropDownOptions(driver, inspection, "Claim.InspectionInd");
		getAnyDropDownOptionsOnLossNotice(driver, "InspectionInd");
		selectDropdownText(driver.findElement(By.id("Claim.InspectionInd")), "Yes");
		verify_AnyfirstText_IsDisplayed(driver, "Estimating Source");
		verify_AnyfirstText_IsDisplayed(driver, "Inspection Date");
		verify_AnyfirstText_IsDisplayed(driver, "Date when Inspection was offered");
		verify_AnyfirstText_IsDisplayed(driver, "Party Preventing Inspection");

		selectDropdownText(driver.findElement(By.id("Claim.InspectionInd")), "No");
		verify_AnyText_NotVisible(driver, "Inspection Date");
		verify_AnyText_NotVisible(driver, "Date when Inspection was offered");

		String[] reportedBy = { "Insured", "Insured/Contractor", "Agent", "Public Adjuster", "Attorney", "Other" };
		verifyAnyDropDownOptions(driver, reportedBy, "Claim.ReportedBy");

		selectDropdownText(driver.findElement(By.id("Claim.ReportedBy")), "Insured/Contractor");
		Thread.sleep(1000);
		verify_AnyText_IsVisible(driver, "Contractor Name*");

		selectDropdownText(driver.findElement(By.id("Claim.ReportedBy")), "Insured");

		String[] authority = { "Select...", "None", "Sheriff's Office", "Police Department", "Fire Department",
				"Other" };
		verifyAnyDropDownOptions(driver, authority, "Claim.AuthorityContacted");
	}

	@When("User validates all expected Loss Cause dropdown options")
	public void user_validates_all_expected_Loss_cause_dd_options() throws Exception {
		String[] lossCauses = { "Select...", "Catastrophic Ground Cover Collapse (CGCC)", "Collapse",
				"Cracking/Rupture", "Deposit Recovery-Special Event", "Explosion", "Falling Objects", "Fire", "Flood",
				"Freezing", "Hail", "Home Cyber Protection", "ID Recovery", "Lightning", "Mysterious Disappearance",
				"Sinkhole", "Smoke", "Theft", "Vandalism and Malicious Mischief", "Vehicle(s)", "Water Damage",
				"Windstorm", "All Other Property", "Liability BI - Non-Pollution", "Liability BI - Pollution",
				"Liability PD - Non-Pollution", "Liability PD - Pollution", "Medical Payments" };
		verifyAnyDropDownOptions(driver, lossCauses, "Claim.LossCauseCd");
	}

	@When("User selects Catastrophic Ground Cover Collapse and validates following fields")
	public void user_selects_Catastrophic_Ground_Cover_Collapse_and_validates_following_fields() throws Exception {

		selectDropdownText(claim.ddLossCause, "Catastrophic Ground Cover Collapse (CGCC)");
		Thread.sleep(500);
		verify_AnyfirstText_IsDisplayed(driver, "Is there any damage to your dwelling?*");
		verify_AnyfirstText_IsDisplayed(driver, "Is there any other damage to the property? (i.e. driveway, yard, etc...)*");
		verify_AnyfirstText_IsDisplayed(driver, "Is there any significant cracking?*");

		verifyAnyDropdownDefaultedValue(driver, "Claim.CQCGCCDwellingDmg", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQCGCCPropertyDmg", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQCGCCCracking", "Select...");
	}

	@When("User selects Fire as loss cause and validates following fields")
	public void user_selects_fire_as_loss_cause_and_validates_following_fields() throws Exception {

		selectDropdownText(claim.ddLossCause, "Fire");
		Thread.sleep(500);
		verify_AnyfirstText_IsDisplayed(driver, "What is the estimated amount of damage to your home?*");
		verify_AnyfirstText_IsDisplayed(driver, "If known, where did the fire originate?");

		getanyDropDownPopulatedValueOnLossNotice(driver, "CQFireRoomsAffected");
		getanyDropDownPopulatedValueOnLossNotice(driver, "AuthorityContacted");
	}

	@When("User selects Water Damage as loss cause and validates following fields")
	public void user_selects_water_damage_as_loss_cause_and_validates_following_fields() throws Exception {

		selectDropdownText(claim.ddLossCause, "Water Damage");
		Thread.sleep(500);
		verify_AnyfirstText_IsDisplayed(driver, "Sub Loss Cause*");
		verify_AnyfirstText_IsDisplayed(driver, "Is your home habitable?*");
		verify_AnyfirstText_IsDisplayed(driver, "Was the source of water identified?*");
		verify_AnyfirstText_IsDisplayed(driver, "Was the source stopped?*");
		verify_AnyfirstText_IsDisplayed(driver, "Is there standing water in the home?*");
		verify_AnyfirstText_IsDisplayed(driver, "Is there mold present?*");
		verify_AnyfirstText_IsDisplayed(driver, "What is the estimated amount of damage to your home?*");
		verify_AnyfirstText_IsDisplayed(driver, "Which authority was contacted?*");

		verifyAnyDropdownDefaultedValue(driver, "Claim.SubLossCauseCd", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWaterSourceIdentified", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWaterSourceStopped", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWaterStanding", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWaterMold", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWaterRoomsDamaged", "Select...");
	}

	@When("User selects Windstorm as loss cause and validates following fields")
	public void user_selects_windstorm_as_loss_cause_and_validates_following_fields() throws Exception {

		selectDropdownText(claim.ddLossCause, "Windstorm");
		Thread.sleep(500);
		verify_AnyfirstText_IsDisplayed(driver, "Sub Loss Cause*");
		verify_AnyfirstText_IsDisplayed(driver, "Is your home habitable?*");
		verify_AnyfirstText_IsDisplayed(driver, "Please indicate which part of your home was damaged?*");
		verify_AnyfirstText_IsDisplayed(driver,
				"Is there a tree on any covered structure or blocking access to your property?*");
		verify_AnyfirstText_IsDisplayed(driver, "Do you require any board up or tarping?*");
		verify_AnyfirstText_IsDisplayed(driver, "Is there any interior water damage?*");

		verifyAnyDropdownDefaultedValue(driver, "Claim.SubLossCauseCd", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWindHomeDamaged", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWindTreeBlocking", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWindBoardTarping", "Select...");
		verifyAnyDropdownDefaultedValue(driver, "Claim.CQWindInteriorDamage", "Select...");
	}

	@When("User selects Sub Loss Cause and selects if roof damaged approx amount selection and do validations")
	public void user_selects_Sub_Loss_cause_and_selects_if_roof_damaged_approx_amount_selection_and_do_validations()
			throws Exception {
		selectDropdownText(claim.ddSubLossCause, "All Other Windstorm");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Claim.CQWindHomeDamaged")), "Roof");
		verify_AnyfirstText_IsDisplayed(driver, "Please estimate the amount of roof damage.*");
		verify_AnyfirstText_IsDisplayed(driver, "What is the approximate age of your roof?*");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User selects Roof damaged amount as unknown and do validations")
	public void user_selects_roof_damaged_amount_as_unknown_and_do_validations() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(driver.findElement(By.id("Claim.CQWindHomeDamaged")), "Unknown");
		//selectDropdownText(driver.findElement(By.id("Claim.CQWindRoofAge")), "0-14 years");
		selectDropdownText(driver.findElement(By.id("Claim.CQWindTreeBlocking")), "No");
		selectDropdownText(driver.findElement(By.id("Claim.CQWindBoardTarping")), "Unknown");
		selectDropdownText(driver.findElement(By.id("Claim.CQWindInteriorDamage")), "Yes");
		verify_AnyfirstText_IsDisplayed(driver,
				"What is the estimated amount of damage to your home from Interior Water Damage?*");
		selectDropdownText(driver.findElement(By.id("Claim.CQWindRoomsDamaged")), "50%-75%");
		selectDropdownText(claim.ddAuthorityContacted, "Police Department");
		verify_AnyfirstText_IsDisplayed(driver, "Authority Name");
		verify_AnyfirstText_IsDisplayed(driver, "Case Number");
		sendText(driver.findElement(By.id("Claim.AuthorityName")), "Officer");
		sendText(driver.findElement(By.id("Claim.CaseNumber")), "WindCase014");
		wait(1);
		sendText(claim.txtClaimDescription, "LN UI verification");
	}

	@When("User selects Examiner and do validations")
	public void user_selects_examiner_and_do_validations() throws Exception {
		clickAnyMagnifierIcon(driver, "ExaminerProviderNumber");
		switchToWindow(driver, "COProviderSearchPage");
		wait(1);
		selectDropdownText(userLookup.ddFilterType, "Contains");
		sendText(userLookup.txtSearchName, "Bennett");
		clickOnAnyLink(driver, "Search");
		wait(4);
		attachScreenShot(driver);
		clickOnAnyLink(driver, "Sarah Bennett");
		wait(2);
		driver.switchTo().window(mainWindow);
		Hooks.scenario.log("Switched to Main window");
		verify_AnyText_IsVisible(driver, "Sarah Bennett");

		// Verify fields on Insured Information Tile
		verify_AnyfirstText_IsDisplayed(driver, "Mailing Address");
		verify_AnyfirstText_IsDisplayed(driver, "Address*");
		verify_AnyfirstText_IsDisplayed(driver, "City*");
		verify_AnyfirstText_IsDisplayed(driver, "State*");
		verify_AnyfirstText_IsDisplayed(driver, "Zip*");
		verify_AnyfirstText_IsDisplayed(driver, "Country*");
		verify_AnyfirstText_IsDisplayed(driver, "Contact");
		verify_AnyfirstText_IsDisplayed(driver, "Primary Phone*");
		verify_AnyfirstText_IsDisplayed(driver, "Secondary Phone");
		verify_AnyfirstText_IsDisplayed(driver, "Best Time to Contact");

		// Verify fields on Property Information tile
		verify_AnyfirstText_IsDisplayed(driver, "Loss Location*");
		verify_AnyfirstText_IsDisplayed(driver, "Address/Description*");
		verify_JointLabels_IsDisplayed(driver, "City*");
		verify_JointLabels_IsDisplayed(driver, "State*");
		verify_AnyfirstText_IsDisplayed(driver, "County*");
		verify_AnyfirstText_IsDisplayed(driver, "Zip");
		verify_AnyfirstText_IsDisplayed(driver, "Damaged?");
		verifyAnyDropdownDefaultedValue(driver, "Claim.DamagedInd", "Select...");
	}

	@When("User selects Vehicle Location as Unscheduled Location and do validations")
	public void user_selects_Vehicle_Location_as_Unscheduled_Location_and_do_validations() throws Exception {
		selectDropdownText(driver.findElement(By.id("Claim.RiskIdRef")), "Unscheduled Location");
		verify_AnyfirstText_IsDisplayed(driver, "Description*");
		verify_JointLabels_IsDisplayed(driver, "City*");
		verify_JointLabels_IsDisplayed(driver, "State*");
		verify_AnyfirstText_IsDisplayed(driver, "Zip");
		verify_AnyfirstText_IsDisplayed(driver, "Damaged?");
		verifyAnyDropdownDefaultedValue(driver, "Claim.DamagedInd", "Select...");
		attachScreenShot(driver);
		selectDropdownText(driver.findElement(By.id("Claim.RiskIdRef")), "Primary Dwelling");
	}

	@When("User clicks save and takes note of the loss number <tc23996>")
	public void user_clicks_save_and_takes_note_of_the_loss_number_tc23996() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Complete and takes note of the claim number and validate expected messages <tc23996>")
	public void user_clicks_complete_takes_notes_tc23996() throws Exception {
		
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verify_AnyfirstText_IsDisplayed(driver, "Loss Notice Complete");
		verify_AnyfirstText_IsDisplayed(driver, "Start Claim");
		verify_AnyfirstText_IsDisplayed(driver, "View Loss Notice");
		attachScreenShot(driver);
	}

	@Then("User clicks View Loss Notice and validates expected information is visible")
	public void user_clicks_view_loss_notice_link_and_validates_expected_information_is_visible() throws Exception {
		click(driver.findElement(By.id("ViewLossNotice")));
		verify_AnyfirstText_IsDisplayed(driver, "Loss Notice Information");
		click(claim.btnComplete);
		wait(5);
		verify_AnyfirstText_IsDisplayed(driver, "Loss Notice Complete");
		Hooks.scenario.log("Test Case Completed!");
	}
}
