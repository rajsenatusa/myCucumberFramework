package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class AIBPageElements extends CommonMethods {

	@FindBy(id= "AddOperator")
	public WebElement btnAddOperator;
	
	@FindBy(id= "DriverInfo.LicensedStateProvCd")
	public WebElement ddLicenseState;
	
	@FindBy(id= "DriverInfo.LicenseNumber")
	public WebElement txtLicenseNumber;
	
	@FindBy(id= "DriverInfo.BoatExp")
	public WebElement ddBoatExperience;
	
	@FindBy(id= "AddBoat")
	public WebElement btnAddBoat;
	
	@FindBy(id= "Vehicle.ModelYr")
	public WebElement txtBoatYear;
	
	@FindBy(id= "Vehicle.VehIdentificationNumber")
	public WebElement txtBoatHinNumber;
	
	@FindBy(id= "Vehicle.Manufacturer")
	public WebElement ddBoatMake;
	
	@FindBy(id= "Vehicle.Model")
	public WebElement txtBoatModel;
	
	@FindBy(id= "Vehicle.BoatPurchaseDate")
	public WebElement txtBoatPurchDate;
	
	@FindBy(id= "Vehicle.BoatFinanced")
	public WebElement ddBoatFinanced;
	
	@FindBy(id= "Vehicle.BoatPurchasePrice")
	public WebElement txtBoatPurchPrice;
	
	@FindBy(id= "Vehicle.HullType")
	public WebElement ddBoatHullType;
	
	@FindBy(id= "Vehicle.HullMaterial")
	public WebElement ddBoatHullMat;
	
	@FindBy(id= "Vehicle.HullLength")
	public WebElement ddHullLength;
	
	@FindBy(id= "Vehicle.DriveSystem")
	public WebElement ddBoatDriveSystem;
	
	@FindBy(id= "Vehicle.MaxSpeed")
	public WebElement ddBoatMaxSpeed;
	
	@FindBy(id= "Vehicle.NumberOfEngines")
	public WebElement ddNumberOfEngines;
	
	@FindBy(id= "Vehicle.BoatHp")
	public WebElement ddBoatHp;
	
	@FindBy(id= "Vehicle.Engine1Year")
	public WebElement txtBoatEngine1Year;
	
	@FindBy(id= "Vehicle.Engine1Make")
	public WebElement txtBoatEngineMake;
	
	@FindBy(id= "Vehicle.Engine1Hp")
	public WebElement txtBoatEngine1Hp;
	
	@FindBy(id= "Vehicle.TrailerCoverage")
	public WebElement ddTrailerCoverage;
	
	@FindBy(id= "Question_VehicleExistingDamage")
	public WebElement ddBoatExistingDamage;
	
	@FindBy(id= "Vehicle.HullSettlement")
	public WebElement ddBoatHullSettle;
	
	@FindBy(id= "Vehicle.BoatStorageType")
	public WebElement ddBoatStorageType;
	
	@FindBy(id= "Line.StorageSlipRental")
	public WebElement ddStorageSlipRental;
	
	@FindBy(id= "Line.MedPayLimit")
	public WebElement ddMedicalPayments;
	
	@FindBy(id= "Line.UMBILimit")
	public WebElement ddUninsuredBoatCov;
	
	@FindBy(id= "Line.SupplementalBoatLiability")
	public WebElement ddSupplementalLiabilityForBoats;
	
	@FindBy(id= "Vehicle.HullDed")
	public WebElement ddHullDeductible;
	
	public AIBPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
