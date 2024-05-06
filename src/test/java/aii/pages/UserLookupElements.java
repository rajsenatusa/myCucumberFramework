package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import aii.utils.CommonMethods;

public class UserLookupElements extends CommonMethods {
	
	@FindBy (id= "SearchBy")
	public WebElement ddSearchBy;
	
	@FindBy (id= "SearchText")
	public WebElement txtSearchText;
	
	@FindBy (id= "Search")
	public WebElement btnSearch;
	
	@FindBy (id= "SearchUser")
	public WebElement btnUserSearch;
	
	@FindBy (id= "MatchType")
	public WebElement ddStartWith;
	
	@FindBy (linkText= "Reset Password")
	public WebElement lnkResetPassword;
	
	@FindBy (id= "NewPassword")
	public WebElement txtPassword;
	
	@FindBy (id= "ConfirmNewPassword")
	public WebElement txtConfirmPassword;
	
	@FindBy (id= "UserInfo.PasswordMustChangeInd")
	public WebElement chkPasswordChangeNextLogin;
	
	@FindBy (id= "ResetPassword")
	public WebElement btnChangePassword;
	
	@FindBy (id= "Return")
	public WebElement btnReturn;
	
	@FindBy (id= "LoginId")
	public WebElement txtUserId;
	
	@FindBy (id= "UserRolesList")
	public WebElement txtUserRolesList;
	
	@FindBy (id= "OverrideRole_0")
	public WebElement lnkOverride;
	
	@FindBy (id= "OverrideRole_1")
	public WebElement lnkOverride1;
	
	@FindBy (id= "UserRoleAttrValue_2_1")
	public WebElement txtDaysAllowedPayPlan;
	
	@FindBy (id= "UserRoleAttrValue_2_2")
	public WebElement txtNumberAllowedPayPlan;
	
	@FindBy (id= "Save")
	public WebElement btnSave;
	
	@FindBy (xpath= "//td[@title='Allow Pay Plan Change from Policy without transaction']")
	public WebElement txtAllowPayPlanChange;
	
	@FindBy (xpath= "//tbody/tr[755]/td[2]")
	public WebElement txtAllowPayPlanChangeAnswer;
	
	@FindBy(id= "UserRoleAttrValue_7_303")
	public WebElement txtAllowedToAddGolfEndorsement;
	
	@FindBy(id= "UserRoleAttrValue_8_146")
	public WebElement txtAllowUserViewConsentRateFields;
	
	@FindBy(id= "UserRoleAttrValue_8_147")
	public WebElement txtAllowUserEditConsentRateFields;
	
	@FindBy(id= "UserRoleAttrValue_8_170")
	public WebElement txtAllowNumberStoriesEndorsementEdit;
	
	@FindBy(id= "MatchName")
	public WebElement ddFilterType;
	
	@FindBy(id= "SearchName")
	public WebElement txtSearchName;
	
	@FindBy(id= "UserRoleAttrValue_7_462")
	public WebElement txtQuestionMatchingLimit;
	
	@FindBy(id= "UserRoleAttrValue_7_463")
	public WebElement txtQuestionUnusualLiability;
	
	@FindBy(id= "AuthAttrName_7_4")
	public WebElement txtApproveAssistedLivingCareCoverage;
	
	@FindBy(id= "UserRoleAttrValue_7_4")
	public WebElement boxUserRoleAttr74;
	
	@FindBy(id= "AuthAttrName_7_2")
	public WebElement txtCanUserApproveStructureRented;
	
	@FindBy(id= "UserRoleAttrValue_7_2")
	public WebElement boxUserRoleAttr72;
	
	@FindBy(id= "AuthAttrName_7_5")
	public WebElement txtOrdianceLawChange;
	
	@FindBy(id= "UserRoleAttrValue_7_5")
	public WebElement boxUserRoleAttr75;
	
	@FindBy(id= "AuthAttrName_7_11")
	public WebElement txtApproveNoInsuranceScore;
	
