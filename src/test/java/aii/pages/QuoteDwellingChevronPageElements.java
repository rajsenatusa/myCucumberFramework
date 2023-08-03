package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteDwellingChevronPageElements extends CommonMethods {
	
	@FindBy(id= "Building.YearBuilt")
	public WebElement txtYearConstruction;
	
	@FindBy(id= "Building.SqFt")
	public WebElement txtSquareFeet;
	
	@FindBy(id= "Building.RoofMaterial")  
	public WebElement ddRoofMetarial;
	
	@FindBy(id= "Building.MediationArbitrationInd")
	public WebElement ddMediationArbit;
	
	@FindBy(id= "BuildingExt.MMAInd")
	public WebElement d1MediationArbit;
	
	@FindBy(id= "BuildingExt.MMAInd")
	public WebElement ddMediationArbitDp1;
	
	@FindBy(id= "Save")
	public WebElement btnSave;
	
	@FindBy(id= "Building.QualityGrade")
	public WebElement ddQualityGrade;
	
	@FindBy(id= "CalculateRCE")
	public WebElement btnCalculate;
	
	@FindBy(id= "NextPage")
	public WebElement btnNext;
	
	@FindBy(id= "Building.DwellingType")
	public WebElement ddDwellingType;
	
	@FindBy(id= "Building.CovCLimit")
	public WebElement txtCoverageC;
	
	@FindBy(id= "Building.NumberOfStories")
	public WebElement ddNumberOfStories;
	
	@FindBy(id= "Building.StoryUnit")
	public WebElement ddStoryOfUnit;
	
	@FindBy(id= "Building.CovALimit")
	public WebElement txtCoverageA;
	
	@FindBy(id= "Building.LengthMHO")
	public WebElement ddBuildingLength;
	
	@FindBy(id= "Building.MakeMHO")
	public WebElement ddBuildingMake;
	
	@FindBy(id= "Building.WidthMHO")
	public WebElement ddBuildingWidth;
	
	@FindBy(id= "Building.SkirtedTDRails")
	public WebElement ddBuildingSkirtedRails;
	
	@FindBy(id= "Building.SerialNumber")
	public WebElement txtBuildingSerialNumber;
	
	@FindBy(id= "Building.TerritoryList")
	public WebElement ddBuildingTerritoryList;
	
	@FindBy(id= "Building.StructuresRentedOthers")
	public WebElement ddStructureRentedOthers;
	
	@FindBy(id= "Building.HurricaneDeductible")
	public WebElement ddHurricaneDeductible;
	
	@FindBy(id= "Building.DistToFireHydrant")
	public WebElement ddDistanceToHydrant;
	
	@FindBy(id= "Building.ProtectionClass")
	public WebElement ddProtectionClass;
	
	@FindBy(id= "Building.NumberOfUnits")
	public WebElement ddNumberofUnits;
	
	@FindBy(id= "Building.AttachedStructures")
	public WebElement ddAttachedStructures;
	
	@FindBy(id= "Building.PackageCoverageInd_1")
	public WebElement rbBasicPackage;
	
	@FindBy(id= "Building.PackageCoverageInd_2")
	public WebElement rbIntegritySelectPackage;
	
	@FindBy(id= "Building.CovCLimitIncluded")
	public WebElement ddCovCLimit;
	
	@FindBy(id= "Building.CovLLimit")
	public WebElement ddCovLLimit;
	
	@FindBy(id= "Building.CovHCCLimit")
	public WebElement ddHomeComputerLimit;
	
	@FindBy(id= "Building.BCEGCd")
	public WebElement bCEG;
	
	@FindBy(id = "Building.FireplaceInd")
	public WebElement ddFirePlace;
	
	@FindBy(id = "Building.ExteriorWalls")
	public WebElement ddExteriorWalls;
	
	@FindBy(id = "Building.PackageCoverageInd_2")
	public WebElement rbSilverReserve;
	
	@FindBy(id = "Building.CovALimit")
	public WebElement txtCovALimit;
	
	@FindBy(id = "Building.AnimalLiability")
	public WebElement ddAnimalLiability;
	
	@FindBy(id = "Building.FireAlarmCd")
	public WebElement ddFireAlarm;
	
	@FindBy(id = "Building.SprinklerSystemCd")
	public WebElement ddSprinklerSystem; 
	
	@FindBy(id = "Building.BurglarAlarmCd")
	public WebElement ddBurglarAlarm; 
	
	@FindBy(id = "Building.SecuredCommunityCd")  
	public WebElement ddSecuredCommunity; 
	
	@FindBy(id = "Building.MilitaryDiscountInd")
	public WebElement ddMilitaryDiscount; 
	
	@FindBy(id = "Building.OpeningProtectionCd")
	public WebElement ddOpeningProtection; 
	
	@FindBy(id = "Building.RoofShapeCd")
	public WebElement ddRoofShape; 
	
	@FindBy(id = "Building.SecondaryWaterResistanceInd")
	public WebElement ddSecondaryWaterResistance; 
	
	@FindBy(id = "Building.FloodCoverage")
	public WebElement ddFloodCoverage; 
	
	@FindBy(id = "Building.FloodCovALimit")
	public WebElement txtFloodDwellingCovA; 
	
	@FindBy(id = "Building.FloodCovBLimit")
	public WebElement txtFloodPersonalProperty; 

	@FindBy(id = "Building.FloodFoundationType")
	public WebElement ddFloodFoundationType;
	
	@FindBy(id = "Building.FloodZoneOverride")
	public WebElement ddFloodZoneOverride;
	 
	@FindBy(id = "Building.FloodPreferredStatus")
	public WebElement txtFloodPreferredStatus;
	
	@FindBy(id = "Building.FloodSFHAOverride")
	public WebElement ddFloodSFHAOverride;
	
	@FindBy(id = "Building.ElevatedRiskDiscount")
	public WebElement ddElevatedRiskDiscount;
	
	@FindBy(id = "Building.FloodCovADed")
	public WebElement ddFloodCovADed;
	
	@FindBy(id = "Building.BaseFloodElevationOverride")
	public WebElement txtBaseFloodElevationOverride;
	
	@FindBy(id = "Wizard_Worksheets")
	public WebElement btnWorksheets; 
	
	@FindBy(id = "Wizard_Underwriting")
	public WebElement btnUnderwriting; 
	
	@FindBy(id = "Wizard_Risks")
	public WebElement btnDwelling; 
	
	@FindBy(id = "Building.StoryUnit")
	public WebElement ddStoryUnit; 
	
	@FindBy(id = "Building.CovCLimit")
	public WebElement txtPersonalPropertyC; 
	
	@FindBy(id= "Building.WoodBurningStove")
	public WebElement ddWoodBurningStone;
	
	@FindBy(id= "MoreActionsDropdownButton")
	public WebElement btnMore;
	
	@FindBy(id= "Transaction")
	public WebElement btnStartTransaction;
	
	@FindBy(id= "Wizard_Forms")
	public WebElement lnkForms;
	
	public QuoteDwellingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
