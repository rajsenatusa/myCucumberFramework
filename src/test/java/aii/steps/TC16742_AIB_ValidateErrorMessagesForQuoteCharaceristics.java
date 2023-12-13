package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16742_AIB_ValidateErrorMessagesForQuoteCharaceristics extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime expirationDate = currentDate.plusDays(40);
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <tc16742>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16742() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, dtf.format(currentDate.minusYears(20)));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "16 S Kyle Way, Marathon");
		sendText(quote.txtZipCode, "33050");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on AIB quote screen for <tc16742>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc16742() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(expirationDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Better (800-899)");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		//click(policyChevron.btnNext);
		//wait(3);
	}
	@When("User validates 'County is closed for new business' text is visible")
	public void user_validates_County_is_closed_for_new_business_text_is_visible() throws Exception {

		verify_AnyfirstText_IsDisplayed(driver, "County is closed for new business");
		attachScreenShot(driver);
	}
	@When("User changes ineligible address with eligible address")
	public void user_changes_ineligible_address_with_eligible_address() throws Exception {

		setAddress(driver, "1165", "Peperidge", "32504");
		click(driver.findElement(By.id("InsuredResidentAddr.addrVerifyImg")));
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, "AMICA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "No");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "No");
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
		verify_AnyText_IsVisible(driver, "Coverage Type must be selected.");
	}
	@When("User selects Combined Single Limit liability coverage on quote screen for <tc16742>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc16742() throws Exception {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(6);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$100,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "No Coverage");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "None");
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "No Coverage");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);	
		
		verify_AnyLabel_IsVisible(driver, "Hull Coverages should be added on the Boat screen.");
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "Insurance Score must be requested or declined prior to Create Application");				
		click(dwellingChevron.btnNext);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User adds operator information on quote screen <tc16742>")
	public void user_adds_operator_information_on_quote_screen_tc16742() throws Exception {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "B6503ABC97150");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(1);
		click(dwellingChevron.btnNext);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "At least one boat is required");
	}
	@When("User enters all required information with negative scenario inputs on AIB boat dwelling screen and validates expected error messages <tc16742>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc16742() throws Exception {
		click(driver.findElement(By.id("Wizard_Vehicles")));
		wait(3);
		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "1994");
		sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		sendText(aibChevron.txtBoatModel, "Boat Model");
		sendText(aibChevron.txtBoatPurchDate, "05/06/1995");
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, "205000");
		selectDropdownText(aibChevron.ddBoatHullType, "Trawler");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "31 or more");
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, "Outboard");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "61 or more mph");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Actual Cash Value");
		selectDropdownText(aibChevron.ddHullDeductible, "$1,000");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "1994");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(aibChevron.txtEngine1Model, "Engine");
		sendText(aibChevron.txtEngineSerialNum, "456WSXD677G");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Dock Slip");
		selectDropdownText(aibChevron.ddBoatStorageLocation, "Marina");
		sendText(aibChevron.txtStorageAddress, "3138 SW 14th St");
		sendText(aibChevron.txtStorageZip, "33312");
		driver.findElement(By.id("VehicleGarageAddr.addrVerifyImg")).click();
		wait(3);
		selectDropdownText(aibChevron.ddBahamasCoverage, "Yes");
		wait(1);
		selectDropdownText(aibChevron.ddBahamasNavigation, "No");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "Yes");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		verify_AnyText_IsVisible(driver, "Primary operator of the boat must be 21 years or older. ");
		verify_AnyText_IsVisible(driver, "Coverage for this hull type is not eligible for this program. ");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval.  ");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.  ");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval.  ");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval.  ");
		
