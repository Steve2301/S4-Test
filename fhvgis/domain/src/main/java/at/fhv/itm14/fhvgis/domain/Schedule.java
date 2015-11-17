package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.LocalTime;

public class Schedule extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private TransportationTrip transportationTrip;
	private POI poi;
	
	public Schedule(LocalTime arrivalTime, LocalTime departureTime, TransportationTrip transportationTrip, POI poi) {
		super();
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.transportationTrip = transportationTrip;
		this.poi = poi;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public TransportationTrip getTransportationTrip() {
		return transportationTrip;
	}
	public POI getPoi() {
		return poi;
	}
}
