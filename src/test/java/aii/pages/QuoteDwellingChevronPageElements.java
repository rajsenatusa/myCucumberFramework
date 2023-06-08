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
	public WebElement radioBasicPackage;
	
	@FindBy(id= "Building.PackageCoverageInd_2")
	public WebElement radioIntegritySelectPackage;
	
	@FindBy(id= "Building.CovCLimitIncluded")
	public WebElement ddCovCLimit;
	
	@FindBy(id= "Building.CovLLimit")
	public WebElement ddCovLLimit;
	
	@FindBy(id= "Building.CovHCCLimit")
	public WebElement ddHomeComputerLimit;
	
	@FindBy(id= "Building.BCEGCd")
	public WebElement bCEG;
	
	@FindBy(id= "Building.NumberOfStories")
	public WebElement numberOfStories;
	
	@FindBy(id = "Building.FireplaceInd")
	public WebElement firePlace;
	
	@FindBy(id = "Building.ExteriorWalls")
	public WebElement exteriorWalls;
	
	@FindBy(id = "Building.PackageCoverageInd_2")
	public WebElement silverReserve;
	
	@FindBy(id = "Building.CovALimit")
	public WebElement covALimit;
	
	@FindBy(id = "Building.AnimalLiability")
	public WebElement animalLiability;
	
	@FindBy(id = "Building.FireAlarmCd")
	public WebElement fireAlarm;
	
	@FindBy(id = "Building.SprinklerSystemCd")
	public WebElement sprinklerSystem; 
	
	@FindBy(id = "Building.BurglarAlarmCd")
	public WebElement burglarAlarm; 
	
	@FindBy(id = "Building.SecuredCommunityCd")
	public WebElement securedCommunity; 
	
	@FindBy(id = "Building.MilitaryDiscountInd")
	public WebElement militaryDiscount; 
	
	@FindBy(id = "Building.OpeningProtectionCd")
	public WebElement openingProtection; 
	
	@FindBy(id = "Building.RoofShapeCd")
	public WebElement roofShape; 
	
	@FindBy(id = "Building.SecondaryWaterResistanceInd")
	public WebElement secondaryWaterResistance; 
	
	@FindBy(id = "Building.FloodCoverage")
	public WebElement floodCoverage; 
	
	@FindBy(id = "Building.FloodCovALimit")
	public WebElement floodDwelling; 
	
	@FindBy(id = "Building.FloodCovBLimit")
	public WebElement floodPersonalProperty; 

	@FindBy(id = "Building.FloodFoundationType")
	public WebElement floodFoundationType;
	
	@FindBy(id = "Building.FloodZoneOverride")
	public WebElement floodZoneOverride;
	 
	@FindBy(id = "Building.FloodPreferredStatus")
	public WebElement floodPreferredStatus;
	
	@FindBy(id = "Building.FloodSFHAOverride")
	public WebElement floodSFHAOverride;
	
	@FindBy(id = "Building.ElevatedRiskDiscount")
	public WebElement elevatedRiskDiscount;
	
	@FindBy(id = "Building.FloodCovADed")
	public WebElement floodCovADed;
	
	@FindBy(id = "Building.BaseFloodElevationOverride")
	public WebElement baseFloodElevationOverride;
	
	@FindBy(id = "Wizard_Worksheets")
	public WebElement worksheets; 
	
	@FindBy(id = "Wizard_Risks")
	public WebElement dwelling; 
	
	@FindBy(id = "Building.StoryUnit")
	public WebElement storyUnit; 
	
	@FindBy(id = "Building.CovCLimit")
	public WebElement cPersonalProperty; 
	
	public QuoteDwellingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
