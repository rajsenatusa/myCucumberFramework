package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class AIBPageElements extends CommonMethods {

	@FindBy(id= "AddOperator")
	public WebElement addOperator;
	
	@FindBy(id= "DriverInfo.LicensedStateProvCd")
	public WebElement licenseState;
	
	@FindBy(id= "DriverInfo.LicenseNumber")
	public WebElement licenseNumber;
	
	@FindBy(id= "DriverInfo.BoatExp")
	public WebElement boatExperience;
	
	@FindBy(id= "AddBoat")
	public WebElement addBoat;
	
	@FindBy(id= "Vehicle.ModelYr")
	public WebElement boatYear;
	
	@FindBy(id= "Vehicle.VehIdentificationNumber")
	public WebElement boatHinNumber;
	
	@FindBy(id= "Vehicle.Manufacturer")
	public WebElement boatMake;
	
	@FindBy(id= "Vehicle.Model")
	public WebElement boatModel;
	
	@FindBy(id= "Vehicle.BoatPurchaseDate")
	public WebElement boatPurchDate;
	
	@FindBy(id= "Vehicle.BoatFinanced")
	public WebElement boatFinanced;
	
	@FindBy(id= "Vehicle.BoatPurchasePrice")
	public WebElement boatPurchPrice;
	
	@FindBy(id= "Vehicle.HullType")
	public WebElement boatHullType;
	
	@FindBy(id= "Vehicle.HullMaterial")
	public WebElement boatHullMat;
	
	@FindBy(id= "Vehicle.HullLength")
	public WebElement hullLength;
	
	@FindBy(id= "Vehicle.DriveSystem")
	public WebElement boatDriveSystem;
	
	@FindBy(id= "Vehicle.MaxSpeed")
	public WebElement boatMaxSpeed;
	
	@FindBy(id= "Vehicle.NumberOfEngines")
	public WebElement numberOfEngines;
	
	@FindBy(id= "Vehicle.BoatHp")
	public WebElement boatHp;
	
	@FindBy(id= "Vehicle.Engine1Year")
	public WebElement boatEngine1Year;
	
	@FindBy(id= "Vehicle.Engine1Make")
	public WebElement boatEngineMake;
	
	@FindBy(id= "Vehicle.Engine1Hp")
	public WebElement boatEngine1Hp;
	
	@FindBy(id= "Vehicle.TrailerCoverage")
	public WebElement trailerCoverage;
	
	@FindBy(id= "Question_VehicleExistingDamage")
	public WebElement boatExistingDamage;
	
	@FindBy(id= "Vehicle.HullSettlement")
	public WebElement boatHullSettle;
	
	@FindBy(id= "Vehicle.BoatStorageType")
	public WebElement boatStorageType;
	
	public AIBPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
