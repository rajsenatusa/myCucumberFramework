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
		
						
			sendText(quote.firstName, firstName);
			sendText(quote.lastName, lastName);
			wait(2);
			sendText(quote.birthDate, birthDate);
			wait(2);
			click(quote.searchName);
			sendText(quote.address, address);
			sendText(quote.zipCode, zipcode);
			wait(2);
			click(quote.verifyAddress);
			wait(2);
			click(quote.copyToMailAddress);
			click(quote.copyToBillAddress);
			click(quote.saveAndQuote);
			wait(2);
			
			//productSelection
			sendText(product.effectiveDate,effDate);
			selectDropdownText(product.stateDropdown,state);
			selectDropdown(product.carrierDropdown, 1);
			wait(2);
			click(product.continueButton);
			click(product.productSelectionHo3);
			
			//quote
			selectDropdownText(policyChevron.previousCarrier, previousCarr);
			sendText(policyChevron.previousPolicyExpDate, previousExp);
			selectDropdown(policyChevron.insuranceScoreDd,3);
			sendText(policyChevron.phoneNumber, phone);
			selectDropdownText(policyChevron.phoneNumberType, ConfigsReader.getProperty("phonetype"));
			wait(2);
			click(policyChevron.noEmailRadio);
			selectDropdownText(policyChevron.constructionTypeDd, constructtype);
			selectDropdownText(policyChevron.occupancyDd, occupancytype);
			selectDropdownText(policyChevron.monthsOccupied, monthsoccp);
			selectDropdownText(policyChevron.insuredReside, "No");
			wait(1);
			click(policyChevron.nextButton);
			
			//dwelling
			sendText(dwellingChevron.yearConstruction, yearcons);
			sendText(dwellingChevron.squareFeet, "1600");
			wait(3);
			selectDropdownText(dwellingChevron.roofMetarial, roof);
			selectDropdownText(dwellingChevron.mediationArbit,ConfigsReader.getProperty("mediation"));
			wait(2);
			click(dwellingChevron.saveButton);
			wait(3);
			selectDropdownText(dwellingChevron.qualityGrade, quality);
			click(dwellingChevron.calculateButton);
			wait(4);
			click(dwellingChevron.saveButton);
			click(dwellingChevron.nextButton);
			wait(3);
			
			//Quote Review Chevron information was filled here
			selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.fullPaymentRadioButton);
			wait(3);
			click(reviewChevron.createApplication);
			wait(4);
			click(reviewChevron.insuranceScoreCheckBox);
			click(reviewChevron.insuranceScoreOkButton);
			wait(3);
			
			//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
			
			click(dwellingChevron.nextButton);
			
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
			
			selectDropdownText(dwellingChevron.dwellingType, ConfigsReader.getProperty("dwellingtype"));
			wait(2);
			click(dwellingChevron.saveButton);
			click(reviewChevron.reviewButton);
			wait(2);
			click(reviewChevron.finalizeButton);
			wait(2);
			
			//Closeout Chevron information was filled here
			
			selectDropdownText(closeoutChevron.paymentType, ConfigsReader.getProperty("paymenttype"));
			wait(4);
			click(closeoutChevron.issueNBButton);
			WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
			
			if(validate.getText().equalsIgnoreCase("New Business")) {
				System.out.println("Test passed, HO3 NB policy has been created successfully");
			}
			else {
				System.out.println("Test failed!");
			}
			
				wait(5);
				driver.switchTo().defaultContent();
				click(dashboard.userMenu);
				click(dashboard.signOut);
				
				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.signInButton);
				wait(3);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(1);
				dashboard.newQuote.click();
				WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");
		
			
		}
		else {
			break;
		}
		
			
	}
			
}
	}
