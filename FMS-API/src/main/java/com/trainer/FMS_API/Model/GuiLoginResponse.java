package com.trainer.FMS_API.Model;

public class GuiLoginResponse {

	private String id;
	private String status;

	public GuiLoginResponse(String id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GuiLoginResponse [id=" + id + ", status=" + status + "]";
	}

}
