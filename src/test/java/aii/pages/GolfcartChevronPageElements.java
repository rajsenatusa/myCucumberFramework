package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class GolfcartChevronPageElements extends CommonMethods {
	
	@FindBy(id= "Line.LimitType")
	public WebElement liabilityCovType;
	
	@FindBy(id= "Line.BILimit")
	public WebElement bodilyInjuryPerson;
	
	@FindBy(id= "Line.PDLimit")
	public WebElement propertyDamageLimit;
	
	@FindBy(id= "Line.MedPayLimit")
	public WebElement medicalPaymentLimit;
	
	@FindBy(id= "Line.UMBILimit")
	public WebElement uninsuredInjury;
	
	@FindBy(id= "AddDriver")
	public WebElement addDriver;
	
	@FindBy(id= "PersonInfo.MaritalStatusCd")
	public WebElement driverMaritalStatus;
	
	@FindBy(id= "DriverInfo.LicenseInd")
	public WebElement driverLicenseInd;
	
	@FindBy(id= "DriverInfo.GolfCartExp")
	public WebElement driverGcExp;
	
	@FindBy(id= "DriverInfo.DriverTrainingInd")
	public WebElement driverTrainingInd;
	
	@FindBy(id= "NextPage_Bottom")
	public WebElement nextGocScreen;
	
	@FindBy(id= "AddGolfCart")
	public WebElement addGolfcart;
	
	@FindBy(id= "Vehicle.ModelYr")
	public WebElement modelYear;
	
	@FindBy(id= "Vehicle.Manufacturer")
	public WebElement gcMake;
	
	@FindBy(id= "Vehicle.Model")
	public WebElement gcModel;
	
	@FindBy(id= "Vehicle.PowerTypeCd")
	public WebElement gcPowerType;
	
	@FindBy(id= "Vehicle.MaxSpeed")
	public WebElement gcMaxSpeed;
	
	@FindBy(id= "Vehicle.SeatbeltsInd")
	public WebElement vehicleSeatbelts;
	
	@FindBy(id= "Vehicle.ComprehensiveDed")
	public WebElement otherCollisionDed;
	
	@FindBy(id= "Vehicle.CollisionDed")
	public WebElement collisionDed;
	
	@FindBy(id= "Question_VehicleExistingDamage")
	public WebElement gcExistingDamage;
	
	@FindBy(id= "Vehicle.CostNewAmt")
	public WebElement gcMarketValue;
	
	@FindBy(id= "Vehicle.VehIdentificationNumber")
	public WebElement gcVinNumber;
	
	public GolfcartChevronPageElements() {
		
		PageFactory.initElements(driver, this);
	}
	

}
