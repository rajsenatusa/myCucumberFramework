package aii.testbase;
import aii.pages.DashboardPageElements;
import aii.pages.LoginPageElements;


public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	

	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		
	}

}
