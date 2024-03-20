package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5218_HO3_Verify_base_rates_can_display_correctly_after_effective_date_change extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String QuoteNum;

	@When("User enters HO3 product selection information and date as 03.19.2024")
	public void User_enters_HO3_product_selection_information_and_date_as_03192024() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, "03/19/2024");
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 dwelling screen <mtr5218>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5218() {
		// Quote Dwelling information was filled here
		wait(5);
		sendText(dwellingChevron.txtYearConstruction, "2020");
//		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		wait(5);
		driver.findElement(By.id("Building.RoofMaterial")).sendKeys("Metal");
//		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		wait(5);
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);

	}

	@And("User validates that HO3 quote has been created successfully <mtr5218>")
	public void User_validates_that_HO3_quote_has_been_created_successfully_mtr5218() throws Exception {

		try {
			QuoteNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Quote Number: " + QuoteNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeUnnecessaryTabs();
		attachScreenShot(driver);
		wait(1);
	}

	@When("User enters effective date as 03.21.2024 <mtr5218>")
	public void User_enters_effective_date_as_03212024_mtr5218() {
		wait(2);
		sendText(product.txtEffectiveDate, "03/21/2024");
		wait(7);
	}

	@Then("User validates warning message, 'There is a new product version for this effective date.'")
	public void User_validates_warning_message_There_is_a_new_product_version_for_this_effective_date()
			throws Exception {

		verify_AnyfirstText_IsDisplayed(driver,
				"There is a new product version for this effective date. Click the Change Product button to switch to it.");
		Hooks.scenario.log("Message displays successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User clicks Change Product")
	public void User_clicks_Change_Product() {
		wait(1);
		click(policyChevron.btnChangeProduct);
		click(policyChevron.btnOK);

	}

}
