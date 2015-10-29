package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class POI extends Entity implements Serializable{
	
	private String name;
	private POIType poiType;
	private Geofence geofence;
	
	public POI(String name, POIType poiType, Geofence geofence) {
		super();
		this.name = name;
		this.poiType = poiType;
		this.geofence = geofence;
	}
	
	public boolean isWithinGeofence(Waypoint waypoint) {
		// TODO 
		// http://www.java2s.com/Code/Java/2D-Graphics-GUI/Geometry.htm
		// https://github.com/JavadocMD/simplelatlng
		throw new RuntimeException("Not implemented.");
	}

	public String getName() {
		return name;
	}

	public POIType getPoiType() {
		return poiType;
	}

	public Geofence getGeofence() {
		return geofence;
	}
}
