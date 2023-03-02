package aii.cat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
    "claimRef",
    "status",
    "claimNumber",
    "cancelledPolicy",
    "lossNoticeNumber",
    "missingRequiredFields",
    "lossNoticeBeforeInception",
    "claimDNE",
    "reportedTo"
  
    
})
@XmlRootElement(name = "ClaimContainerResponse")

public class ClaimsContainerResponse {

	@XmlElement(name = "ClaimRef")
	protected String claimRef;
	@XmlElement(name = "Status")
	protected String status;
	@XmlElement(name = "ClaimNumber")
	protected String claimNumber;
	@XmlElement(name = "CancelledPolicy")
	protected boolean cancelledPolicy;
	@XmlElement(name = "LossNoticeNumber")
	protected String lossNoticeNumber;
	@XmlElement(name = "MissingRequiredFields")
	protected boolean missingRequiredFields;
	@XmlElement(name = "LossNoticeBeforeInception")
	protected boolean lossNoticeBeforeInception;
	@XmlElement(name = "ClaimDNE")
	protected boolean claimDNE;
	//ReportedTo
	@XmlElement(name = "ReportedTo")
	protected String reportedTo;
	public String getClaimRef() {
		return claimRef;
	}
	
	public boolean isLossNoticeBeforeInception() {
		return lossNoticeBeforeInception;
	}

	public void setLossNoticeBeforeInception(boolean lossNoticeBeforeInception) {
		this.lossNoticeBeforeInception = lossNoticeBeforeInception;
	}
	public void setClaimRef(String claimRef) {
		this.claimRef = claimRef;
	}

	public boolean isMissingRequiredFields() {
		return missingRequiredFields;
	}

	public void setMissingRequiredFields(boolean missingRequiredFields) {
		this.missingRequiredFields = missingRequiredFields;
	}

	public boolean isCancelledPolicy() {
		return cancelledPolicy;
	}

	public void setCancelledPolicy(boolean cancelledPolicy) {
		this.cancelledPolicy = cancelledPolicy;
	}

	// Constructor
	public ClaimsContainerResponse() {}
	
	// Methods
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	public String getLossNoticeNumber() {
		return lossNoticeNumber;
	}
	public void setLossNoticeNumber(String lossNoticeNumber) {
		this.lossNoticeNumber = lossNoticeNumber;
	}

	public boolean isClaimDNE() {
		return claimDNE;
	}

	public void setClaimDNE(boolean claimDNE) {
		this.claimDNE = claimDNE;
	}

	public String getReportedTo() {
		return reportedTo;
	}

	public void setReportedTo(String reportedTo) {
		this.reportedTo = reportedTo;
	}
	
}