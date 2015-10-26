package at.fhv.itm14.fhvgis.domain;

import java.time.Instant;

public class Waypoint extends Entity {

	private GPSPosition postion;
	private Instant recordTime;
	// TODO redundancy btw acc, nrOfSats, fixType, isValid..
	private double accuracy;
	private int nrOfSatellites;
	// TODO use FixType as enum or/and isValid
	private boolean isValid;
	private Transportation transportation;
	private TransportationRoute transportationRoute;
	private POI poi;
	
	public Waypoint(GPSPosition postion, Instant recordTime, double accuracy, 
					int nrOfSatellites, boolean isValid) {
		super();
		this.postion = postion;
		this.recordTime = recordTime;
		this.accuracy = accuracy;
		this.nrOfSatellites = nrOfSatellites;
		this.isValid = isValid;
	}
	
	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}

	public POI getPoi() {
		return poi;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}

	public GPSPosition getPostion() {
		return postion;
	}

	public Instant getRecordTime() {
		return recordTime;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public int getNrOfSatellites() {
		return nrOfSatellites;
	}

	public boolean isValid() {
		return isValid;
	}	
}
