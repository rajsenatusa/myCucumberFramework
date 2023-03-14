package aii.steps;


import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test extends CommonMethods{

    Scenario scenario;
		
//	private static String LOB = "HO3";
	private static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	String application_Form = null;
	String EndPackage_Form = null;
	
	
	@Given("I signin Spin as Underwriter")
	public void i_signin_spin_as_underwriter() {
		sendText(login.username, ConfigsReader.getProperty("uw_username"));
		 sendText(login.password, ConfigsReader.getProperty("password"));
		 click(login.btnSignIn);
		 wait(3);
	}

	@Given("I signin Spin as Agent")
	public void i_signin_spin_as_agent() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		 sendText(login.password, ConfigsReader.getProperty("username"));
		 click(login.btnSignIn);
		 wait(3);
	}
	
		
	@When("I enter all the information on review screen")
	public void i_enter_all_information_on_review_screen() {
		//Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
	}
	
	@Given("I create application of HO3")
	public void create_HO3_app() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(3);
		click(dwellingChevron.btnSave);
	}
	
	@Given("I fill all the uw questions")
	public void i_fill_uwQuestions() throws InterruptedException {
		Thread.sleep(3000);
		click(dwellingChevron.btnNext);
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
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
	}
	

	@Given("I finalize and issue new business")
	public void finalize_issueNB() {
		click(reviewChevron.btnFinalize);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
	}
	
	@Given("I finalize and process")
	public void finalize_process() {
		click(reviewChevron.btnFinalize);
		wait(2);
				
		click(closeoutChevron.btnIssueNB);
	}


	@Given("I navigate to policyfile screen")
	public void i_navigate_to_policyfile_screen() {
	
		Hooks.scenario.log("Scenairo Statement");
		click(policyFileChevron.btnPolicyFilePage);
	}

	@Given("I click on on the application and validate the MMA acknowledge form {string} attached in the application form")
	public void i_click_on_on_the_application_and_validate_the_mma_acknowledge_form_attached_in_the_application_form(String HO3_MMA_version) throws Exception {
							
		click(policyFileChevron.btnApplicationForm);
		wait(2);
		switchToWindow(driver, "STFile&File");
		String application_Form = PdfComparator.makePdf(driver, "Application.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+application_Form);
			
		wait(5);
		
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
	
	
	
	@And("I start transaction on policy")
	public void i_start_transaction() {
	    click(policyChevron.btnPolicyChevronLink);
	    wait(1);
	    click(dashboard.ddMoreOptions);
	    click(dashboard.btnStartTransaction);
	    
	}

	@Given("I select endorsement transaction on {string}")
	public void i_select_an_endorsement_transaction(String date) {
	    selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
	    click(dashboard.btnSelect);
	    sendText(dashboard.txtSelectDate, date);
	    click(dashboard.btnStart);
	    click(dashboard.btnStart);
	    
	}

	@Then("I click on on the application and validate HO3 MMA acknowledge form not attached in the endorsement package")
	public void i_validate_ho3_mma_acknowledge_form_not_attached_in_the_endorsement_package() throws Exception {
		click(policyFileChevron.btnApplicationForm);
		wait(2);
		switchToWindow(driver, "STFile&File");
		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+EndPackage_Form);
		
		PdfComparator.verifyPDFText_NotVisible(driver, EndPackage_Form, "AIIC HO3 MMAA 03 22");
			
		wait(5);
	}
	
//	@And("I change date of system {string}")
//	public void i_validate_change_Date(String date) throws Exception {
//		 click(dashboard.btnAdmin);
//		 click(dashboard.btnChangeDate);
//		 sendText(dashboard.txtNewDate, date);
//		 click(dashboard.btnChangeNewDate);
//		 sendText(dashboard.txtNewBookDate, date);
//		 click(dashboard.btnChangeBookDate);
//	}
}
