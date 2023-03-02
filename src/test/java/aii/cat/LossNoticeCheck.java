package aii.cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import com.google.gson.Gson;


public class LossNoticeCheck {
	protected String cancelledPolicy = "";
	protected String previouslyCompleted = "";
	protected String lossBeforeInception = "";
	protected String missingFields = "";
	protected String lnNotfound = "";
	protected String reportedTo ="";
	
	public boolean confirmLN(String lossNoticeNumber) throws IOException {
		String username = "qatestersvc";
		String password = "qatesterGo#123";
		String body = "{\"lossNoticeNumber\":\""+lossNoticeNumber+"\"}";
	
		URL weburl=new URL("http://ai1qacosa03.aiig.local:8190/quote/claimConfirm");
		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type","application/json");
		conn.setDoOutput(true);
		// snippet begins
		conn.setRequestProperty("Authorization",
		  "Basic " + Base64.getEncoder().encodeToString(
		    (username + ":" + password).getBytes()
		  )
		);
		try(OutputStream os = conn.getOutputStream()) {
		    byte[] input = body.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				    StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				    
				    Gson g = new Gson(); 
				    ClaimsContainerResponse ccr = g.fromJson(response.toString(), ClaimsContainerResponse.class);
				    
				    if(ccr.getReportedTo() != null) {
						  setReportedTo(ccr.getReportedTo());
				    }
				    
				    if(ccr.isCancelledPolicy()) {
					   setCancelledPolicy(ccr.getLossNoticeNumber()+": cancelled policy");
					   return true;
				   }
				   if(ccr.getStatus()!= null) {
					   if(ccr.getStatus().equalsIgnoreCase("Completed")) {
						   setPreviouslyCompleted(ccr.getLossNoticeNumber()+": previously completed");
						   return true;
					   }
				   }
				  if(ccr.isClaimDNE()) {
					  setLnNotfound(ccr.getLossNoticeNumber()+": loss notice not found.");
					  return true;
				  }
				  
				  if(ccr.isLossNoticeBeforeInception()) {
					  setLossBeforeInception(ccr.getLossNoticeNumber()+": loss notice is before policy Inception date.");
					  return true;
				  }
				  
				  if(ccr.isMissingRequiredFields()) {
					  setMissingFields(ccr.getLossNoticeNumber()+": loss notice has missing required fields.");
					  return true;
				  }
				  
				}
		return false;
		
	}
	
	

	public String getCancelledPolicy() {
		return cancelledPolicy;
	}

	public void setCancelledPolicy(String cancelledPolicy) {
		this.cancelledPolicy = cancelledPolicy;
	}

	public String getPreviouslyCompleted() {
		return previouslyCompleted;
	}

	public void setPreviouslyCompleted(String previouslyCompleted) {
		this.previouslyCompleted = previouslyCompleted;
	}

	public String getLossBeforeInception() {
		return lossBeforeInception;
	}

	public void setLossBeforeInception(String lossBeforeInception) {
		this.lossBeforeInception = lossBeforeInception;
	}

	public String getMissingFields() {
		return missingFields;
	}

	public void setMissingFields(String missingFields) {
		this.missingFields = missingFields;
	}

	public String getLnNotfound() {
		return lnNotfound;
	}

	public void setLnNotfound(String lnNotfound) {
		this.lnNotfound = lnNotfound;
	}



	public String getReportedTo() {
		return reportedTo;
	}



	public void setReportedTo(String reportedTo) {
		this.reportedTo = reportedTo;
	}
	
	
}
