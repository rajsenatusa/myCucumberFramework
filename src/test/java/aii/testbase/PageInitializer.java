package aii.testbase;
import aii.pages.DashboardPageElements;
import aii.pages.LoginPageElements;
import aii.pages.ProductSelectionPageElements;
import aii.pages.QuotePageElements;
import aii.pages.QuotePolicyChevronPageElements;


public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static QuotePageElements quote;
	public static ProductSelectionPageElements product;
	public static QuotePolicyChevronPageElements policyChevron;
	
	

	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		quote= new QuotePageElements();
		product= new ProductSelectionPageElements();
		policyChevron= new QuotePolicyChevronPageElements();
		
	}

}
