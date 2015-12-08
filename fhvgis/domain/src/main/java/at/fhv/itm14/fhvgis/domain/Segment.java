package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "segment", schema = "public")
public class Segment extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Waypoint begin;
	private Waypoint end;
	private Transportation transportation;
	private TransportationRoute transportationRoute;
	private POI beginPOI;
	private POI endPOI;
	
	public Segment(){
		
	}

	public Segment(Waypoint begin, Waypoint end, Transportation transportation) {
		this(begin, end, transportation, null, null, null);
	}

	public Segment(Waypoint begin, Waypoint end, Transportation transportation, TransportationRoute transportationRoute,
			POI beginPOI, POI endPOI) {
		super();
		this.begin = begin;
		this.end = end;
		this.transportation = transportation;
		this.transportationRoute = transportationRoute;
		this.beginPOI = beginPOI;
		this.endPOI = endPOI;
	}

	public Segment(UUID id, Waypoint begin, Waypoint end, Transportation transportation,
			TransportationRoute transportationRoute, POI beginPOI, POI endPOI) {
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.transportation = transportation;
		this.transportationRoute = transportationRoute;
		this.beginPOI = beginPOI;
		this.endPOI = endPOI;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "waypoint_from_id", nullable = false)
	public Waypoint getBegin() {
		return begin;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "waypoint_to_id", nullable = false)
	public Waypoint getEnd() {
		return end;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_analyzed_id", nullable = false)
	public Transportation getTransportation() {
		return transportation;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_route_analyzed_id")
	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_from_id")
	public POI getBeginPOI() {
		return beginPOI;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_to_id")
	public POI getEndPOI() {
		return endPOI;
	}

	public void setBegin(Waypoint begin) {
		this.begin = begin;
	}

	public void setEnd(Waypoint end) {
		this.end = end;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}

	public void setBeginPOI(POI beginPOI) {
		this.beginPOI = beginPOI;
	}

	public void setEndPOI(POI endPOI) {
		this.endPOI = endPOI;
	}
}