//		click(dwellingChevron.btnNext);
//		wait(3);
//		click(reviewChevron.btnReview);
//		wait(3);
	}
	@When("User changes hull type, storage location and validates expected error messages")
	public void user_changes_hull_type_storage_location_and_validates_expected_error_messages() throws Exception {
		click(driver.findElement(By.id("Wizard_Vehicles")));
		wait(2);
		click(driver.findElement(By.id("Navigate_VehicleList_1")));
		wait(3);
		selectDropdownText(aibChevron.ddBoatHullType, "Houseboat");
		selectDropdownText(aibChevron.ddBoatDriveSystem, "None");
		sendText(aibChevron.txtStorageAddress, "13 SW 37th PL");
		sendText(aibChevron.txtStorageZip, "33991");
		driver.findElement(By.id("VehicleGarageAddr.addrVerifyImg")).click();
		wait(6);
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		verify_AnyText_IsVisible(driver, "Primary operator of the boat must be 21 years or older");
		verify_AnyText_IsVisible(driver, "Coverage for this hull type is not eligible for this program");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval" );
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
	}
	@When("User adds second boat with negative inputs and validates expected error messages")
	public void user_adds_second_boat_with_negative_inputs_and_validates_expected_error_messages_tc16742() throws Exception {
		click(driver.findElement(By.id("Wizard_Vehicles")));
		wait(2);
		click(driver.findElement(By.id("Navigate_VehicleList_1")));
		wait(3);
		click(aibChevron.btnNewBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "1965");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		//sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		sendText(aibChevron.txtBoatModel, "Second Boat");
		sendText(aibChevron.txtBoatPurchDate, "05/06/1965");
		sendText(aibChevron.txtBoatPurchPrice, "105000");
		sendText(aibChevron.txtPresentValue, "106000");
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		selectDropdownText(aibChevron.ddBoatHullType, "Airboat");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "26");
		selectDropdownText(aibChevron.ddBoatDriveSystem, "None");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "60 or less mph");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Trailer");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		sendText(aibChevron.txtPresentValue, "110,000");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		verify_AnyText_IsVisible(driver, "Primary operator of the boat must be 21 years or older");
		verify_AnyText_IsVisible(driver, "Coverage for this hull type is not eligible for this program");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
		
		//Select Hull type = Cruiser and save
		click(driver.findElement(By.id("Wizard_Vehicles")));
		click(driver.findElement(By.id("Navigate_VehicleList_2")));
		wait(3);
		selectDropdownText(aibChevron.ddBoatHullType, "Cruiser");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		
		//Click Boat 1 hypelink
		click(driver.findElement(By.id("Wizard_Vehicles")));
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		clickonAnyButton(driver, "EditLink_1");
		wait(1);
		selectDropdownText(aibChevron.ddBoatHullType, "Bass Boat");
		wait(1);
		selectDropdownText(aibChevron.ddNavigateCoastalWaters, "Yes");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Primary operator of the boat must be 21 years or older");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
	}
	@When("User adds operator for second boat and validates expected issue messages")
	public void user_adds_operator_for_second_boat_and_validates_expected_issue_messages() throws Exception {
		clickonAnyButton(driver, "Wizard_Operators");
		click(aibChevron.btnAddOperator);
		wait(3);
		sendText(driver.findElement(By.id("NameInfo.GivenName")), "Chuck");
		sendText(driver.findElement(By.id("NameInfo.Surname")), "Berry");
		selectDropdownText(driver.findElement(By.id("DriverInfo.RelationshipToInsuredCd")), "Father");
		sendText(driver.findElement(By.id("PersonInfo.BirthDt")), "06/10/1965");
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");	
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "B500772674080");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(1);
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Primary operator of the boat must be 21 years or older");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
	}
	@When("User clicks first boat link and select primary operator")
	public void user_clicks_first_boat_link_and_select_primary_operator() throws Exception {
		clickonAnyButton(driver, "Wizard_Vehicles");
		wait(1);
		clickonAnyButton(driver, "EditLink_1");
		wait(2);
		selectDropdownText(driver.findElement(By.id("Vehicle.PrimaryOperator")), "Berry, Chuck");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User clicks second boat link and select primary operator and validates expected issue messages")
	public void user_clicks_second_boat_link_and_select_primary_operator_and_validates_messages() throws Exception {
		click(driver.findElement(By.id("Wizard_Vehicles")));
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(2);
		clickonAnyButton(driver, "EditLink_2");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Vehicle.PrimaryOperator")), "Berry, Chuck");
		click(driver.findElement(By.id("MoreActionsDropdownButton")));
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
	}
	@And("User completes required information on add additional interests screen and adding first mortgagee and validates expected error messages <tc16742>")
	public void User_completes_required_information_on_add_first_mortgagee_tc16742() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10006");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Additional Owner");
		wait(4);
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_0")).click();   //click boat interest
		driver.findElement(By.name("LinkReferenceInclude_1")).click();   //click interest 2
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");	
	}
	@And("User adds additional interest for 3 more times and validates expected issue messages")
	public void User_adds_additional_interest_for_3_more_times_and_validates_expected_issue_messages() throws Exception {
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10002");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Additional Owner");
		wait(4);
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_0")).click();   //click boat interest
		driver.findElement(By.name("LinkReferenceInclude_1")).click();   //click interest 2
		click(dwellingChevron.btnSave);
		wait(3);
		
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10003");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Additional Owner");
		wait(4);
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_0")).click();   //click boat interest
		driver.findElement(By.name("LinkReferenceInclude_1")).click();   //click interest 2
		click(dwellingChevron.btnSave);
		wait(3);
		
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10004");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Additional Owner");
		wait(4);
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_0")).click();   //click boat interest
		driver.findElement(By.name("LinkReferenceInclude_1")).click();   //click interest 2
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
		click(reviewChevron.btnReview);
		wait(3);
	}
	@Then("User enters all required information on AIB review screen validates expected error messages and completes test <tc16742>")
	public void user_enters_all_required_information_on_aib_review_screen_and_completes_test_tc16742() throws Exception {

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "Yes");
		wait(3);
		driver.findElement(By.id("InsuranceScoreOrder")).click();
		wait(1);
		clickInsuranceDialog(driver, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnPolicyChevronLink);
		
		wait(3);
		verify_AnyText_IsVisible(driver, "Bass boat navigated in coastal waters is not eligible for coverage");
		verify_AnyText_IsVisible(driver, "Boat with any existing damage requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Bahamas coverage is not available for boats that do not have a non-detachable satellite navigation system.");
		verify_AnyText_IsVisible(driver, "Present Value greater than Purchase Price requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats 61 mph or faster require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Boat Length which exceeds a maximum of 27 - 30 requires underwriting review|Value of Boat Maximum which exceeds a maximum of $200,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Boats age 26 or older require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Boats over 50 years are not eligible");
		verify_AnyText_IsVisible(driver, "Agreed Hull Value requires Underwriting approval");
		Hooks.scenario.log("Test Case Completed!");
	}
}
