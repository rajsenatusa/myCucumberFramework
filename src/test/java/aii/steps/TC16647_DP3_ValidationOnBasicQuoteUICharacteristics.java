package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16647_DP3_ValidationOnBasicQuoteUICharacteristics extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User searches Agent <Ag1730> tc16647")
	public void user_searches_agent_AG1730_tc16647() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG1730");
		wait(1);
	}

	@When("User sets Question Matching Limit and Question Unusual Liability as Yes")
	public void user_sets_Question_Matching_Limit_and_Question_Unusual_Liability_As_YEs() {
		sendText(userLookup.txtQuestionMatchingLimit, "Yes");
		sendText(userLookup.txtQuestionUnusualLiability, "Yes");
		wait(1);
	}

	@When("User enters all required information on policy information screen <tc16647>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16647() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
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

	@When("User enters DP3 product selection information and effective date as current date and do UI validations <tc16647>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_and_do_UI_validations_tc16647()
			throws Exception {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		verify_AnyfirstText_IsDisplayed(driver, "Voluntary Dwelling Property 3 (DP3)");
		click(product.btnProductSelectionDp3);
	}

	@When("User enters all required information on DP3 quote screen and do UI validations <tc16647>")
	public void user_enters_all_information_onQuote_screen_tc16647() throws Exception {
		// Quote Policy Chevron information was filled here
//		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
//		click(dwellingChevron.btnSave);
//		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "AG1730A1");
		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");

		// Verifying the following labels displayed on InsuredInformation tile
		verify_AnyLabel_IsVisible(driver, "Entity Type*");
		verify_AnyLabel_IsVisible(driver, "Primary Phone");
		verify_AnyLabel_IsVisible(driver, "Email");
		verify_AnyLabel_IsVisible(driver, "No Email");
		verify_AnyfirstText_IsDisplayed(driver, "Email");
		verify_AnyLabel_IsVisible(driver, "Lookup Address");
		verify_AnyLabel_IsVisible(driver, "Number*");
		verify_AnyLabel_IsVisible(driver, "Direction");
		verify_AnyLabel_IsVisible(driver, "Street*");
		verify_AnyLabel_IsVisible(driver, "Suffix");
		verify_AnyLabel_IsVisible(driver, "Post Dir");
		verify_AnyLabel_IsVisible(driver, "Type");
		verify_AnyLabel_IsVisible(driver, "Ignore Address Validation");
		verify_AnyLabel_IsVisible(driver, "City*");
		verify_AnyLabel_IsVisible(driver, "County*");
		verify_AnyLabel_IsVisible(driver, "Zip*");
		verify_AnyLabel_IsVisible(driver, "Construction Type*");
		verify_AnyLabel_IsVisible(driver, "Occupancy*");
		verify_AnyLabel_IsVisible(driver, "Months Occupied*");

		String entityType[] = { "Select...", "Individual", "Joint", "Trust", "Estate", "LLC", "Corporation" };
		verifyAnyDropDownOptions(driver, entityType, "Insured.EntityTypeCd");
		verify_AnyLabel_IsVisible(driver, "Has the owner moved from their primary address in the last 2 years?*");

		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);

		String constType[] = { "Select...", "Frame", "Masonry", "Masonry Veneer", "Superior" };
		verifyAnyDropDownOptions(driver, constType, "ConstructionCd");
		String occupancyOptions[] = { "Select...", "Owner Occupied", "Tenant Occupied", "Vacant" };
		verifyAnyDropDownOptions(driver, occupancyOptions, "OccupancyCd");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");

		verify_AnyfirstText_IsDisplayed(driver, "Months Occupied");

		String monthsOcc[] = { "0 to 3 Months", "4 to 8 Months", "9 to 12 Months" };
		verifyAnyDropDownOptions(driver, monthsOcc, "MonthsOccupied");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");

		verify_AnyfirstText_IsDisplayed(driver, "Lease Term");
		String leaseTerm[] = { "Monthly, rented a total of 5 times or less each year",
				"Monthly, rented a total of 6 times or more each year", "Annual" };
		verifyAnyDropDownOptions(driver, leaseTerm, "MonthsOccupied");
		String propManaged[] = { "Select...", "Yes", "No" };
		verifyAnyDropDownOptions(driver, propManaged, "PropertyManagedInd");
		String shortTerm[] = { "Select...", "Yes", "No" };
		verifyAnyDropDownOptions(driver, shortTerm, "ShortTermRental");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Vacant");

		verify_AnyText_NotVisible(driver, "Months Occupied");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen and do UI validations <tc16647>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_tc16647() throws Exception {

		// selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10
		// mi");

		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");

		verify_AnyLabel_IsVisible(driver, "Year of Construction*");
		verify_AnyLabel_IsVisible(driver, "Square Feet*");
		verify_AnyLabel_IsVisible(driver, "Building Code Effectiveness Grade*");
		verify_AnyLabel_IsVisible(driver, "Distance to Hydrant/Accredited Water Source*");
		verify_AnyLabel_IsVisible(driver, "Protection Class*");
		verify_AnyLabel_IsVisible(driver, "Distance To Coast*");
		verify_AnyLabel_IsVisible(driver, "Territory Description");
		verify_AnyLabel_IsVisible(driver, "Dwelling Type*");
		verify_AnyLabel_IsVisible(driver, "Number of Units Insured");
		verify_AnyLabel_IsVisible(driver, "Number of stories");
		verify_AnyLabel_IsVisible(driver, "Roof Material*");
		verify_AnyLabel_IsVisible(driver, "Year Roof Material Completely Updated");

		// Verify following dropdown values
		String distToFire[] = { "Select...", "<= 1,000 Feet", "> 1,000 Feet" };
		verifyAnyDropDownOptions(driver, distToFire, "Building.DistToFireHydrant");
		getAnyDropDownOptions(driver, "DistToFireHydrant");
		attachScreenShot(driver);

		String protClass[] = { "Select...", "01", "02", "03", "04", "05", "06", "07", "08", "8B", "09", "10" };
		verifyAnyDropDownOptions(driver, protClass, "Building.ProtectionClass");
		getAnyDropDownOptions(driver, "ProtectionClass");
		attachScreenShot(driver);

		String dwellingType[] = { "Select...", "Single Family", "Duplex", "Triplex", "Quadplex", "Row/Town House",
				"Modular Home" };
		verifyAnyDropDownOptions(driver, dwellingType, "Building.DwellingType");
		getAnyDropDownOptions(driver, "DwellingType");
		attachScreenShot(driver);

		selectDropdownText(dwellingChevron.ddDwellingType, "Row/Town House");
		Thread.sleep(250);
		verify_AnyLabel_IsVisible(driver, "Number of Units Between Firewalls*");
		String NoOfStories[] = { "Select...", "1", "2", "3", "4 or more" };
		verifyAnyDropDownOptions(driver, NoOfStories, "Building.NumberOfStories");

		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		Thread.sleep(250);
		verify_AnyText_NotVisible(driver, "Number of Units Between Firewalls*");

		String roofmaterial[] = { "Select...", "3 Tab Composition Shingle", "Architectural Composition Shingle",
				"Metal", "Concrete/Clay Tile", "Asbestos Shingle", "Tin/Aluminum", "Wood Shingle", "Rolled/Bitumen",
				"Tar and Gravel", "Other" };
		verifyAnyDropDownOptions(driver, roofmaterial, "Building.RoofMaterial");

		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
	}

	@When("User validates fields on Replacement cost estimator tile")
	public void user_validateS_Fields_on_replacement_cost_estimator_tile() throws Exception {
		// Verify fields on Replacement cost estimator tile
		verify_AnyLabel_IsVisible(driver, "Quality Grade");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A");
		verify_AnyLabel_IsVisible(driver, "Recalculate");
		getAnyDropDownOptions(driver, "QualityGrade");

		selectDropdownText(dwellingChevron.ddQualityGrade, "Standard");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.rbWindHailExc);
	}

	@When("User validates hurricane deductible populated value")
	public void user_validateS_hurricane_deductible_populated_value() throws Exception {
		// validate hurricane deductible populated value
		try {
			Select entityType = new Select(driver.findElement(By.name("Building.HurricaneDeductible")));
			String hurDed = entityType.getFirstSelectedOption().getText().toString();

			if (hurDed.equals("Not Applicable")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("2%")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("$250")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("$500")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else {
				Hooks.scenario.log("HurricaneDeductible is neither Editable nor selected");
			}
		} catch (Exception e) {
			Hooks.scenario.log("HurricaneDeductible");
			wait(5);
		}

		click(dwellingChevron.rbWindHailExc);

		// validate hurricane deductible populated value
		try {
			Select entityType = new Select(driver.findElement(By.name("Building.HurricaneDeductible")));
			String hurDed = entityType.getFirstSelectedOption().getText().toString();

			if (hurDed.equals("Not Applicable")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("2%")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("$250")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else if (hurDed.equals("$500")) {
				Hooks.scenario.log("Hurricane deductible populated value: " + hurDed);
			} else {
				Hooks.scenario.log("HurricaneDeductible is neither Editable nor selected");
			}
		} catch (Exception e) {
			Hooks.scenario.log("HurricaneDeductible");
			wait(5);
		}
	}

	@When("User validates coverages and additional options and selections on UI")
	public void user_validates_coverages_and_additional_options_and_selections_on_UI() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$1,000");
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		click(dwellingChevron.btnSave);
		wait(3);
		// Verify the coverages
		verify_AnyLabel_IsVisible(driver, "Basic Policy");
		verify_AnyLabel_IsVisible(driver, "Integrity Select");

		click(dwellingChevron.rbIntegritySelectPackage);
		click(dwellingChevron.rbBasicPackage);

		// verify the following coverages disabled
		verifyAnyElement_Disabled(driver, "Building.RefrigeratedInd");
		verifyAnyElement_Disabled(driver, "Building.PersonalInjuryInd");
		verifyAnyElement_Disabled(driver, "Building.CovHCCLimit");
		verifyAnyElement_Disabled(driver, "Building.AnimalLiability");
		verifyAnyElement_Enabled(driver, "Building.CovWBULimit");

		// Verify all fields under Additional coverages
		verify_AnyLabel_IsVisible(driver, "Home Cyber Protection*");
		verify_AnyLabel_IsVisible(driver, "Home Computer*");
		verify_AnyLabel_IsVisible(driver, "Home Systems Protection and Service Line*");
		verify_AnyLabel_IsVisible(driver, "Limited Carport(s), Pool Cage(s) and Screen Enclosure(s)*");
		verify_AnyLabel_IsVisible(driver, "Limited Fungi, Mold, Wet or Dry Rot, or Bacteria*");
		verify_AnyLabel_IsVisible(driver, "Ordinance or Law*");
		verify_AnyLabel_IsVisible(driver, "Loss Assessment*");
		verify_AnyLabel_IsVisible(driver, "Identity Recovery*");
		verify_AnyLabel_IsVisible(driver, "Refrigerated Property");

		// Verify all fields under Additional Options
		verify_AnyLabel_IsVisible(driver, "Limited Theft");
		verify_AnyLabel_IsVisible(driver, "Sinkhole Loss");
		verify_AnyLabel_IsVisible(driver, "Loss Settlement*");
		verify_AnyLabel_IsVisible(driver, "Personal Property Replacement Cost");
		verify_AnyLabel_IsVisible(driver, "Water Damage Exclusion");
		verify_AnyLabel_IsVisible(driver, "Vacancy Endorsement");
		verify_AnyLabel_IsVisible(driver, "Water Damage Limited");
		verify_AnyLabel_IsVisible(driver, "Animal Liability");
		verify_AnyLabel_IsVisible(driver, "Personal Injury");
		verify_AnyLabel_IsVisible(driver, "Water Back Up and Sump Overflow*");

		click(dwellingChevron.rbIntegritySelectPackage);

		String C_PersonalProperty[] = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%",
				"65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		verifyAnyDropDownOptions(driver, C_PersonalProperty, "Building.CovCLimitIncluded");

		verifyAnyCoverageCheckbox_EnabledAndNotSelected(driver, "Refrigerated");
		verifyAnyCoverageCheckbox_EnabledAndNotSelected(driver, "PersonalInjury");

		// Home Computer coverage
		String Home_Computer[] = { "$2,500", "$3,000", "$4,000", "$5,000", "$6,000", "$7,000", "$8,000", "$9,000",
				"$10,000", "$11,000", "$12,000", "$13,000", "$14,000", "$15,000", "$16,000", "$17,000", "$18,000",
				"$19,000", "$20,000" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovHCCLimit", "$2,500");
		verifyAnyDropDownOptions(driver, Home_Computer, "Building.CovHCCLimit");

		// Animal Liability
		String Animal_Liability[] = { "None", "$50,000", "$100,000" };
		verifyAnyDropdownDefaultedValue(driver, "Building.AnimalLiability", "None");
		verifyAnyDropDownOptions(driver, Animal_Liability, "Building.AnimalLiability");

		// Water Back Up and Sump Overflow coverage
		String WBU[] = { "None", "$5,000" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovWBULimit", "None");
		verifyAnyDropDownOptions(driver, WBU, "Building.CovWBULimit");

		// Verify all fields under Discounts and Surcharges
		verify_AnyLabel_IsVisible(driver, "Fire Alarm*");
		verify_AnyLabel_IsVisible(driver, "Secured Community/Bldg*");
		verify_AnyLabel_IsVisible(driver, "Senior/Retiree");
		verify_AnyLabel_IsVisible(driver, "Water Loss Prevention Inspection Date");
		verify_AnyfirstText_IsDisplayed(driver, "Proof of Updates");
		verify_AnyLabel_IsVisible(driver, "Leak Detection*");
		verify_AnyLabel_IsVisible(driver, "Burglar Alarm*");
		verify_AnyLabel_IsVisible(driver, "Hardiplank Siding");
		verify_AnyLabel_IsVisible(driver, "Water Loss Prevention");
		verify_AnyLabel_IsVisible(driver, "Sprinkler System*");
		verify_AnyLabel_IsVisible(driver, "Open Foundation");
		verify_AnyLabel_IsVisible(driver, "Electronic Policy Distribution");

		// Verify all fields under Windstorm Mitigation Discount
		verify_AnyLabel_IsVisible(driver, "Roof Deck*");
		verify_AnyLabel_IsVisible(driver, "Opening Protection*");
		verify_AnyLabel_IsVisible(driver, "Roof Shape*");
		verify_AnyLabel_IsVisible(driver, "SWR*");
	}

	@When("User selects flood coverage as Yes and validates fields on UI")
	public void user_selects_flood_coverage_as_Yes_and_validates_fields_on_UI() throws Exception {
		// Select flood coverage = Yes and verify fields
		selectDropdownText(dwellingChevron.ddFloodCoverage, "Yes");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "A - Flood Dwelling");
		verify_AnyLabel_IsVisible(driver, "B - Flood Personal Property");
		verify_AnyLabel_IsVisible(driver, "Foundation Type*");
		verify_AnyLabel_IsVisible(driver, "Flood Zone Override*");
		verify_AnyLabel_IsVisible(driver, "Deductible*");
		verify_AnyLabel_IsVisible(driver, "Program Date Override");
		verify_AnyLabel_IsVisible(driver, "SFHA Override*");
		verify_AnyfirstText_IsDisplayed(driver, "Program Date");
		verify_AnyfirstText_IsDisplayed(driver, "Flood Zone");
		verify_AnyLabel_IsVisible(driver, "Special Flood Hazard Zone");
		verify_AnyLabel_IsVisible(driver, "Revised Date");
		verify_AnyLabel_IsVisible(driver, "Base Flood Elevation");
		verify_AnyLabel_IsVisible(driver, "Program Status");

		String foundationType[] = { "Select...", "Slab", "Elevated", "Basement" };
		verifyAnyDropDownOptions(driver, foundationType, "Building.FloodFoundationType");
		getAnyDropDownOptions(driver, "FloodFoundationType");

		String floodZone[] = { "Select...", "B", "C", "X", "A", "AE", "AH", "AO", "AR", "A1", "A2", "A3", "A4", "A5",
				"A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20",
				"A21", "A22", "A23", "A24", "A25", "A26", "A27", "A28", "A29", "A30", "A99", "D", "V", "VE", "V1", "V2",
				"V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "V11", "V12", "V13", "V14", "V15", "V16", "V17", "V18",
				"V19", "V20", "V21", "V22", "V23", "V24", "V25", "V26", "V27", "V28", "V29", "V30" };
		verifyAnyDropDownOptions(driver, floodZone, "Building.FloodZoneOverride");
		getAnyDropDownOptions(driver, "FloodZoneOverride");

		String SFHAOverride[] = { "Select...", "Yes", "No" };
		verifyAnyDropDownOptions(driver, SFHAOverride, "Building.FloodSFHAOverride");
		getAnyDropDownOptions(driver, "FloodSFHAOverride");

		String FloodCovADeductible[] = { "$500", "$1,000", "$1,250", "$1,500", "$2,000", "$2,500", "$5,000", "$7,500",
				"$10,000" };
		getAnyDropDownOptions(driver, "Building.FloodCovADed");
		verifyAnyDropDownOptions(driver, FloodCovADeductible, "Building.FloodCovADed");
		getAnyDropDownOptions(driver, "FloodCovADed");

		selectDropdownText(dwellingChevron.ddFloodCoverage, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.rbBasicPackage);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User validates coverage list tile on UI")
	public void user_validateS_coverage_list_tile_on_UI() throws Exception {

		// in force
		click(driver.findElement(By.id("Filter_Available"))); // unclick available
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "A - Dwelling");
		verify_AnyfirstText_IsDisplayed(driver, "B - Other Structures");
		verify_AnyfirstText_IsDisplayed(driver, "C - Personal Property");
		verify_AnyfirstText_IsDisplayed(driver, "E - Additional Living Expense");
		verify_AnyfirstText_IsDisplayed(driver, "Limited Fungi, Mold, Wet or Dry Rot, or Bacteria");

		click(driver.findElement(By.id("Filter_Available"))); // click available and observe both
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "A - Dwelling");
		verify_AnyfirstText_IsDisplayed(driver, "B - Other Structures");
		verify_AnyfirstText_IsDisplayed(driver, "C - Personal Property");
		verify_AnyfirstText_IsDisplayed(driver, "E - Additional Living Expense");
		verify_AnyfirstText_IsDisplayed(driver, "Limited Fungi, Mold, Wet or Dry Rot, or Bacteria");
		verify_AnyText_IsVisible(driver, "Permitted Incidental Occupancies");

		click(driver.findElement(By.id("Filter_InForce"))); // unclick in force just available clicked
		wait(1);
		verify_AnyText_IsVisible(driver, "Permitted Incidental Occupancies");
	}

	@Then("User enters all required information on DP3 review screen sets Order Insurance Score as Yes do validations with different pay plan selection")
	public void user_enters_all_required_information_on_dp3_review_screen_sets_order_insuranceScore_asYes_do_validations_with_different_pay_plan()
			throws Exception {

		click(dwellingChevron.btnNext);
		attachScreenShot(driver);
		selectDropdownText(reviewChevron.ddOrderInsScore, "Yes");
		verify_AnyfirstText_IsDisplayed(driver, "Order Insurance Score");
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");

		// Verify PayPlanType options
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "4 Pay Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Quarterly Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Semi-Annual Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Full Payment Plan");
		verify_AnyLabel_IsVisible(driver, "8 Pay Payment Plan");

		selectDropdownText(reviewChevron.ddPayPlan, "Mortgagee Bill");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Mortgagee Full Pay Payment Plan");

		selectDropdownText(reviewChevron.ddPayPlan, "Automated ACH");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Monthly Payment Plan");
		verify_AnyLabel_IsVisible(driver, "4 Pay Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Quarterly Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Semi-Annual Payment Plan");
		verify_AnyLabel_IsVisible(driver, "8 Pay Payment Plan");

		selectDropdownText(reviewChevron.ddPayPlan, "Automated Credit Card");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Monthly Payment Plan");
		verify_AnyLabel_IsVisible(driver, "4 Pay Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Quarterly Payment Plan");
		verify_AnyLabel_IsVisible(driver, "Semi-Annual Payment Plan");
		verify_AnyLabel_IsVisible(driver, "8 Pay Payment Plan");

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		Hooks.scenario.log("TEST Case Completed!");
	}
}
