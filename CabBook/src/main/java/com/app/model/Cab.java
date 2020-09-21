package com.app.model;

public class Cab {

	private String cabId;
	private String driverName;
	private boolean available;
	private CabLocation currentLocation;
	private Trip currentTrip;
	
	public Cab() {
	}
	public Cab(String cabId, String driverName) {
	    this.cabId = cabId;
	    this.driverName = driverName;
	    this.available = true;
	  }
	public String getCabId() {
		return cabId;
	}
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}
	public boolean isAvailable() {
		return available;
	}
	public CabLocation getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(CabLocation loc) {
		this.currentLocation = loc;
	}
	public Trip getCurrentTrip() {
		return currentTrip;
	}
	public void setCurrentTrip(Trip currentTrip) {
		this.currentTrip = currentTrip;
	}
}
