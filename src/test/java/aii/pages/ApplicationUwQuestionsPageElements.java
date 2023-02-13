package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class ApplicationUwQuestionsPageElements extends CommonMethods {
	
	@FindBy(id= "Question_Conviction")
	public WebElement ho3Question1;
	
	@FindBy(id= "Question_InsuredForeclosure")
	public WebElement ho3Question2;
	
	@FindBy(id= "Question_PriorLosses")
	public WebElement ho3Question3;
	
	@FindBy(id= "Question_FloodLoss")
	public WebElement ho3Question4;
	
	@FindBy(id= "Question_InsuranceCancelled")
	public WebElement ho3Question5;
	
	@FindBy(id= "Question_PriorNonWeatherLosses")
	public WebElement ho3Question6;
	
	@FindBy(id= "Question_SinkholeInspection")
	public WebElement ho3Question7;
	
	@FindBy(id= "Question_SinkholeLoss")
	public WebElement ho3Question8;
	
	@FindBy(id= "Question_PriorInsuranceYes")
	public WebElement ho3Question9;
	
	@FindBy(id= "Question_PriorInsurance")
	public WebElement ho3Question10;
	
	@FindBy(id= "Question_Animals")
	public WebElement ho3Question11;
	
	@FindBy(id= "Question_ExoticAnimals")
	public WebElement ho3Question12;
	
	@FindBy(id= "Question_RecreationalVehicles")
	public WebElement ho3Question13;
	
	@FindBy(id= "Question_UnusualLiability")
	public WebElement ho3Question14;
	
	@FindBy(id= "Question_HomeOccupied")
	public WebElement ho3Question15;
	
	@FindBy(id= "Question_NonWeatherWaterLosses")
	public WebElement ho3Question16;
	
	@FindBy(id= "Question_PropertyForeclosure")
	public WebElement ho3Question17;
	
	@FindBy(id= "Question_Damage")
	public WebElement ho3Question18;
	
	@FindBy(id= "Question_Foundation")
	public WebElement ho3Question19;
	
	@FindBy(id= "Question_Pool")
	public WebElement ho3Question20;
	
	@FindBy(id= "Question_HomeOccupants")
	public WebElement ho3Question21;
	
	@FindBy(id= "Question_BusinessFarming")
	public WebElement ho3Question22;
	
	@FindBy(id= "Question_DayCare")
	public WebElement ho3Question23;
	
	@FindBy(id= "Question_KnownSinkhole")
	public WebElement ho3Question24;
	
	@FindBy(id= "Question_VacantUnoccupied")
	public WebElement ho3Question25;
	
	@FindBy(id= "Question_FloodHazardArea")
	public WebElement ho3Question26;
	
	@FindBy(id= "Question_PriorAIICPolicy")
	public WebElement ho3Question27;
	
	@FindBy(id= "Question_FirstPartyLawsuit")
	public WebElement ho3Question28;
	
	@FindBy(id= "Question_AssignmentOfBenefits")
	public WebElement ho3Question29;
	
	@FindBy(id= "NextPage_Bottom")
	public WebElement nextButtonUw;
	
	@FindBy(id= "Question_BusinessActivity")
	public WebElement ho4Question12;
	
	@FindBy(id= "Question_PriorAIICPolicy")
	public WebElement ho4Question14;
	
	@FindBy(id= "Question_SinkholeClaim")
	public WebElement ho6Question8;
	
	@FindBy(id= "Question_ExoticAnimalsOnPremises")
	public WebElement ho6Question12;
	
	@FindBy(id= "Question_SwimmingPool")
	public WebElement ho6Question19;
	
	@FindBy(id= "Question_Business")
	public WebElement ho6Question21;
	
	@FindBy(id= "Question_FloodLosses")
	public WebElement ho6Question4;
	
	@FindBy(id= "Question_SinkholeLosses")
	public WebElement dp1Question8;
	
	
	
	
	
	
	public ApplicationUwQuestionsPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
