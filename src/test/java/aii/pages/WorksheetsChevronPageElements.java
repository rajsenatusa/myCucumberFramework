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
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[28]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	public WebElement txtFireLightning2;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[36]/td[2]/table[1]/tbody[1]/tr[9]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
	public WebElement txtOtherBaseRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[36]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	public WebElement txtWeatherBaseRate;
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea134\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]/text()[1]")
	public WebElement txtWeatherBaseRate2;
	
	@FindBy(xpath="//tr[@class='greenbar']//td[contains(text(),'Initial Base Rate: 2090.44<br> - Hurricane Territo')]")
	public WebElement txtHurricaneBaseRate;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[28]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
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
	
	@FindBy(xpath="//tr[@id='rowCovStepSteps-Step-RateArea-1180561273-742792986-HurricaneBasePremium30']//td[4]")
	public WebElement HurricaneBaseRate;
	
	
	@FindBy(xpath="//*[@id=\"rowCovCovArea01\"]/tbody/tr[1]/td/div/table/tbody/tr[2]/td/i")
	public WebElement HO4HurricaneBasePremium;
	
	//input[ends-with(@id,'_name')]
	//input[contains(@id, '_name')]
	//button[starts-with(@id, 'save') and contains(@class,'publish')] 
	//driver.findElements(By.xpath(//*[contains(@id, ‘submit’).get(0).click();
	//input[@type='text'])[2]
	
	//id=imgCovStepSteps-Step-RateArea-277882563-223365633-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-1380412413-1319685168-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-181524148-352482475-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-1695586561-1725427771-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-784394938-630600289-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-705295589-1419944232-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-1720397402-1770554297-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-2020941308-376363097-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-1825599351-14773256-HurricaneBasePremium29
	//id=imgCovStepSteps-Step-RateArea-714824742-287112622-HurricaneBasePremium29
	
	
	
	public WorksheetsChevronPageElements() {
		PageFactory.initElements(driver, this);
	}

}
