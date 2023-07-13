package aii.testbase;
import aii.pages.AIBPageElements;
import aii.pages.CloseOutChevronPageElements;
import aii.pages.DashboardPageElements;
import aii.pages.GolfcartChevronPageElements;
import aii.pages.HistoryPageElements;
import aii.pages.LoginPageElements;
import aii.pages.LossNoticeInformationPageElements;
import aii.pages.MakePaymentElement;
import aii.pages.PolicyFilePageElements;
import aii.pages.QuoteCustomerSetupPageElements;
import aii.pages.QuoteDwellingChevronPageElements;
import aii.pages.QuotePolicyChevronPageElements;
import aii.pages.QuoteProductSelectionPageElements;
import aii.pages.QuoteReviewPageElements;
import aii.pages.SpecialOptionsPageElements;
import aii.pages.ToolBarHolderElements;
import aii.pages.UmbrellaLiabilityPageElements;
import aii.pages.UserLookupElements;
import aii.pages.UwQuestionsPageElements;
import aii.pages.WorksheetsChevronPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static QuoteCustomerSetupPageElements quote;
	public static QuoteProductSelectionPageElements product;
	public static QuotePolicyChevronPageElements policyChevron;
	public static QuoteDwellingChevronPageElements dwellingChevron;
	public static QuoteReviewPageElements reviewChevron;
	public static UwQuestionsPageElements uwquestionsChevron;
	public static CloseOutChevronPageElements closeoutChevron;
	public static GolfcartChevronPageElements golfcartChevron;
	public static AIBPageElements aibChevron;
	public static SpecialOptionsPageElements specialChevron;
	public static UmbrellaLiabilityPageElements umbrellaChevron;
	public static PolicyFilePageElements policyFileChevron;
	public static HistoryPageElements historyChevron;
	public static MakePaymentElement makePayment;
	public static ToolBarHolderElements holder;
	public static LossNoticeInformationPageElements lossNoticeInfo;
	public static UserLookupElements userLookup;
	public static WorksheetsChevronPageElements worksheetsChevron;
	
	
	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		quote= new QuoteCustomerSetupPageElements();
		product= new QuoteProductSelectionPageElements();
		policyChevron= new QuotePolicyChevronPageElements();
		dwellingChevron= new QuoteDwellingChevronPageElements();
		reviewChevron= new QuoteReviewPageElements();
		uwquestionsChevron= new UwQuestionsPageElements();
		closeoutChevron= new CloseOutChevronPageElements();
		golfcartChevron= new GolfcartChevronPageElements();
		aibChevron= new AIBPageElements();
		specialChevron= new SpecialOptionsPageElements();
		umbrellaChevron= new UmbrellaLiabilityPageElements();
		policyFileChevron= new PolicyFilePageElements();
		historyChevron= new HistoryPageElements();
		makePayment= new MakePaymentElement();
		holder= new ToolBarHolderElements();
		lossNoticeInfo= new LossNoticeInformationPageElements();
		userLookup= new UserLookupElements();
		worksheetsChevron= new WorksheetsChevronPageElements();
	}

}
