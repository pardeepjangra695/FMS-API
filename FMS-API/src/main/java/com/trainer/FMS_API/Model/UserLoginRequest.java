package com.trainer.FMS_API.Model;

public class UserLoginRequest {

	private String msisdn;
	private String fcmId;
	private String osUser;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getFcmId() {
		return fcmId;
	}

	public void setFcmId(String fcmId) {
		this.fcmId = fcmId;
	}

	public String getOsUser() {
		return osUser;
	}

	public void setOsUser(String osUser) {
		this.osUser = osUser;
	}

	@Override
	public String toString() {
		return "UserLoginRequest [msisdn=" + msisdn + ", fcmId=" + fcmId + ", osUser=" + osUser + "]";
	}

}