	@FindBy(id= "UserRoleAttrValue_7_11")
	public WebElement boxUserRoleAttr711;
	
	@FindBy(id= "AuthAttrName_7_13")
	public WebElement txtAllowedApproveAddressChange;
	
	@FindBy(id= "UserRoleAttrValue_7_13")
	public WebElement boxUserRoleAttr713;
	
	@FindBy(id= "AuthAttrName_7_17")
	public WebElement txtAllowedApproveNameChange;
	
	@FindBy(id= "UserRoleAttrValue_7_17")
	public WebElement boxUserRoleAttr717;
	
	@FindBy(id= "AuthAttrName_7_18")
	public WebElement txtAllowedApproveNewBusiness;
	
	@FindBy(id= "UserRoleAttrValue_7_18")
	public WebElement boxUserRoleAttr718; 
	
	@FindBy(id= "AuthAttrName_7_19")
	public WebElement txtMaximumCoverageAChangeAllowed;
	
	@FindBy(id= "UserRoleAttrValue_7_19")
	public WebElement boxUserRoleAttr719; 
	
	@FindBy(id= "AuthAttrName_7_20")
	public WebElement txtAllowedApproveAddressChange720;
	
	@FindBy(id= "UserRoleAttrValue_7_20")
	public WebElement boxUserRoleAttr720; 
	
	@FindBy(id= "AuthAttrName_7_25")
	public WebElement txtHomeownersAllowedApproveNameChange;
	
	@FindBy(id= "UserRoleAttrValue_7_25")
	public WebElement boxUserRoleAttr725; 
	
	@FindBy(id= "AuthAttrName_7_28")
	public WebElement txtHomeownersMaximumCoverageAChangeAllowed;
	
	@FindBy(id= "UserRoleAttrValue_7_28")
	public WebElement boxUserRoleAttr728;
	
	@FindBy(id= "AuthAttrName_7_53")
	public WebElement txtISOLocationReturnOverride;
	
	@FindBy(id= "UserRoleAttrValue_7_53")
	public WebElement boxUserRoleAttr753;
	
	@FindBy(id= "AuthAttrName_7_56")
	public WebElement txtHomeownersAllowAcreageGreater;
	
	@FindBy(id= "UserRoleAttrValue_7_56")
	public WebElement boxUserRoleAttr756;
	
	@FindBy(id= "AuthAttrName_7_77")
	public WebElement txtHomeownersApproveDeleteSinkhole;
	
	@FindBy(id= "UserRoleAttrValue_7_77")
	public WebElement boxUserRoleAttr777;
	
	@FindBy(id= "AuthAttrName_7_78")
	public WebElement txtMaximumNumberofDays;
	
	@FindBy(id= "UserRoleAttrValue_7_78")
	public WebElement boxUserRoleAttr778;
	
	@FindBy(id= "AuthAttrName_7_81")
	public WebElement txtAllowApproveCapacityminimumCoverageA;
	
	@FindBy(id= "UserRoleAttrValue_7_81")
	public WebElement boxUserRoleAttr781;
	
	@FindBy(id= "AuthAttrName_7_87")
	public WebElement txtAllowApproveCapacityLossCauses;
	
	@FindBy(id= "UserRoleAttrValue_7_87")
	public WebElement boxUserRoleAttr787;
	
	@FindBy(id= "AuthAttrName_7_97")
	public WebElement txtApproveHVACUpdate;
	
	@FindBy(id= "UserRoleAttrValue_7_97")
	public WebElement boxUserRoleAttr797;
	
	@FindBy(id= "AuthAttrName_7_98")
	public WebElement txtAllowApproveAgePlumbing;
	
	@FindBy(id= "UserRoleAttrValue_7_98")
	public WebElement boxUserRoleAttr798;
	
	@FindBy(id= "AuthAttrName_7_99")
	public WebElement txtApproveElectricalUpdate;
	
