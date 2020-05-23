package com.trainer.FMS_API.Model;

public class UserLoginResponse {

	private String name;
	private String msisdn;
	private String email;
	private String subject;
	private String school;
	private String zone;
	private String txnId;
	private boolean usertype;

	public UserLoginResponse(String name, String msisdn, String email, String subject, String school, String zone,
			String txnId, boolean usertype) {
		super();
		this.name = name;
		this.msisdn = msisdn;
		this.email = email;
		this.subject = subject;
		this.school = school;
		this.zone = zone;
		this.txnId = txnId;
		this.usertype = usertype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public boolean isUsertype() {
		return usertype;
	}

	public void setUsertype(boolean usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserLoginResponse [name=" + name + ", msisdn=" + msisdn + ", email=" + email + ", subject=" + subject
				+ ", school=" + school + ", zone=" + zone + ", txnId=" + txnId + ", usertype=" + usertype + "]";
	}

}
