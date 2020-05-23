package com.trainer.FMS_API.Model;

public class StateModel {

	private int id;
	private String stateCode;
	private String stateName;
	private String createdOn;
	private String updatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
		return "StateModel [id=" + id + ", stateCode=" + stateCode + ", stateName=" + stateName + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}

}
