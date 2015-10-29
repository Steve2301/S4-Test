package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class Geofence implements Serializable{

	private double radius;
	private GPSPosition center;
	
	public Geofence(double radius, GPSPosition center) {
		super();
		this.radius = radius;
		this.center = center;
	}
	
	public double getRadius() {
		return radius;
	}
	public GPSPosition getCenter() {
		return center;
	}
}
