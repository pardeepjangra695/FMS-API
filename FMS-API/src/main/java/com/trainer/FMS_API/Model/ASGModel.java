package com.trainer.FMS_API.Model;

public class ASGModel {

	private String asgName;
	private String email;
	private String  mobile;
	private String zone;
	private String subject;
	private String createdon;
	private String modifiedon;
	private String txnId;

	public String getAsgName() {
		return asgName;
	}

	public void setAsgName(String asgName) {
		this.asgName = asgName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(String modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@Override
	public String toString() {
		return "ASGModel [asgName=" + asgName + ", email=" + email + ", mobile=" + mobile + ", zone=" + zone
				+ ", subject=" + subject + ", createdon=" + createdon + ", modifiedon=" + modifiedon + ", txnId="
				+ txnId + "]";
	}

}
