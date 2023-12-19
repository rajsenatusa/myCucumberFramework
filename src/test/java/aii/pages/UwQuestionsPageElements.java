package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class UwQuestionsPageElements extends CommonMethods {
	
	@FindBy(id= "Wizard_Underwriting")
	public WebElement lnkUwQuestionsTab;
	
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
	
	@FindBy(id= "NextPage")
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
	
	@FindBy(id= "Question_UnusualLiabilityNo")
	public WebElement mho3Question12;
	
	@FindBy(id= "Question_FoundationDisclosure")
	public WebElement mho3Question16;
	
	@FindBy(id= "Question_VacantUnoccupiedNo")
	public WebElement mho3Question22;
	
	@FindBy(id= "Question_VisibleNeighbors")
	public WebElement mho3Question24;
	
	@FindBy(id= "Question_FireDeptAccessible")
	public WebElement mho3Question25;
	
	@FindBy(id= "Question_Rented")
	public WebElement mho3Question26;
	
	@FindBy(id= "Question_InsuredDecline1")
	public WebElement gocQuestion1;
	
	@FindBy(id= "Question_Accidents")
	public WebElement gocQuestion3;
	
	@FindBy(id= "Question_ViolationsAccidents")
	public WebElement gocQuestion4;
	
	@FindBy(id= "Question_NegligentDriving")
	public WebElement gocQuestion5;
	
	@FindBy(id= "Question_OperatorDWIDUI")
	public WebElement gocQuestion6;
	
	@FindBy(id= "Question_OperatorImpairment1")
	public WebElement gocQuestion7;
	
	@FindBy(id= "Question_BusinessCommercial")
	public WebElement gocQuestion8;
	
	@FindBy(id= "Question_LessThan16")
	public WebElement gocQuestion9;
	
	@FindBy(id= "Question_PublicRoads")
	public WebElement gocQuestion10;
	
	@FindBy(id= "Question_Racing")
	public WebElement gocQuestion11;
	
	@FindBy(id= "Question_LiveryConveyance")
	public WebElement gocQuestion12;
	
	@FindBy(id= "Question_InsuredDecline1")
	public WebElement aibQuestion1;
	
	@FindBy(id= "Question_DriverAge")
	public WebElement aibQuestion5;
	
	@FindBy(id= "Question_OperatorDWIDUI2")
	public WebElement aibQuestion7;
	
	@FindBy(id= "Question_CorporateEntity")
	public WebElement aibQuestion10;
	
	@FindBy(id= "Question_Charter")
	public WebElement aibQuestion11;
	
	@FindBy(id= "Question_Navigable")
	public WebElement aibQuestion12;
	
	@FindBy(id= "Question_Racing")
	public WebElement aibQuestion13;
	
	@FindBy(id= "Question_Engine")
	public WebElement aibQuestion14;
	
	@FindBy(id= "Question_PaidCrew")
	public WebElement aibQuestion15;
	
	@FindBy(id= "Question_SleepingBoat")
	public WebElement aibQuestion16;
	
	@FindBy(id= "Question_ExistingDamage")
	public WebElement aibQuestion17;
	
	@FindBy(id= "Question_ResidenceBoat")
	public WebElement aibQuestion18;
	
	@FindBy(id= "Question_AdditionalOwners")
	public WebElement aibQuestion19;
	
	@FindBy(id= "Question_ForSale")
	public WebElement aibQuestion20;
	
	@FindBy(id= "Question_TotalLoss")
	public WebElement aibQuestion21;
	
	@FindBy(id= "Question_LiveryConveyance")
	public WebElement aibQuestion22;
	
	@FindBy(id= "Question_MemberAircraft")
	public WebElement umbQuestion1;
	
	@FindBy(id= "Question_MemberBite")
	public WebElement umbQuestion2;
	
	@FindBy(id= "Question_MemberPitBull")
	public WebElement umbQuestion3;
	
	@FindBy(id= "Question_MemberBusiness")
	public WebElement umbQuestion4;
	
	@FindBy(id= "Question_MemberDecline1")
	public WebElement umbQuestion5;
	
	@FindBy(id= "Question_MemberDUI")
	public WebElement umbQuestion6;
	
	@FindBy(id= "Question_MemberEntertainer")
	public WebElement umbQuestion7;
	
	@FindBy(id= "Question_MemberFraud")
	public WebElement umbQuestion8;
	
	@FindBy(id= "Question_MemberImpairment1")
	public WebElement umbQuestion9;
	
	@FindBy(id= "Question_MemberLiability1")
	public WebElement umbQuestion10;
	
	@FindBy(id= "Question_MemberRacing")
	public WebElement umbQuestion11;
	
	@FindBy(id= "Question_MemberViolations")
	public WebElement umbQuestion12;
	
	@FindBy(id= "Question_RoomingHouses")
	public WebElement umbQuestion13;
	
	@FindBy(id= "Question_SwimmingPool")
	public WebElement umbQuestion14;
	
	@FindBy(id= "Question_Trampoline")
	public WebElement umbQuestion15;
	
	@FindBy(id= "Question_UnderlyingInsurance")
	public WebElement umbQuestion16;
	
	@FindBy(id= "Question_VehicleLivery")
	public WebElement umbQuestion17;
	
	@FindBy(id= "Question_VehicleSpeed")
	public WebElement umbQuestion18;
	
	@FindBy(id= "Question_LapseInCoverage")
	public WebElement scHo3Question6;
	
	@FindBy(id= "Question_PriorInsurance")
	public WebElement scHo3Question9;
	
	@FindBy(id= "Question_Breed1")
	public WebElement questionBreed1;
	
	@FindBy(id= "Question_BiteHistory")
	public WebElement questionBiteHistory;
	
	@FindBy(id= "Question_ExoticAnimals")
	public WebElement questionExoticAnimals;
	
	@FindBy(id= "Question_MatchingLimits")
	public WebElement questionMatchingLimits;
	
	@FindBy(id= "Question_UnfencedPool")
	public WebElement questionUnfencedPool;
	
	@FindBy(id= "Question_FloodProof")
	public WebElement questionFloodProof; 
	
	@FindBy(id= "Question_PriorAIICPolicyNumber")
	public WebElement questionPriorAIICPolicyNumber; 
	
	@FindBy(id= "Question_LicensePolicy")
	public WebElement questionLicensePolicy; 
	
	@FindBy(id= "selectDropdownText(uwquestionsChevron.ho3Question26,")
	public WebElement selectDropdownText26; 
	 
	
	
	public UwQuestionsPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
