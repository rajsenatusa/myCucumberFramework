package aii.steps;


import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO3_Mma_Forms_Validation extends CommonMethods{

    Scenario scenario;
		
//	private static String LOB = "HO3";
	private static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	String application_Form = null;
	String EndPackage_Form = null;
	
	


	@When("User enters all required information on HO3 dwelling screen with MMA")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_with_mma() {
		//Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbit,"Yes");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	
	@Given("User selects MMA as Yes on dwelling screen")
	public void user_selects_mma_as_yes() {
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
	}
	
	@Given("User clicks on on the application and validate the MMA acknowledge form {string} attached in the application form")
	public void user_clicks_on_on_the_application_and_validate_the_mma_acknowledge_form_attached_in_the_application_form(String HO3_MMA_version) throws Exception {
							
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
		
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "1163 Oak Bluff Dr");
		
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "Davenport, FL 33837-3688");
		
		
	}
	
	@Then("User clicks on the application and validate HO3 MMA acknowledge form not attached in the endorsement package")
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

}
