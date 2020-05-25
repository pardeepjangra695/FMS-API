package com.trainer.FMS_API.Model;

public class MCDModel {

	private int id;
	private String mcdName;
	private String mcdCode;
	private String state;
	private String createdOn;
	private String updatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMcdName() {
		return mcdName;
	}

	public void setMcdName(String mcdName) {
		this.mcdName = mcdName;
	}

	public String getMcdCode() {
		return mcdCode;
	}

	public void setMcdCode(String mcdCode) {
		this.mcdCode = mcdCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "MCDModel [id=" + id + ", mcdName=" + mcdName + ", mcdCode=" + mcdCode + ", state=" + state
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

}
