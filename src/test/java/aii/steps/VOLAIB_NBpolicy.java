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

public class VOLAIB_NBpolicy extends CommonMethods {

	@When("User enters AIB product selection information and effective date")
	public void user_enters_aib_product_selection_information_and_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);

	}

	@When("User enters all required information on AIB quote screen")
	public void user_enters_all_required_information_on_aib_quote_screen() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		click(dwellingChevron.btnSave);
		wait(5);
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects liability coverage on quote screen")
	public void user_selects_liability_coverage_on_quote_screen() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, ConfigsReader.getProperty("boatingliability"));
		wait(6);
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryboat"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);

	}

	@When("User adds operator information on quote screen")
	public void user_adds_operator_information_on_quote_screen() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, ConfigsReader.getProperty("licensestate"));
		sendText(aibChevron.txtLicenseNumber, ConfigsReader.getProperty("licensenumber"));
		selectDropdownText(aibChevron.ddBoatExperience, ConfigsReader.getProperty("boatexperience"));
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);

	}

	@When("User enters all required information on AIB boat dwelling screen")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, ConfigsReader.getProperty("boatyear"));
		sendText(aibChevron.txtBoatHinNumber, ConfigsReader.getProperty("boathinnumber"));
		selectDropdownText(aibChevron.ddBoatMake, ConfigsReader.getProperty("boatmake"));
		sendText(aibChevron.txtBoatModel, ConfigsReader.getProperty("boatmodel"));
		sendText(aibChevron.txtBoatPurchDate, ConfigsReader.getProperty("boatpurchasedate"));
		selectDropdownText(aibChevron.ddBoatFinanced, ConfigsReader.getProperty("boatfinanced"));
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, ConfigsReader.getProperty("boatpurchaseprice"));
		selectDropdownText(aibChevron.ddBoatHullType, ConfigsReader.getProperty("boathulltype"));
		selectDropdownText(aibChevron.ddBoatHullMat, ConfigsReader.getProperty("boathullmat"));
		selectDropdownText(aibChevron.ddHullLength, ConfigsReader.getProperty("hulllength"));
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, ConfigsReader.getProperty("boatdrivesystem"));
		selectDropdownText(aibChevron.ddBoatMaxSpeed, ConfigsReader.getProperty("boatmaxspeed"));
		selectDropdownText(aibChevron.ddBoatHullSettle, ConfigsReader.getProperty("boathullsettle"));
		selectDropdownText(aibChevron.ddNumberOfEngines, ConfigsReader.getProperty("numberofengines"));
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, ConfigsReader.getProperty("boathp"));
		sendText(aibChevron.txtBoatEngine1Year, ConfigsReader.getProperty("boatengine1year"));
		sendText(aibChevron.txtBoatEngineMake, ConfigsReader.getProperty("boatenginemake"));
		sendText(aibChevron.txtBoatEngine1Hp, ConfigsReader.getProperty("boatengine1hp"));
		selectDropdownText(aibChevron.ddTrailerCoverage, ConfigsReader.getProperty("trailercoverage"));
		selectDropdownText(aibChevron.ddBoatStorageType, ConfigsReader.getProperty("boatstoragetype"));

		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);

	}

	@When("User enters all required information on AIB review screen")
	public void user_enters_all_required_information_on_aib_review_screen() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(3);

	}
	@And("User clicks VOL AIB policy")
	public void User_clicks_VOL_AIB_policy() {	     
		click(product.btnProductSelectionAib);	
	}
	@And("User selects Have you had 6 months of continuous boat insurance")
	public void User_selects_Have_you_had_6_months_of_continuous_boat_insurance() {	     
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
	}
	@And("User selects Are all boats stored in Florida at least 6 months of the year")
	public void User_selects_Are_all_boats_stored_in_Florida_at_least_6_months_of_the_year() {	     
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
	}
	@And("User selects Boating Liability")
	public void User_selects_Boating_Liability() {	     
		selectDropdownText(golfcartChevron.ddLiabilityCovType, "No Coverage");
	}
	@Then("User verifies NB AIB policy has been created successfully")
	public void User_verifies_NB_AIB_policy_has_been_created_successfully() {	    	   								 	   						
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);	
	}
	@And("User clicks AIB Prior Carrier")
 	public void User_clicks_AIB_Prior_Carrier() {	    	   				
 		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
 		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User creates AIB application")
	public void user_creates_aib_application() {

		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);

		// Application Policy Chevron information was filled here(all information was
		// filled previously, just clicking next button)

		click(dwellingChevron.btnNext);
		wait(1);

	}

	@And("User answers all underwriting questions for AIB")
	public void user_answers_all_underwriting_questions_for_aib() throws Exception {

		// Application Underwriting Questions Chevron was filled here (with the help of
		// commonmethods.java class)
		wait(2);
		fillBoat_UWQuestions();
		wait(2);
		click(uwquestionsChevron.nextButtonUw);
	}

	@Then("User validates that AIB policy has been created successfully")
	public void user_validates_that_aib_policy_has_been_created_successfully() {

		wait(3);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, AIB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Then("User creates AIB policy with passing information from excel {string} sheet")
	public void User_creates_aib_policy_with_passing_information_from_excel_sheet(String aibcustomerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLAIB.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, aibcustomerInfo);

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
				String boatingliability = dataMap.get("BoatingLiability");
				String boadilyinjuryboat = dataMap.get("BoadilyInjury");

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
				click(product.btnProductSelectionAib);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				click(dwellingChevron.btnSave);
				wait(2);
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				click(dwellingChevron.btnSave);
				wait(5);
				selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
				selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
				selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddInsuredReside, "No");
				wait(1);
				click(policyChevron.btnNext);
				wait(3);

				// liability coverage on quote screen
				selectDropdownText(golfcartChevron.ddLiabilityCovType, boatingliability);
				wait(6);
				selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, boadilyinjuryboat);
				wait(3);
				click(dwellingChevron.btnSave);
				wait(4);
				click(dwellingChevron.btnSave);
				wait(3);
				click(dwellingChevron.btnNext);

				// adding operator info
				click(aibChevron.btnAddOperator);
				wait(3);
				selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
				selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
				selectDropdownText(aibChevron.ddLicenseState, ConfigsReader.getProperty("licensestate"));
				sendText(aibChevron.txtLicenseNumber, ConfigsReader.getProperty("licensenumber"));
				selectDropdownText(aibChevron.ddBoatExperience, ConfigsReader.getProperty("boatexperience"));
				selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
				wait(3);
				click(golfcartChevron.btnNextGocScreen);

				//boat dwelling screen
				click(aibChevron.btnAddBoat);
				wait(3);
				sendText(aibChevron.txtBoatYear, ConfigsReader.getProperty("boatyear"));
				sendText(aibChevron.txtBoatHinNumber, ConfigsReader.getProperty("boathinnumber"));
				selectDropdownText(aibChevron.ddBoatMake, ConfigsReader.getProperty("boatmake"));
				sendText(aibChevron.txtBoatModel, ConfigsReader.getProperty("boatmodel"));
				sendText(aibChevron.txtBoatPurchDate, ConfigsReader.getProperty("boatpurchasedate"));
				selectDropdownText(aibChevron.ddBoatFinanced, ConfigsReader.getProperty("boatfinanced"));
				wait(3);
				sendText(aibChevron.txtBoatPurchPrice, ConfigsReader.getProperty("boatpurchaseprice"));
				selectDropdownText(aibChevron.ddBoatHullType, ConfigsReader.getProperty("boathulltype"));
				selectDropdownText(aibChevron.ddBoatHullMat, ConfigsReader.getProperty("boathullmat"));
				selectDropdownText(aibChevron.ddHullLength, ConfigsReader.getProperty("hulllength"));
				wait(3);
				selectDropdownText(aibChevron.ddBoatDriveSystem, ConfigsReader.getProperty("boatdrivesystem"));
				selectDropdownText(aibChevron.ddBoatMaxSpeed, ConfigsReader.getProperty("boatmaxspeed"));
				selectDropdownText(aibChevron.ddBoatHullSettle, ConfigsReader.getProperty("boathullsettle"));
				selectDropdownText(aibChevron.ddNumberOfEngines, ConfigsReader.getProperty("numberofengines"));
				wait(2);
				selectDropdownText(aibChevron.ddBoatHp, ConfigsReader.getProperty("boathp"));
				sendText(aibChevron.txtBoatEngine1Year, ConfigsReader.getProperty("boatengine1year"));
				sendText(aibChevron.txtBoatEngineMake, ConfigsReader.getProperty("boatenginemake"));
				sendText(aibChevron.txtBoatEngine1Hp, ConfigsReader.getProperty("boatengine1hp"));
				selectDropdownText(aibChevron.ddTrailerCoverage, ConfigsReader.getProperty("trailercoverage"));
				selectDropdownText(aibChevron.ddBoatStorageType, ConfigsReader.getProperty("boatstoragetype"));

				selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
				wait(3);
				click(dwellingChevron.btnNext);
				wait(3);
				click(reviewChevron.btnReview);
				wait(3);
		
				// Quote Review Chevron information was filled here
				
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				selectDropdownText(reviewChevron.ddOrderInsScore, "No");
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);
				click(policyChevron.btnPolicyChevronLink);
				wait(2);
				
				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);
				wait(1);
				
				// Application Underwriting Questions Chevron was filled here (with the help of
				// commonmethods.java class)
				wait(2);
				fillBoat_UWQuestions();
				wait(2);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here

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

				// Validation

				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, AIB NB policy has been created successfully");
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
