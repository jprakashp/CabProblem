package com.app.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CabLocation {

	private Double x;
	private Double y;

	public CabLocation(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public CabLocation() {
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}


	public Double distance(CabLocation location2) {
		return sqrt(pow(this.x - location2.x, 2) + pow(this.y - location2.y, 2));
	}

	@Override
	public String toString() {
		return "CabLocation [x=" + x + ", y=" + y + "]";
	}

}
