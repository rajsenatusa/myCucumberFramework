package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR584_SCHO3_VerifyNonRenewalNotice extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String totalDue;
	static String NonRenewalNotice_Form;
	static String NonRenewalNotice_Page;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User validates SC HO3 policy has been created successfully and takes note of the policy number for <mtr584>")
	public void User_validates_SC_HO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr584()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User enters SC HO3 product selection information and 01 01 2024 date for <mtr584>")
	public void user_enters_sc_ho3_product_selection_information_and_01_01_2024_date_for_mtr584() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, "1/1/2024");
		selectDropdown(product.ddStateSelection, 2);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
	}

	@And("User clicks Non-Renewal Transaction Selection")
	public void User_clicks_Non_Renewal_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Non-Renewal");
		wait(1);
		click(dashboard.btnSelect);

	}

	@And("User validates Non_Renewal HO3 policy has been created successfully and takes note of the policy number for <mtr584>")
	public void User_validates_Non_Renewal_HO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr584()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_2_Description"));

		if (validate.getText().equalsIgnoreCase("Non-Renewal")) {
			System.out.println("Non_Renewal HO3 NB policy has been created successfully");
		} else {
			System.out.println("Non_Renewal HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Non_Renewal SC HO3 policy has been created successfully");

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User Searchs for Policy Number for <mtr584>")
	public void User_searches_for_Policy_Number_for_mtr584() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@Then("User clicks Non Renewal Notice Hyperlink and validates Non renewal Notice displays")
	public void User_clicks_Non_Renewal_Notice_Hyperlink_and_validates_Non_renewal_Notice_displays() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Non-Renewal Notice" + "");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NonRenewalNotice_Form = PdfComparator.makePdf(driver, "NonRenewalNotice.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NonRenewalNotice_Form);
		wait(10);

		// Non Renewal Notice Form
		NonRenewalNotice_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNotice_Form, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, NonRenewalNotice_Page, "NON-RENEWAL NOTICE");

		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User clicks Policy File Chevron <mtr584>")
	public void user_clicks_policy_file_chevron_mtr584() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@And("User validates Non Renewal HO3 policy has been created successfully")
	public void User_validates_Non_Renewal_HO3_policy_has_been_created_successfully() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_2_Description"));

		if (validate.getText().equalsIgnoreCase("Non-Renewal")) {
			System.out.println("Non_Renewal HO3 NB policy has been created successfully");
		} else {
			System.out.println("Non_Renewal HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Non_Renewal HO3 policy has been created successfully");

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}