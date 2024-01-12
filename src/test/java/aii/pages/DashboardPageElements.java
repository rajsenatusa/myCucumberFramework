package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "Menu_Workflow")
	public WebElement btnHome;

	@FindBy(id = "Menu_Policy")
	public WebElement btnQuotePolicy;

	@FindBy(id = "Menu_Claims")
	public WebElement btnClaims;

	@FindBy(id = "Menu_Cabinets")
	public WebElement btnCabinets;

	@FindBy(id = "Menu_Utility")
	public WebElement btnSupport;

	@FindBy(id = "Menu_Admin")
	public WebElement btnAdmin;
	
	@FindBy(id= "Menu_Policy_NewCustomerAndQuote")
	public WebElement btnNewQuote;
	
	@FindBy(id= "UserMenu")
	public WebElement btnUserMenu;
	
	@FindBy(id= "SignOutInMenu")
	public WebElement btnSignOut;
	
	@FindBy(id= "ToolbarSearchText")
	public WebElement txtSearchBar;
	
	@FindBy(id= "ToolbarSearch")
	public WebElement search;
	
	@FindBy(id= "MoreActionsDropdownButton")
	public WebElement ddMoreOptions;
	
	@FindBy(id= "Transaction")
	public WebElement btnStartTransaction;
	
	@FindBy(id= "TransactionCd")
	public WebElement ddSelectTransaction;
	
	@FindBy(id= "Select")
	public WebElement btnSelect;
		
	@FindBy(id= "TransactionEffectiveDt")
	public WebElement txtSelectDate;
	
	@FindBy(id= "Start")
	public WebElement btnStart;
	
	@FindBy(id="Menu_Admin_ChangeDate")
	public WebElement btnChangeDate;
	
	@FindBy(id="NewDate")
	public WebElement txtNewDate;
	
	@FindBy(id="NewBookDate")
	public WebElement txtNewBookDate;
	
	@FindBy(id="ChangeDate")
	public WebElement btnChangeNewDate;
	
	@FindBy(id="ChangeBookDate")
	public WebElement btnChangeBookDate;
	
	@FindBy(id="QuickAction_NewQuote_Holder")
	public WebElement lnkNewQuote;
	
	@FindBy(id="QuickAction_EffectiveDt")
	public WebElement txtEffectiveDate;
	
	@FindBy(id="QuickAction_StateCd")
	public WebElement ddState;
	
	@FindBy(id="QuickAction_CarrierGroupCd")
	public WebElement ddCarrierGroup;
	
	@FindBy(id= "QuickAction_NewQuote")
	public WebElement btnNewQuoteStart;

	@FindBy(id= "Menu_Admin_UserManagement")
	public WebElement btnUserManagement;
	
	@FindBy(id= "Customer.EntityTypeCd")
	public WebElement ddCustomerEntityType;
	
	@FindBy(xpath="//td[normalize-space()='0.0170']")
	public WebElement fIGADP3New;
	
	@FindBy(xpath="//td[normalize-space()='0.0070']")
	public WebElement fIGADP3Old;
	
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGAHO3New;
	
	@FindBy(xpath="//*[@id=\"rowFee4\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024HO3;
		
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024HO3Worksheets;
	
	@FindBy(id= "Fee_FIGA_TermAmount")
	public WebElement fIGA2024HO3PremiumInfo;
	
	@FindBy(id= "FeeFinalAmt4")
	public WebElement fIGA2024HO3Review;
	
	@FindBy(xpath= "//*[@id=\"rowFees0\"]/tbody/tr[5]/td[2]/table/tbody/tr/td[1]")
	public WebElement fIGA2024DP3Review;
	
	@FindBy(xpath="//td[normalize-space()='0.0070']")
	public WebElement fIGAHO3Old;
	
	@FindBy(xpath="//td[normalize-space()='0.0170']")
	public WebElement fIGADP1New;
	
	@FindBy(xpath="//td[normalize-space()='0.0070']")
	public WebElement fIGADP1Old;
	
	@FindBy(xpath="//*[@id=\"rowFee4\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024DP1Worksheets;
	
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024HO4Worksheets;
	
	@FindBy(xpath= "//*[@id=\"rowFees0\"]/tbody/tr[5]/td[2]/table/tbody/tr/td[1]")
	public WebElement fIGA2024DP1Review;
	
	@FindBy(id= "Fee_FIGA_TermAmount")
	public WebElement fIGA2024HO4PremiumInfo;
	
	@FindBy(id= "FeeFinalAmt4")
	public WebElement fIGA2024HO4Review;
	
	@FindBy(xpath="//*[@id=\"rowFee4\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024HO6Worksheets;
	
	@FindBy(id= "Fee_FIGA_TermAmount")
	public WebElement fIGA2024HO6PremiumInfo;
	
	@FindBy(id= "FeeFinalAmt5")
	public WebElement fIGA2024HO6Review;
		
	@FindBy(xpath="//*[@id=\"rowFee4\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024MHO3Worksheets;
	
	@FindBy(id= "Fee_FIGA_TermAmount")
	public WebElement fIGA2024MHO3PremiumInfo;
	
	@FindBy(id= "FeeFinalAmt5")
	public WebElement fIGA2024MHO3Review;
	
	@FindBy(xpath="//*[@id=\"rowFee1\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024AIBWorksheets;
	
	@FindBy(id= "Fee_FIGA_TermAmount") 
	public WebElement fIGA2024PremiumInfo;
	
	@FindBy(id= "FeeFinalAmt2")
	public WebElement fIGA2024AIBReview;
	
	@FindBy(xpath="//*[@id=\"rowFee2\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024UMBWorksheets;
		
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024TOHO3Worksheets;
		
	@FindBy(id= "FeeFinalAmt4")
	public WebElement fIGA2024TOHO3Review;
	
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024TODP3Worksheets;
	
	@FindBy(id= "FeeFinalAmt4")
	public WebElement fIGA2024TODP3Review;
	
	@FindBy(xpath="//*[@id=\"rowFee3\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024TODP1Worksheets;
	
	@FindBy(id= "FeeFinalAmt4")
	public WebElement fIGA2024TODP1Review;
	
	@FindBy(xpath="//*[@id=\"rowFee2\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024TOMHOWorksheets;
	
	@FindBy(id= "FeeFinalAmt3")
	public WebElement fIGA2024TOMHOReview;
	
	@FindBy(xpath="//*[@id=\"rowFee2\"]/tbody/tr/td/div/table/tbody/tr[2]/td[4]")
	public WebElement fIGA2024TOMHPDWorksheets;
	
	@FindBy(id= "FeeFinalAmt3")
	public WebElement fIGA2024TOMHPDReview;
	
	@FindBy(id= "Delete")
	public WebElement btnDelete;
	
	@FindBy(id= "HomePage-Inbox-Group")
	public WebElement btnInbox;
	
	@FindBy(id= "QuickAction_ReportLoss_Holder")
	public WebElement btnReportLoss;
	
	@FindBy(id= "QuickAction_Report")
	public WebElement btnReport;
	
	@FindBy(id= "Tab_Correspondence")
	public WebElement btnCorrespondence;
	
	@FindBy(id= "Wizard_UmbrellaLiability")
	public WebElement lnkPersonalUmbrellaLiability;
	
	@FindBy(id= "Menu_Policy_UnderwritingMaintenance")
	public WebElement btnUnderwritingMaintenance;
	
	@FindBy(id= "QuoteAppSummary_PremWithTaxesFeesAmt")
	public WebElement premWithTaxesFeesAmt;
	
	@FindBy(id= "QuoteAppSummary_QuoteAppNumber")
	public WebElement quoteAppNumber;
	
	@FindBy(id= "TakeOwnership")
	public WebElement takeOwnership;
	
	@FindBy(id= "dialogOK")
	public WebElement dialogOK;
	
	@FindBy(id= "ReasonCd")
	public WebElement ddreasonCd;
	
	@FindBy(id= "Add")
	public WebElement btnAdd;
	
	@FindBy(id= "Process")
	public WebElement btnProcess;
	
	@FindBy(id= "NoteHolder")
	public WebElement btnNewNote;
	
	@FindBy(id= "Note.TemplateId")
	public WebElement ddNoteTemplate;
	
	@FindBy(id= "Note.PriorityCd")
	public WebElement ddNotePriority;
	
	@FindBy(id= "Note.Memo")
	public WebElement noteMemo;
	
	@FindBy(id= "AddNote")
	public WebElement addNote;
	
	@FindBy(xpath= "//*[@id=\"NotesList\"]/div/table/tbody/tr[2]/td[1]")
	public WebElement btnExpand;
	
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
