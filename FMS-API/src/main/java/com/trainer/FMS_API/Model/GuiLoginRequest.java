package com.trainer.FMS_API.Model;

public class GuiLoginRequest {

	private String emial;
	private String password;
	private String userType;
	private String msisdn;

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Override
	public String toString() {
		return "GuiLoginRequest [emial=" + emial + ", password=" + password + ", userType=" + userType + ", msisdn="
				+ msisdn + "]";
	}

}
