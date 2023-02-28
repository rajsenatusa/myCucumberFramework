package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test extends CommonMethods{
	
	private static String LOB = "HO3";
	private static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	String application_Form = null;
	String EndPackage_Form = null;
	
	@Given("I signin Spin as Underwriter")
	public void i_signin_spin_as_underwriter() {
		sendText(login.username, ConfigsReader.getProperty("uw_username"));
		 sendText(login.password, ConfigsReader.getProperty("password"));
		 click(login.signInButton);
		 wait(3);
	}

	@Given("I signin Spin as Agent")
	public void i_signin_spin_as_agent() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		 sendText(login.password, ConfigsReader.getProperty("username"));
		 click(login.signInButton);
		 wait(3);
	}
	
	
	@Given("I validate MMA should default to Select on dwelling screen")
	public void i_validate_mma_should_default_to_select_on_dwelling_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Given("I create application of HO3")
	public void create_HO3_app() {
		click(reviewChevron.createApplication);
		wait(4);
		click(reviewChevron.insuranceScoreCheckBox);
		click(reviewChevron.insuranceScoreOkButton);
		wait(3);
		click(dwellingChevron.saveButton);
	}
	
	@Given("I fill all the uw questions")
	public void i_fill_uwQuestions() throws InterruptedException {
		Thread.sleep(3000);
		click(dwellingChevron.nextButton);
		wait(1);
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
	}

	@Given("I select MMA as Yes on dwelling screen")
	public void i_select_mma_as_yes() {
		selectDropdownText(dwellingChevron.dwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
		selectDropdownText(dwellingChevron.mediationArbit, "Yes");
	}
	
	@Given("I validate MMA field defaulted to Yes on dwelling screen")
	public void i_validate_mma_field_defaulted_to_yes_on_dwelling_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("I finalize and issue new business")
	public void finalize_issueNB() {
		click(reviewChevron.finalizeButton);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		selectDropdownText(closeoutChevron.paymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.issueNBButton);
	}
	
	@Given("I finalize and process")
	public void finalize_process() {
		click(reviewChevron.finalizeButton);
		wait(2);
				
		click(closeoutChevron.issueNBButton);
	}


	@Given("I navigate to policyfile screen")
	public void i_navigate_to_policyfile_screen() {
		click(policyFileChevron.policyFilePage);
	}

	@Given("I click on on the application and validate the MMA acknowledge form {string} attached in the application form")
	public void i_click_on_on_the_application_and_validate_the_mma_acknowledge_form_attached_in_the_application_form(String HO3_MMA_version) throws Exception {
		
		
		click(policyFileChevron.applicationForm);
		wait(2);
		switchToWindow(driver, "STFile&File");
		String application_Form = PdfComparator.makePdf(driver, "Application.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+application_Form);
			
		Thread.sleep(500);
		
		String MMA_NBApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 10, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version1, HO3_MMA_version);
		String MMA_NBApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 9, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version, HO3_MMA_version);
		
		String PolicyNumberSuffix = replaceMethod("AGH0000837-01", "-01", "");
		
		
		String MMA_NBApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 10, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "11216 SW Pembroke DR");
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "Port Saint Lucie, FL 34987-1953");
		
	}
	
	@Given("User search for {string}")
	public void user_with_logged_in_and_search_for(String policy) {
				 wait(3);
		 sendText(dashboard.searchBar, policy);
		 click(dashboard.search);
		 wait(3);
	}
	
	
	@Given("I validate policy, address and zip on the HO3 MMA acknowledge form")
	public void i_validate_policy_address_and_zip_on_the_ho3_mma_acknowledge_form() throws Exception {

//		String policyNum = 
		
	}
	
	@And("I start transaction on policy")
	public void i_start_transaction() {
	    click(policyChevron.policyChevronLink);
	    wait(1);
	    click(dashboard.moreOptions);
	    click(dashboard.startTransaction);
	    
	}

	@Given("I select endorsement transaction on {string}")
	public void i_select_an_endorsement_transaction(String date) {
	    selectDropdownText(dashboard.selectTransaction, "Endorsement");
	    click(dashboard.selectButton);
	    sendText(dashboard.selectDate, date);
	    click(dashboard.startButton);
	    click(dashboard.startButton);
	    
	}

	@Then("I click on on the application and validate HO3 MMA acknowledge form not attached in the endorsement package")
	public void i_validate_ho3_mma_acknowledge_form_not_attached_in_the_endorsement_package() throws Exception {
		click(policyFileChevron.applicationForm);
		wait(2);
		switchToWindow(driver, "STFile&File");
		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+EndPackage_Form);
		
		PdfComparator.verifyPDFText_NotVisible(driver, EndPackage_Form, "AIIC HO3 MMAA 03 22");
			
		Thread.sleep(500);
	}
	
}
