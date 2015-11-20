package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class POI extends Entity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private POIType poiType;
	private GPSPosition poiPosition;
	private List<Geofence> geofences;
	private String externalRef;
	
	public POI(String name, POIType poiType, GPSPosition poiPosition, String externalRef) {
		super();
		this.name = name;
		this.poiType = poiType;
		this.poiPosition = poiPosition;
		this.geofences = new ArrayList<>();
		this.externalRef = externalRef;
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

	public GPSPosition getPoiPosition() {
		return poiPosition;
	}

	public List<Geofence> getGeofences() {
		return new ArrayList<>(geofences);
	}
	
	public void addGeofence(Geofence geofence) {
		geofences.add(geofence);
	}
	
	public void removeGeofence(Geofence geofence) {
		geofences.remove(geofence);
	}

	public String getExternalRef() {
		return externalRef;
	}
}
