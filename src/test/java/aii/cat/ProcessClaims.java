package aii.cat;

import java.net.URL;
import java.net.UnknownHostException;
import java.net.HttpURLConnection;

public class ProcessClaims {
	protected static LNStatUtils utils=null;
	
	
	public static void main(String[] args) {
		utils = new LNStatUtils();
		
		if(args.length != 0&&!args[0].equals("")&&args[0].equals("portal")) {
			LNStatUtils.setPortalRun(true);
			System.out.println("Running LN to CLAIM conversion job for only portal.");
		}else {
			System.out.println("Running LN to CLAIM conversion job for all.");
		}
				
	try {

		URL obj = new URL(utils.getNetworkPath());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			System.out.println("You're on the network");
			LNStatUtils.processOnNetwork(); 
			// print result
		} else {
			System.out.println("You're not on the network. Your process of LNs will be slower with less detailed results.");
			try {
				
				LNStatUtils.processOffNetwork();
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
	}catch(UnknownHostException hostE) {
		hostE.printStackTrace();
		System.out.println("You're not on the network. So your process of LNs will be slower with less detailed results.");
		try {
			LNStatUtils.processOffNetwork();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	
}