	@FindBy(id= "UserRoleAttrValue_7_99")
	public WebElement boxUserRoleAttr799;
	
	@FindBy(id= "AuthAttrName_7_106")
	public WebElement txtCondoMaximumCoverageACchanged;
	
	@FindBy(id= "UserRoleAttrValue_7_106")
	public WebElement boxUserRoleAttr7106; 
	
	@FindBy(id= "AuthAttrName_7_117")
	public WebElement txtCondoApproveselectedwindexclusion;
	
	@FindBy(id= "UserRoleAttrValue_7_117")
	public WebElement boxUserRoleAttr7117; 
	
	@FindBy(id= "AuthAttrName_7_119")
	public WebElement txtCondoAllowedApproveAgeSystems;
	
	@FindBy(id= "UserRoleAttrValue_7_119")
	public WebElement boxUserRoleAttr7119; 
	
	@FindBy(id= "AuthAttrName_7_127")
	public WebElement txtDwellingAllowedApproveShortTermRental;
	
	@FindBy(id= "UserRoleAttrValue_7_127")
	public WebElement boxUserRoleAttr7127; 
	
	@FindBy(id= "AuthAttrName_7_130")
	public WebElement txtDwellingMaximumCondoUnitOwner;
	
	@FindBy(id= "UserRoleAttrValue_7_130")
	public WebElement boxUserRoleAttr7130; 
	
	@FindBy(id= "AuthAttrName_7_132")
	public WebElement txtAllowApproveLeaseTerm;
	
	@FindBy(id= "UserRoleAttrValue_7_132")
	public WebElement boxUserRoleAttr7132; 
	
	@FindBy(id= "AuthAttrName_7_143")
	public WebElement txtDwellingDP1Approveselectedwindexclusion;
	
	@FindBy(id= "UserRoleAttrValue_7_143")
	public WebElement boxUserRoleAttr7143; 
	
	@FindBy(id= "AuthAttrName_7_145")
	public WebElement txtAllowApproveChangeVandalism;
	
	@FindBy(id= "UserRoleAttrValue_7_145")
	public WebElement boxUserRoleAttr7145; 
	
	@FindBy(id= "AuthAttrName_7_148")
	public WebElement txtDwellingMaximumCoverageAChangeDP1;
	
	@FindBy(id= "UserRoleAttrValue_7_148")
	public WebElement boxUserRoleAttr7148; 
	
	@FindBy(id= "AuthAttrName_7_160")
	public WebElement txtMobileHomeMaximumCoverageAChange;
	
	@FindBy(id= "UserRoleAttrValue_7_160")
	public WebElement boxUserRoleAttr7160; 
	
	@FindBy(id= "AuthAttrName_7_171")
	public WebElement txtPersonalUmbrellaAllowedApproveNewBusiness;
	
	@FindBy(id= "UserRoleAttrValue_7_171")
	public WebElement boxUserRoleAttr7171; 
	
	@FindBy(id= "AuthAttrName_7_308")
	public WebElement txtFloodZoneOverride;
	
	@FindBy(id= "UserRoleAttrValue_7_308")
	public WebElement boxUserRoleAttr7308; 
	
	@FindBy(id= "AuthAttrName_7_315")
	public WebElement txtAllowPlumbingYearApproval;
	
	@FindBy(id= "UserRoleAttrValue_7_315")
	public WebElement boxUserRoleAttr7315; 
	 
	@FindBy(id= "AuthAttrName_7_498")
	public WebElement txtCondoAllowedApproveMonthlyRental;
	
	@FindBy(id= "UserRoleAttrValue_7_498")
	public WebElement boxUserRoleAttr7498; 
	
	@FindBy(id= "AuthAttrName_8_4")
	public WebElement txtAllowApplicationTakeOwnership;
	
	@FindBy(id= "UserRoleAttrValue_8_4")
	public WebElement boxUserRoleAttr84; 
	
