package aii.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class WorksheetsChevronPageElements extends CommonMethods {

	@FindBy(xpath="//tr[@class='greenbar']//td[contains(text(),'Initial Base Rate: 353.71<br> - Water Non-Weather ')]")
	public WebElement txtWaterNonWeather;

	@FindBy(xpath="//tr[@class='whitebar']//td[contains(text(),'Initial Base Rate: 50.93<br> - Fire or Lightning T')]")
	public WebElement txtFireLightning;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement txtFireLightning2;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[36]/td[2]/table[1]/tbody[1]/tr[9]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement txtOtherBaseRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[36]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	public WebElement txtWeatherBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea134\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]")
	public WebElement txtWeatherBaseRate2;
	
	@FindBy(xpath="//tr[@class='greenbar']//td[contains(text(),'Initial Base Rate: 2090.44<br> - Hurricane Territo')]")
	public WebElement txtHurricaneBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea137\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]")
	public WebElement txtHurricaneBaseRate2;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[4]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement txtBuildingFloodRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[8]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement txtPersonalPropertyFloodRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[6]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[3]/td[4]")
	public WebElement txtHO6personalPropertyFloodRate;
	
	@FindBy(xpath="//tr[@class='whitebar']//td[contains(text(),'Initial Base Rate: 353.71<br> - Water Non-Weather ')]")
	public WebElement txtHO3NBWaterNonWeather;
	
	//tr[@class='greenbar']//td[contains(text(),'Initial Base Rate: 313.02<br> - Water Non-Weather ')]
	@FindBy(xpath="//tr[@class='greenbar']//td[contains(text(),'Initial Base Rate: 50.93<br> - Fire or Lightning T')]")
	public WebElement txtHO3NBFireLightning;
	
	@FindBy(xpath="//tr[@class='whitebar']//td[contains(text(),'Initial Base Rate: 2090.44<br> - Hurricane Territo')]")
	public WebElement txtHO3NBHurricaneBaseRate;
	
	@FindBy(xpath="//td[normalize-space()='0.0070']")
	public WebElement txtFIGADP3New;
	
	@FindBy(xpath="//td[normalize-space()='0.0200']")
	public WebElement txtFIGADP3Old;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[6]")
	public WebElement txtMHO3NonHurricaneBasePremium;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[6]")
	public WebElement txtMHO3HurricaneBasePremium;	
	
	@FindBy(xpath="imgCovCovArea01")
	public WebElement linkRateAreaHurricane;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr[1]/td/div/table/tbody/tr[4]/td[4]")
	public WebElement HurricaneBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO4HurricaneBasePremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement HO4NonHurricaneBasePremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[4]/td[4]")
	public WebElement HO4NonHurricaneBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[4]/td[4]")
	public WebElement HO4HurricaneBasePremium;

	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[4]/td[6]")
	public WebElement MHO3NonHurricaneBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td[6]")
	public WebElement MHO3HurricaneBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement TOHO3KeyWindRateClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[3]/td[6]")
	public WebElement TOHO3BaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[4]/td[6]")
	public WebElement TOHO3WindExclusionBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[2]/td[6]")
	public WebElement TOMHOBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[3]/td[4]")
	public WebElement TOMHOWindExclusionBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement TODP3ECKeyPremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[6]")
	public WebElement TODP3NonSeasonalBuilding;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[4]/td[4]")
	public WebElement TODP3WindExclusionCreditBuilding;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement TODP1ECKeyPremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[6]")
	public WebElement TODP1SeasonalBuilding;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[4]/td[4]")
	public WebElement TODP1WindExclusionCreditBuilding;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement TOMHPDECFlatPremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[4]/td[4]")
	public WebElement TOMHPDECKeyPremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[5]/td[4]")
	public WebElement TOMHPDECFlatPremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea02\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement VOLDP3HurricaneBuildingCoverageABasePremiumClick;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea02\"]/tbody/tr/td/div/table/tbody/tr[3]/td[4]")
	public WebElement VOLDP3HurricaneCoverageABaseRate;
	
	//input[ends-with(@id,'_name')]
	//input[contains(@id, '_name')]
	//button[starts-with(@id, 'save') and contains(@class,'publish')] 
	//driver.findElements(By.xpath(//*[contains(@id, ‘submit’).get(0).click();
	//input[@type='text'])[2]
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement fireLightningBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea04\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement weatherBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea07\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement hurricaneBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement VOLHO3FireLightningBasePremium;
		
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[4]")
	public WebElement DP1ExtendedCoverageBuildingHurricaneBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[5]/td[4]")
	public WebElement DP1WindHailExclusionCreditRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td/i")
	public WebElement eCBHP;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[3]/td[6]")
	public WebElement tOHO3BaseRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[4]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement HO3elevationRate;

	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[4]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement HO6elevationRate;
	
	@FindBy(id= "Wizard_Worksheets")
	public WebElement lnkWorksheetsChevron;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[2]/td[3]")             
	public WebElement HO6CovA;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[3]/td[3]")
	public WebElement HO6CovB;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[4]/td[3]")
	public WebElement HO6CovC;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[5]/td[3]")
	public WebElement HO6CovD;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[2]/td[6]")
	public WebElement HO3HurricaneDeductible;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[3]/tbody/tr[6]/td[4]")
	public WebElement HO3OrdinanceLaw;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO3CovACoverageList;

	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO3CovBCoverageList;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO3CovCCoverageList;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO3CovDCoverageList;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[16]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO3OrdinanceLawCoverageList;
	 
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[2]/tbody/tr[2]/td[10]")
	public WebElement HO3CovAInflationGuard;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[2]/td[3]")
	public WebElement HO4CovC;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[3]/td[3]")
	public WebElement HO4CovD;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO4CovCCoverageList;
	
	@FindBy(xpath="//*[@id=\"CoverageList\"]/div[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[5]")
	public WebElement HO4CovDCoverageList;
	
	@FindBy(xpath="//*[@id=\"Dwelling Detail\"]/table[1]/tbody/tr[2]/td[9]")
	public WebElement HO4CovAInflationGuard;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO3WNWBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea170\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]/text()[1]")
	public WebElement HO3WNWBaseRateDescription;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO3FireLightningBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement HO3FireLightningBaseRateDescription;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea03\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO3OtherBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea03\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement HO3OtherBaseRateDescription;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea04\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO3WeatherBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea04\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement HO3WeatherBaseRateDescription;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea07\"]/tbody/tr/td/div/table/tbody/tr[2]/td[1]/i")
	public WebElement HO3HurricaneBasePremium;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea07\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	public WebElement HO3HurricaneBaseRateDescription;
	
	
	
	
	
	public WorksheetsChevronPageElements() {
		PageFactory.initElements(driver, this);
	}

}
