package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class GPSPosition implements Serializable{

	private static final long serialVersionUID = 1L;
	// TODO PostGIS or some other API available?!
	// http://www.java2s.com/Code/Java/2D-Graphics-GUI/Geometry.htm
	// https://github.com/JavadocMD/simplelatlng
	private double latitude;
	private double longitude;
	
	public GPSPosition(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
