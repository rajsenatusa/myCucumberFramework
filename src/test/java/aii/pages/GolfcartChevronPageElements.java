package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class GolfcartChevronPageElements extends CommonMethods {
	
	@FindBy(id= "Line.LimitType")
	public WebElement ddLiabilityCovType;
	
	@FindBy(id= "Line.BILimit")
	public WebElement ddBodilyInjuryPerson;
	
	@FindBy(id= "Line.PDLimit")
	public WebElement ddPropertyDamageLimit;
	
	@FindBy(id= "Line.MedPayLimit")
	public WebElement ddMedicalPaymentLimit;
	
	@FindBy(id= "Line.UMBILimit")
	public WebElement ddUninsuredInjury;
	
	@FindBy(id= "AddDriver")
	public WebElement btnAddDriver;
	
	@FindBy(id= "PersonInfo.MaritalStatusCd")
	public WebElement ddDriverMaritalStatus;
	
	@FindBy(id= "DriverInfo.LicenseInd")
	public WebElement ddDriverLicenseInd;
	
	@FindBy(id= "DriverInfo.GolfCartExp")
	public WebElement ddDriverGcExp;
	
	@FindBy(id= "DriverInfo.DriverTrainingInd")
	public WebElement ddDriverTrainingInd;
	
	@FindBy(id= "NextPage_Bottom")
	public WebElement btnNextGocScreen;
	
	@FindBy(id= "AddGolfCart")
	public WebElement btnAddGolfcart;
	
	@FindBy(id= "Vehicle.ModelYr")
	public WebElement txtModelYear;
	
	@FindBy(id= "Vehicle.Manufacturer")
	public WebElement txtGcMake;
	
	@FindBy(id= "Vehicle.Model")
	public WebElement txtGcModel;
	
	@FindBy(id= "Vehicle.PowerTypeCd")
	public WebElement ddGcPowerType;
	
	@FindBy(id= "Vehicle.MaxSpeed")
	public WebElement ddGcMaxSpeed;
	
	@FindBy(id= "Vehicle.SeatbeltsInd")
	public WebElement ddVehicleSeatbelts;
	
	@FindBy(id= "Vehicle.ComprehensiveDed")
	public WebElement ddOtherCollisionDed;
	
	@FindBy(id= "Vehicle.CollisionDed")
	public WebElement ddCollisionDed;
	
	@FindBy(id= "Question_VehicleExistingDamage")
	public WebElement ddGcExistingDamage;
	
	@FindBy(id= "Vehicle.CostNewAmt")
	public WebElement txtGcMarketValue;
	
	@FindBy(id= "Vehicle.VehIdentificationNumber")
	public WebElement txtGcVinNumber;
	
	public GolfcartChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}
	

}
