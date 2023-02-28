package aii.testbase;
import aii.pages.AIBPageElements;
import aii.pages.ApplicationUwQuestionsPageElements;
import aii.pages.CloseOutChevronPageElements;
import aii.pages.DashboardPageElements;
import aii.pages.GolfcartChevronPageElements;
import aii.pages.LoginPageElements;
import aii.pages.PolicyFilePageElements;
import aii.pages.ProductSelectionPageElements;
import aii.pages.QuoteDwellingChevronPageElements;
import aii.pages.QuotePageElements;
import aii.pages.QuotePolicyChevronPageElements;
import aii.pages.QuoteReviewPageElements;
import aii.pages.SpecialOptionsPageElements;
import aii.pages.UmbrellaLiabilityPageElements;


public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static QuotePageElements quote;
	public static ProductSelectionPageElements product;
	public static QuotePolicyChevronPageElements policyChevron;
	public static QuoteDwellingChevronPageElements dwellingChevron;
	public static QuoteReviewPageElements reviewChevron;
	public static ApplicationUwQuestionsPageElements uwquestionsChevron;
	public static CloseOutChevronPageElements closeoutChevron;
	public static GolfcartChevronPageElements golfcartChevron;
	public static AIBPageElements aibChevron;
	public static SpecialOptionsPageElements specialChevron;
	public static UmbrellaLiabilityPageElements umbrellaChevron;
	public static PolicyFilePageElements policyFileChevron;
	
	

	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		quote= new QuotePageElements();
		product= new ProductSelectionPageElements();
		policyChevron= new QuotePolicyChevronPageElements();
		dwellingChevron= new QuoteDwellingChevronPageElements();
		reviewChevron= new QuoteReviewPageElements();
		uwquestionsChevron= new ApplicationUwQuestionsPageElements();
		closeoutChevron= new CloseOutChevronPageElements();
		golfcartChevron= new GolfcartChevronPageElements();
		aibChevron= new AIBPageElements();
		specialChevron= new SpecialOptionsPageElements();
		umbrellaChevron= new UmbrellaLiabilityPageElements();
		policyFileChevron= new PolicyFilePageElements();
		
	}

}
