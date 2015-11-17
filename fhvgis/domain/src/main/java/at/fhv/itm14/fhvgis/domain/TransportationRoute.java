package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Line
 *
 */
public class TransportationRoute extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Instant validFrom;
	private Instant validTo;
	private Transportation transportation;
	private String externalRef;
	private List<TransportationTrip> transportationTrips;
	private String routeNo;
	
	public TransportationRoute(String name, Instant validFrom, Transportation transportation, String externalRef, String routeNo) {
		super();
		this.name = name;
		this.validFrom = validFrom;
		this.transportation = transportation;
		this.transportationTrips = new ArrayList<>();
		this.externalRef = externalRef;
		this.routeNo = routeNo;
	}

	public void addTransportationTrip(TransportationTrip transportationTrip) {
		this.transportationTrips.add(transportationTrip);
	}
	
	public void removeTransportationTrip(TransportationTrip transportationTrip) {
		this.transportationTrips.remove(transportationTrip);
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Instant validFrom) {
		this.validFrom = validFrom;
	}

	public Instant getValidTo() {
		return validTo;
	}

	public void setValidTo(Instant validTo) {
		this.validTo = validTo;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	public List<TransportationTrip> getTransportationTrips() {
		return new ArrayList<>(transportationTrips);
	}
	
	public String getExternalRef() {
		return externalRef;
	}

	public String getRouteNo() {
		return routeNo;
	}
}
