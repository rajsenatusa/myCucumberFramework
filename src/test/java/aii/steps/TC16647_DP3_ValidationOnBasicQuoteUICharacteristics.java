package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class TC16647_DP3_ValidationOnBasicQuoteUICharacteristics extends CommonMethods{

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
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_and_do_UI_validations_tc16647() throws Exception {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		verify_AnyText_IsVisible(driver, "Voluntary Dwelling Property 3 (DP3)");
		click(product.btnProductSelectionDp3);
	}
	@When("User enters all required information on DP3 quote screen and do UI validations <tc16647>")
	public void user_enters_all_information_onQuote_screen_tc16647() throws Exception {
		// Quote Policy Chevron information was filled here
		
		verify_AnyText_IsVisible(driver, "AG1730A1");
		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		
		//Verifying the following labels displayed on InsuredInformation tile
		verify_AnyText_IsVisible(driver, "Entity Type*");
		verify_AnyText_IsVisible(driver, "Primary Phone");
		verify_AnyText_IsVisible(driver, "Email");
		verify_AnyText_IsVisible(driver, "No Email");
		verify_AnyfirstText_IsDisplayed(driver, "Email");
		verify_AnyText_IsVisible(driver, "Lookup Address");
		verify_AnyText_IsVisible(driver, "Number*");
		verify_AnyText_IsVisible(driver, "Direction");
		verify_AnyText_IsVisible(driver, "Street*");
		verify_AnyText_IsVisible(driver, "Suffix");
		verify_AnyText_IsVisible(driver, "Post Dir");
		verify_AnyText_IsVisible(driver, "Type");
		verify_AnyText_IsVisible(driver, "Ignore Address Validation");
		verify_AnyText_IsVisible(driver, "City*");
		verify_AnyText_IsVisible(driver, "County*");
		verify_AnyText_IsVisible(driver, "Zip*");
		verify_AnyText_IsVisible(driver, "Construction Type*");
		verify_AnyText_IsVisible(driver, "Occupancy*");
		verify_AnyText_IsVisible(driver, "Months Occupied*");
		
		String entityType[] = {"Select...","Individual","Joint","Trust","Estate","LLC","Corporation"};			
		verifyAnyDropDownOptions(driver, entityType,"Insured.EntityTypeCd");
		verify_AnyText_IsVisible(driver, "Has the owner moved from their primary address in the last 2 years?*");
		
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		
		String constType [] = {"Select...","Frame","Masonry","Masonry Veneer","Superior"};
		verifyAnyDropDownOptions(driver, constType,"ConstructionCd");
		String occupancyOptions [] = {"Select...","Owner Occupied","Tenant Occupied","Vacant"};
		verifyAnyDropDownOptions(driver, occupancyOptions,"OccupancyCd");
		
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		
		verify_AnyfirstText_IsDisplayed(driver, "Months Occupied");
		
		String monthsOcc[] = {"0 to 3 Months","4 to 8 Months","9 to 12 Months"};
		verifyAnyDropDownOptions(driver, monthsOcc,"MonthsOccupied");
		
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		
		verify_AnyfirstText_IsDisplayed(driver, "Lease Term");
		String leaseTerm[] = {"Monthly, rented a total of 5 times or less each year","Monthly, rented a total of 6 times or more each year","Annual"};
		verifyAnyDropDownOptions(driver, leaseTerm,"MonthsOccupied");
		String propManaged[] = {"Select...","Yes","No"};
		verifyAnyDropDownOptions(driver, propManaged,"PropertyManagedInd");
		String shortTerm[] = {"Select...","Yes","No"};
		verifyAnyDropDownOptions(driver, shortTerm,"ShortTermRental");
		
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
		
		verify_AnyText_IsVisible(driver, "Year of Construction*");
		verify_AnyText_IsVisible(driver, "Square Feet*");
		verify_AnyText_IsVisible(driver, "Building Code Effectiveness Grade*");			
		verify_AnyText_IsVisible(driver, "Distance to Hydrant/Accredited Water Source*");
		verify_AnyText_IsVisible(driver, "Protection Class*");
		verify_AnyText_IsVisible(driver, "Distance To Coast*");
		verify_AnyText_IsVisible(driver, "Territory Description");
		verify_AnyText_IsVisible(driver, "Dwelling Type*");
		verify_AnyText_IsVisible(driver, "Number of Units Insured");
		verify_AnyText_IsVisible(driver, "Number of stories");
		verify_AnyText_IsVisible(driver, "Roof Material*");			
		verify_AnyText_IsVisible(driver, "Year Roof Material Completely Updated");
		
		//Verify following dropdown values
		String distToFire [] = {"Select...","<= 1,000 Feet","> 1,000 Feet"};
		verifyAnyDropDownOptions(driver, distToFire,"Building.DistToFireHydrant");
		getAnyDropDownOptions(driver, "DistToFireHydrant");
		attachScreenShot(driver);
		
		String protClass [] = {"Select...","01","02","03","04","05","06","07","08","8B","09","10"};
		verifyAnyDropDownOptions(driver, protClass,"Building.ProtectionClass");
		getAnyDropDownOptions(driver, "ProtectionClass");
		attachScreenShot(driver);
		
		String dwellingType [] = {"Select...","Single Family","Duplex","Triplex","Quadplex","Row/Town House","Modular Home"};
		verifyAnyDropDownOptions(driver, dwellingType,"Building.DwellingType");
		getAnyDropDownOptions(driver, "DwellingType");
		attachScreenShot(driver);
		
		selectDropdownText(dwellingChevron.ddDwellingType, "Row/Town House");
		Thread.sleep(250);
		verify_AnyText_IsVisible(driver, "Number of Units Between Firewalls*");
		String NoOfStories [] = {"Select...","1","2","3","4 or more"};
		verifyAnyDropDownOptions(driver, NoOfStories,"Building.NumberOfStories");
		
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		Thread.sleep(250);
		verify_AnyText_NotVisible(driver, "Number of Units Between Firewalls*");
		
		String roofmaterial[] = {"Select...","3 Tab Composition Shingle","Architectural Composition Shingle","Metal","Concrete/Clay Tile","Asbestos Shingle","Tin/Aluminum","Wood Shingle","Rolled/Bitumen","Tar and Gravel","Other"};
		verifyAnyDropDownOptions(driver, roofmaterial, "Building.RoofMaterial");
		
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		
		//Verify fields on Replacement cost estimator tile
		verify_AnyText_IsVisible(driver, "Quality Grade");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A");
		verify_AnyText_IsVisible(driver, "Recalculate");
		getAnyDropDownOptions(driver, "QualityGrade");
		
		selectDropdownText(dwellingChevron.ddQualityGrade, "Standard");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		
		
		
		
		sendText(dwellingChevron.txtSquareFeet, "3000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		
		
		//sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		
		
		click(dwellingChevron.btnSave);
		wait(3);
		
		click(dwellingChevron.btnSave);
		wait(3);
	}
}
