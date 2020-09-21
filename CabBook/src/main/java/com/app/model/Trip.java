package com.app.model;

import static com.app.model.TripStatus.FINISHED;
import static com.app.model.TripStatus.IN_PROGRESS;

enum TripStatus {
	IN_PROGRESS, FINISHED
}

public class Trip {
	private Rider rider;
	private Cab cab;
	private TripStatus status;
	private CabLocation fromPoint;
	private CabLocation toPoint;

	public Trip() {
	}

	public Trip(Rider rider, Cab cab, CabLocation fromPoint, CabLocation toPoint) {
		this.rider = rider;
		this.cab = cab;
		this.fromPoint = fromPoint;
		this.toPoint = toPoint;
		this.status = IN_PROGRESS;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public CabLocation getFromPoint() {
		return fromPoint;
	}

	public void setFromPoint(CabLocation fromPoint) {
		this.fromPoint = fromPoint;
	}

	public CabLocation getToPoint() {
		return toPoint;
	}

	public void setToPoint(CabLocation toPoint) {
		this.toPoint = toPoint;
	}

	public void endTrip() {
		this.status = FINISHED;
	}

	@Override
	public String toString() {
		return "Trip [rider=" + rider + ", cab=" + cab + ", status=" + status + ", fromPoint=" + fromPoint
				+ ", toPoint=" + toPoint + "]";
	}
}
