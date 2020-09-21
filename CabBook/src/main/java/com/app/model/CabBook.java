package com.app.model;

public class CabBook {

	private String riderId;
	private CabLocation sourceLoc;
	private CabLocation destLoc;

	public CabBook() {
	}

	public CabBook(String riderId, CabLocation sourceLoc, CabLocation destLoc) {
		this.riderId = riderId;
		this.sourceLoc = sourceLoc;
		this.destLoc = destLoc;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	public CabLocation getSourceLoc() {
		return sourceLoc;
	}

	public void setSourceLoc(CabLocation sourceLoc) {
		this.sourceLoc = sourceLoc;
	}

	public CabLocation getDestLoc() {
		return destLoc;
	}

	public void setDestLoc(CabLocation destLoc) {
		this.destLoc = destLoc;
	}

	@Override
	public String toString() {
		return "CabBook [riderId=" + riderId + ", sourceLoc=" + sourceLoc + ", destLoc=" + destLoc + "]";
	}

}
