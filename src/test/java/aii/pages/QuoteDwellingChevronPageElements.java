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
	
	@FindBy(id= "QuickEndorsement")
	public WebElement btnEndorsement;
	
	@FindBy(id= "Start")
	public WebElement btnStart;
		
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
	
	@FindBy(id = "Building.PackageCoverageInd_3")
	public WebElement rbGoldReserve;
	
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
	
	@FindBy(id = "Building.FloodCovBLimit")
	public WebElement ddBuildingFloodCovBLimit;
	
	@FindBy(id = "Building.ElevationDocumentation")
	public WebElement ddBuildingElevationDocumentation;
	
	@FindBy(id = "Building.BaseFloodElevationOverride")
	public WebElement txtBaseFloodElevationOverride;
	
	@FindBy(id = "Wizard_Worksheets")
	public WebElement btnWorksheets; 
	
	@FindBy(id = "Wizard_Underwriting")
	public WebElement btnUnderwriting; 
	
	@FindBy(id = "Wizard_Risks")
	public WebElement btnDwelling; 
	
	@FindBy(id = "Tab_Tasks")
	public WebElement btnTasks;
	
	@FindBy(id = "Tab_History")
	public WebElement btnHistory; 
	
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
	
	@FindBy(id= "Building.YearHVACUpdated")
	public WebElement txtYearHVAC;
	
	@FindBy(id= "Building.YearElectricalUpdated")
	public WebElement txtYearElectrical;
	
	@FindBy(id= "Building.CovBLimitIncluded")
	public WebElement ddCovBOtherStructures;
	
	@FindBy(id= "Building.WindHailExcludedInd")
	public WebElement rbWindHailExc;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[2]/td[7]/input")
	public WebElement rbWindHailExc2;
	
	
	@FindBy(id= "Building.AllPerilDed")
	public WebElement ddDeductibleAllPerils;
	
	@FindBy(id= "Closeout")
	public WebElement btnFinalize;
	
	@FindBy(id= "Building.CovELimit")
	public WebElement ddCovELimit;
	
	@FindBy(id= "TakeOwnership")
	public WebElement btnTakeOwnership;
	
	@FindBy(id= "Building.WindHailExcludedInd")
	public WebElement buildingWindHailExcludedInd;
	
	@FindBy(id= "Building.SinkholeDeductible")
	public WebElement ddSinkholeLossDed;
	
	@FindBy(id= "Building.YearRoofMaterialUpdated")
	public WebElement txtRoofMaterialUpdate;
	
	@FindBy(id= "Building.WindHailDeductible")
	public WebElement ddDeductibleWindHail;
	
	@FindBy(id= "Building.DistToCoastRangeName")
	public WebElement ddDistanceToCoast;
	
	@FindBy(id= "Building.YearPlumbingUpdated")
	public WebElement txtPlumbingYearUpdate;
	
	@FindBy(id= "Building.YearHVACUpdated")
	public WebElement txtHvacYearUpdate;
	
	@FindBy(id= "Building.WaterDamageExcludedInd")
	public WebElement rbWaterDamageExcluded;
	
	@FindBy(id= "Building.WaterDamageLimitedInd")
	public WebElement rbWaterDamageLimited;
	
	@FindBy(id= "Building.HomeCyberProtection")
	public WebElement ddHomeCyberProtection;
	
	@FindBy(id= "Building.CovLACLimit")
	public WebElement ddLossAssesment;
	
	@FindBy(id= "Building.RefrigeratedInd")
	public WebElement rbRefrigatedPersonalProperty;
	
	@FindBy(id= "Building.PersonalInjuryInd")
	public WebElement rbPersonalInjury;
	
	@FindBy(id= "Building.CovWBULimit")
	public WebElement ddWaterBackupLimit;
	
	@FindBy(id= "Building.CovSLPLimit")
	public WebElement ddServiceLine;
	
	@FindBy(id= "Building.IncreasedReplacementCostInd")
	public WebElement rbIncreasedDwellingReplacementCost;
	
	@FindBy(id= "Building.SPPInd")
	public WebElement rbSpecialPersonalProperty;
	
	@FindBy(id= "Building.CovHSPLimit")
	public WebElement ddHomeSystemProtection;
	
	@FindBy(id= "Building.CyberProtectionInd")
	public WebElement ddHomeCyberProtectionDwelling;
	
	@FindBy(id= "Building.CovLCARLimit")
	public WebElement ddLimitedCarportsPoolCage;
	
	@FindBy(id= "Building.CovIDRLimit")
	public WebElement ddIdentityRecovery;
	
	@FindBy(id= "Building.OrdinanceOrLawInd")
	public WebElement ddOrdinance;
	
	@FindBy(id= "Building.PPReplacementCostInd")
	public WebElement rbPersonalPropertyReplacementCost;
	
	@FindBy(id= "Building.Theft")
	public WebElement btnLimitedTheft;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[2]/td[9]")
	public WebElement inflationGuardCovA;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[3]/td[3]")
	public WebElement limitCovB;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[4]/td[11]")
	public WebElement inflationGuardCovC;
	
	@FindBy(id= "Building.SinkholeDeductible_text")
	public WebElement sinkholeDeductible;
	
	@FindBy(xpath= "//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[5]")
	public WebElement coverageListCovA;
	
	@FindBy(id= "InflationGuardPct")
	public WebElement DP3InflationGuard; 
	
	@FindBy(id= "Building.CovBLimitIncluded_text")
	public WebElement DP3limitCovB;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[5]/td[3]")
	public WebElement DP3limitCovC;
	
	@FindBy(id= "CovELimit")
	public WebElement DP3CovELimit; 
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[5]/td[2]")
	public WebElement DP3CovE; 
	
	@FindBy(id= "Building.HurricaneDeductible_text")
	public WebElement DP3HurricaneDeductible; 
	
	@FindBy(id= "CoverageList_CovA_Limit1")
	public WebElement DP3CoverageListCovA;
	
	@FindBy(id= "CoverageList_CovB_Limit1")
	public WebElement DP3CoverageListCovB;
	
	@FindBy(id= "CoverageList_CovC_Limit1")
	public WebElement DP3CoverageListCovC;
	
	@FindBy(id= "CoverageList_CovE_Limit1")
	public WebElement DP3CoverageListCovE;
	
	@FindBy(id= "CoverageList_FloodCovA_Limit1")
	public WebElement DP3CoverageListFloodCovA;
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[2]/td[3]")
	public WebElement HO63CovA; 
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[3]/td[3]")
	public WebElement HO63CovC; 
	
	@FindBy(xpath= "//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[4]/td[3]")
	public WebElement HO63CovD; 
	
	@FindBy(id= "OrdOrLawLimit")
	public WebElement HO63OrdOrLaw;
	
	@FindBy(id= "CoverageList_CovA_Limit1")
	public WebElement HO6CoverageListCovA;
	
	@FindBy(id= "CoverageList_CovC_Limit1")
	public WebElement HO6CoverageListCovC;
	
	@FindBy(id= "CoverageList_CovD_Limit1")
	public WebElement HO6CoverageListCovD;
	
	@FindBy(id= "CoverageList_ORD_Limit1")
	public WebElement HO6CoverageListORD;
	
	@FindBy(id= "InflationGuardPct")
	public WebElement HO6InflationGuardPct;
	
	@FindBy(id= "Building.CovALimit_text")
	public WebElement MHOCovA;
	
	@FindBy(id= "CovBLimit")
	public WebElement MHOCovB;
	
	@FindBy(id= "CovCLimit")
	public WebElement MHOCovC;
	
	@FindBy(id= "CovDLimit")
	public WebElement MHOCovD;
	
	@FindBy(id= "CoverageList_CovA_Limit1")
	public WebElement MHO3CoverageListCovA;
	
	@FindBy(id= "CoverageList_CovB_Limit1")
	public WebElement MHO3CoverageListCovB; 
	
	@FindBy(id= "CoverageList_CovC_Limit1")
	public WebElement MHO3CoverageListCovC; 
	
	@FindBy(id= "CoverageList_CovD_Limit1")
	public WebElement MHO3CoverageListCovD; 
	
	@FindBy(id= "InflationGuardPct")
	public WebElement MHOInflationGuard; 
	
	@FindBy(id= "CovALimit_text")
	public WebElement TODP1CovA; 
	
	@FindBy(id= "CovBLimit")
	public WebElement TODP1CovB; 
	
	@FindBy(id= "Building.CovCLimit_text")
	public WebElement TODP1CovC; 
	
	@FindBy(id= "Building.HurricaneDeductible_text")
	public WebElement hurricaneDeductiblePercent;
	
	@FindBy(id= "CoverageList_CovB_Limit1")
	public WebElement coverageListCovB;
	
	@FindBy(id= "CoverageList_CovC_Limit1")
	public WebElement coverageListCovC;
	
	@FindBy(id= "InflationGuardPct")
	public WebElement inflationGuardPct;
	
	@FindBy(id= "Building.CovALimit_text")
	public WebElement TODP3CovA;
	
	@FindBy(id= "CovBLimit")
	public WebElement TODP3CovB;
	
	@FindBy(id= "CovDLimit")
	public WebElement TODP3CovD;
	
	@FindBy(id= "CoverageList_CovD_Limit1")
	public WebElement coverageListCovD; 
	
	@FindBy(id= "Building.CovALimit_text")
	public WebElement TOHO3CovALimit;
	
	@FindBy(id= "CovBLimit")
	public WebElement TOHO3CovBLimit;
	
	@FindBy(id= "CovCLimit")
	public WebElement TOHO3CovCLimit;
	 
	@FindBy(id= "CovDLimit")
	public WebElement TOHO3CovDLimit;
	
	@FindBy(id= "Building.HurricaneDeductible_text")
	public WebElement TOHO3HurricaneDeductiblePercent;
	
	@FindBy(id= "OrdOrLawLimit")
	public WebElement TOHO3OrdOrLawLimit;
	
	@FindBy(id= "Building.SinkholeDeductible_text")
	public WebElement TOHO3SinkholeDeductible;
	
	@FindBy(id= "CoverageList_CovA_Limit1")
	public WebElement TOHO3CovACoverageList;
	
	@FindBy(id= "CoverageList_CovB_Limit1")
	public WebElement TOHO3CovBCoverageList;
	
	@FindBy(id= "CoverageList_CovC_Limit1")
	public WebElement TOHO3CovCCoverageList;
	
	@FindBy(id= "CoverageList_CovD_Limit1")
	public WebElement TOHO3CovDCoverageList;
	
	@FindBy(id= "CoverageList_ORD_Limit1")
	public WebElement TOHO3OrdOrLawLimitCoverageList;
	
	@FindBy(id= "InflationGuardPct")
	public WebElement TOHO3InflationGuardPct;
	
	@FindBy(id= "Building.SeasonalPropertyInd")
	public WebElement seasonalProperty; 
	
	@FindBy(id= "Building.OriginalSystemsInd")
	public WebElement originalSystems; 
	
	@FindBy(id= "Building.CovALimit_text")
	public WebElement covALimit; 
	
	@FindBy(id= "CovBLimit")
	public WebElement covBLimit; 
	
	@FindBy(id= "Building.CovCLimit_text")
	public WebElement covCLimit; 
	
	@FindBy(id= "CovDLimit")
	public WebElement covDLimit; 
	
	@FindBy(id= "dialogOK")
	public WebElement dialogOK;  
	
	@FindBy(id= "Building.LocatedPC10")
	public WebElement ddbuildingLocatedPC10; 
	
	@FindBy(id= "CoverageList_AS_Add")
	public WebElement coverageListASAdd; 
	
	@FindBy(id= "Building.CovLFMLimit")
	public WebElement ddBuildingCovLFMLimit;
	
	@FindBy(id= "ClassCd.Value")
	public WebElement ddClassCdValue;
	
	@FindBy(id= "Year")
	public WebElement year;
	
	@FindBy(id= "Length")
	public WebElement length;
	
	@FindBy(id= "Width")
	public WebElement width;
	
	@FindBy(id= "ItemLimit1.Value")
	public WebElement itemLimit1Value;
	
	@FindBy(id= "AddCoverageItem")
	public WebElement addCoverageItem;
	
	@FindBy(id= "Wizard_Review")
	public WebElement review;
	
	@FindBy(xpath= "//*[@id=\"Price Compare\"]/table/tbody/tr[2]/td[2]/i")
	public WebElement priceCompare;
	
	@FindBy(id= "Building.Acreage")
	public WebElement ddBuildingAcreage;
	
	@FindBy(id= "Wizard_Policy")
	public WebElement policy;
	
	@FindBy(xpath= "//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[13]/td/table/tbody/tr[1]/td[5]")
	public WebElement coverageLimitWBU;
	
	@FindBy(id= "TransactionEffectiveDt")
	public WebElement transactionEffectiveDt;
	
	public QuoteDwellingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
