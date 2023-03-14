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
	
	
	public QuoteDwellingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
