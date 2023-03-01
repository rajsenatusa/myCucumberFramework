package aii.steps;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.Then;

public class HO3Excel extends CommonMethods {

	@Then("I create HO3 policy with passing information from excel {string} sheet")
	public void i_create_ho3_policy_with_passing_information_from_excel_sheet(String customerInfo) {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		
		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, customerInfo);
		
	
		for (Map<String, String> dataMap : excelList) {
		
			if(!dataMap.containsValue("")) {
			String firstName = dataMap.get("FirstName");
			String lastName = dataMap.get("LastName");
			String birthDate = dataMap.get("BirthDate");
			String address = dataMap.get("Address");
			String zipcode= dataMap.get("Zipcode");
			String effDate=dataMap.get("EffectiveDate");
			String state=dataMap.get("State");
			String previousCarr = dataMap.get("PreviousCarrier");
			String previousExp = dataMap.get("PreviousExpDate");
			String phone = dataMap.get("Phone");
			String constructtype = dataMap.get("ConsType");
			String occupancytype= dataMap.get("Occupancy");
			String monthsoccp=dataMap.get("Months");
			String yearcons=dataMap.get("ConstYear");
			String roof=dataMap.get("RoofMat");
			String quality=dataMap.get("Quality");
		
						
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
			
			//productSelection
			sendText(product.txtEffectiveDate,effDate);
			selectDropdownText(product.ddStateSelection,state);
			selectDropdown(product.ddCarrierSelection, 1);
			wait(2);
			click(product.btnContinue);
			click(product.btnProductSelectionHo3);
			
			//quote
			selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
			sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
			selectDropdown(policyChevron.ddInsuranceScoreDd,3);
			sendText(policyChevron.txtPhoneNumber, phone);
			selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
			wait(2);
			click(policyChevron.btnNoEmailRadio);
			selectDropdownText(policyChevron.ddConstructionType, constructtype);
			selectDropdownText(policyChevron.ddOccupancy, occupancytype);
			selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
			selectDropdownText(policyChevron.ddInsuredReside, "No");
			wait(1);
			click(policyChevron.btnNext);
			
			//dwelling
			sendText(dwellingChevron.txtYearConstruction, yearcons);
			sendText(dwellingChevron.txtSquareFeet, "1600");
			wait(3);
			selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
			selectDropdownText(dwellingChevron.ddMediationArbit,ConfigsReader.getProperty("mediation"));
			wait(2);
			click(dwellingChevron.btnSave);
			wait(3);
			selectDropdownText(dwellingChevron.ddQualityGrade, quality);
			click(dwellingChevron.btnCalculate);
			wait(4);
			click(dwellingChevron.btnSave);
			click(dwellingChevron.btnNext);
			wait(3);
			
			//Quote Review Chevron information was filled here
			selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.btnFullPaymentRadio);
			wait(3);
			click(reviewChevron.btnCreateApplication);
			wait(4);
			click(reviewChevron.btnInsuranceScoreBox);
			click(reviewChevron.btnInsuranceScoreOk);
			wait(3);
			
			//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
			
			click(dwellingChevron.btnNext);
			
			//Application Underwriting Questions Chevron was filled here
			
			selectDropdownText(uwquestionsChevron.ho3Question1, "No");
			selectDropdownText(uwquestionsChevron.ho3Question2, "No");
			selectDropdownText(uwquestionsChevron.ho3Question3, "No");
			selectDropdownText(uwquestionsChevron.ho3Question4, "No");
			selectDropdownText(uwquestionsChevron.ho3Question5, "No");
			selectDropdownText(uwquestionsChevron.ho3Question6, "No");
			selectDropdownText(uwquestionsChevron.ho3Question7, "No");
			selectDropdownText(uwquestionsChevron.ho3Question8, "No");
			selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
			selectDropdownText(uwquestionsChevron.ho3Question10, "No");
			selectDropdownText(uwquestionsChevron.ho3Question11, "No");
			selectDropdownText(uwquestionsChevron.ho3Question12, "No");
			selectDropdownText(uwquestionsChevron.ho3Question13, "No");
			selectDropdownText(uwquestionsChevron.ho3Question14, "No");
			selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
			selectDropdownText(uwquestionsChevron.ho3Question16, "No");
			selectDropdownText(uwquestionsChevron.ho3Question17, "No");
			selectDropdownText(uwquestionsChevron.ho3Question18, "No");
			selectDropdownText(uwquestionsChevron.ho3Question19, "No");
			selectDropdownText(uwquestionsChevron.ho3Question20, "No");
			selectDropdownText(uwquestionsChevron.ho3Question21, "No");
			selectDropdownText(uwquestionsChevron.ho3Question22, "No");
			selectDropdownText(uwquestionsChevron.ho3Question23, "No");
			selectDropdownText(uwquestionsChevron.ho3Question24, "No");
			selectDropdownText(uwquestionsChevron.ho3Question25, "No");
			selectDropdownText(uwquestionsChevron.ho3Question26, "No");
			selectDropdownText(uwquestionsChevron.ho3Question27, "No");
			selectDropdownText(uwquestionsChevron.ho3Question28, "No");
			selectDropdownText(uwquestionsChevron.ho3Question29, "No");
			wait(1);
			click(uwquestionsChevron.nextButtonUw);
			
			//Application Dwelling information was filled here
			
			selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
			wait(2);
			click(dwellingChevron.btnSave);
			click(reviewChevron.btnReview);
			wait(2);
			click(reviewChevron.btnFinalize);
			wait(2);
			
			//Closeout Chevron information was filled here
			
			selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
			wait(4);
			click(closeoutChevron.btnIssueNB);
			WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
			
			if(validate.getText().equalsIgnoreCase("New Business")) {
				System.out.println("Test passed, HO3 NB policy has been created successfully");
			}
			else {
				System.out.println("Test failed!");
			}
			
				wait(5);
				driver.switchTo().defaultContent();
				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);
				
				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.btnSignIn);
				wait(3);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(1);
				dashboard.btnNewQuote.click();
				WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");
		
			
		}
		else {
			break;
		}
		
			
	}
			
}
	}
