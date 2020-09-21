package com.app.model;

public class Rider {

	private String riderId;
	private String riderName;

	public Rider() {
	}

	public Rider(String riderId, String riderName) {
		this.riderId = riderId;
		this.riderName = riderName;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	@Override
	public String toString() {
		return "Rider [riderId=" + riderId + ", riderName=" + riderName + "]";
	}

}
