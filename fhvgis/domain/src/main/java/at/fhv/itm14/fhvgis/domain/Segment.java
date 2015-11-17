package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class Segment extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private Waypoint begin;
	private Waypoint end;
	private Transportation transportation;
	private TransportationRoute transportationRoute;
	private POI beginPOI;
	private POI endPOI;
	
	public Segment(Waypoint begin, Waypoint end, Transportation transportation) {
		this(begin, end, transportation, null, null, null);
	}

	public Segment(Waypoint begin, Waypoint end, Transportation transportation,
				   TransportationRoute transportationRoute, POI beginPOI, POI endPOI) {
		super();
		this.begin = begin;
		this.end = end;
		this.transportation = transportation;
		this.transportationRoute = transportationRoute;
		this.beginPOI = beginPOI;
		this.endPOI = endPOI;
	}
	
	public Waypoint getBegin() {
		return begin;
	}

	public Waypoint getEnd() {
		return end;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}

	public POI getBeginPOI() {
		return beginPOI;
	}

	public POI getEndPOI() {
		return endPOI;
	}
}