	@FindBy(id= "AuthAttrName_8_27")
	public WebElement txtAllowOverrideLatLongEdit;
	
	@FindBy(id= "UserRoleAttrValue_8_27")
	public WebElement boxUserRoleAttr827; 
	
	@FindBy(id= "AuthAttrName_8_42")
	public WebElement txtAllowQuoteTakeOwnership;
	
	@FindBy(id= "UserRoleAttrValue_8_42")
	public WebElement boxUserRoleAttr842; 
	
	@FindBy(id= "AuthAttrName_8_59")
	public WebElement txtAllowRewriteNew;
	
	@FindBy(id= "UserRoleAttrValue_8_59")
	public WebElement boxUserRoleAttr859; 
	
	@FindBy(id= "AuthAttrName_8_92")
	public WebElement txtAllowProtectionClassOverride;
	
	@FindBy(id= "UserRoleAttrValue_8_92")
	public WebElement boxUserRoleAttr892; 
	
	@FindBy(id= "AuthAttrName_8_95")
	public WebElement txtAllowBCEGOverride;
	
	@FindBy(id= "UserRoleAttrValue_8_95")
	public WebElement boxUserRoleAttr895; 
	
	@FindBy(id= "AuthAttrName_8_96")
	public WebElement txtAllowEditISOLocationFields;
	
	@FindBy(id= "UserRoleAttrValue_8_96")
	public WebElement boxUserRoleAttr896; 
	
	@FindBy(id= "AuthAttrName_8_101")
	public WebElement txtAllowEditYearBuilt;
	
	@FindBy(id= "UserRoleAttrValue_8_101")
	public WebElement boxUserRoleAttr8101; 
	
	@FindBy(id= "AuthAttrName_8_110")
	public WebElement txtTOApproveYOCChg;
	
	@FindBy(id= "UserRoleAttrValue_8_110")
	public WebElement boxUserRoleAttr8110; 
	
	@FindBy(id= "AuthAttrName_8_123")
	public WebElement txtMaximumForwardDateChange;
	
	@FindBy(id= "UserRoleAttrValue_8_123")
	public WebElement boxUserRoleAttr8123; 
	
	@FindBy(id= "AuthAttrName_8_124")
	public WebElement txtMAllowEditDwellingAddress;
	
	@FindBy(id= "UserRoleAttrValue_8_124")
	public WebElement boxUserRoleAttr8124; 
	
	@FindBy(id= "AuthAttrName_8_125")
	public WebElement txtAllowOrdinanceOrLawChange;
	
	@FindBy(id= "UserRoleAttrValue_8_125")
	public WebElement boxUserRoleAttr8125; 
	
	@FindBy(id= "AuthAttrName_8_128")
	public WebElement txtAllowViewLossHistoryHiddenDetails;
	
	@FindBy(id= "UserRoleAttrValue_8_128")
	public WebElement boxUserRoleAttr8128; 
	
	@FindBy(id= "AuthAttrName_8_132")
	public WebElement txtAllowViewEditBookTransferfield;
	
	@FindBy(id= "UserRoleAttrValue_8_132")
	public WebElement boxUserRoleAttr8132; 
	
	@FindBy(id= "AuthAttrName_8_150")
	public WebElement txtHO6ByPassInsuranceScoreApply;
	
	@FindBy(id= "UserRoleAttrValue_8_150")
	public WebElement boxUserRoleAttr8150;
	
	@FindBy(id= "AuthAttrName_8_167")
	public WebElement txtAllowCoastalZoneEdit;
	
	@FindBy(id= "UserRoleAttrValue_8_167")
	public WebElement boxUserRoleAttr8167;
	
	@FindBy(id= "AuthAttrName_18_6")
	public WebElement txtRolesAbleApproveCapacit;
	
	@FindBy(id= "UserRoleAttrValue_18_6")
	public WebElement boxUserRoleAttr186;
	
	 
	
	
	
	
	public UserLookupElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
