package com.trainer.FMS_API.Model;

public class ZoneModel {

	private int id;
	private String zoneName;
	private String zoneCode;
	private String mcd;
	private String createdOn;
	private String updatedOn;
	private String txnId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getMcd() {
		return mcd;
	}

	public void setMcd(String mcd) {
		this.mcd = mcd;
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

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@Override
	public String toString() {
		return "ZoneModel [id=" + id + ", zoneName=" + zoneName + ", zoneCode=" + zoneCode + ", mcd=" + mcd
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", txnId=" + txnId + "]";
	}

}
