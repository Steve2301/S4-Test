package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "transportation_route", schema = "public")
public class TransportationRoute extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Instant validFrom;
	private Instant validTo;
	private Transportation transportation;
	private String externalRef;
	private List<TransportationTrip> transportationTrips;
	private String routeNo;
	private String operator;
	private String network;
	private String descFrom;
	private String descTo;
	private String desc;
	private List<Segment> segments;
	private List<Schedule> schedules;
	private List<Waypoint> waypoints;
	
	
	public TransportationRoute(){
		
	}

	public TransportationRoute(String name, Instant validFrom, Transportation transportation, String externalRef,
			String routeNo) {
		super();
		this.name = name;
		this.validFrom = validFrom;
		this.transportation = transportation;
		this.transportationTrips = new ArrayList<>();
		this.externalRef = externalRef;
		this.routeNo = routeNo;
	}

	public TransportationRoute(UUID id, String name, Instant validFrom, Transportation transportation,
			String externalRef, String routeNo) {
		this.id = id;
		this.name = name;
		this.validFrom = validFrom;
		this.transportation = transportation;
		this.transportationTrips = new ArrayList<>();
		this.externalRef = externalRef;
		this.routeNo = routeNo;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void addTransportationTrip(TransportationTrip transportationTrip) {
		this.transportationTrips.add(transportationTrip);
	}

	public void removeTransportationTrip(TransportationTrip transportationTrip) {
		this.transportationTrips.remove(transportationTrip);
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "valid_from", nullable = false, length = 29)
	public Instant getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Instant validFrom) {
		this.validFrom = validFrom;
	}
	
	@Column(name = "valid_until", length = 29)
	public Instant getValidTo() {
		return validTo;
	}

	public void setValidTo(Instant validTo) {
		this.validTo = validTo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_id", nullable = false)
	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}
	
	@Transient
	public List<TransportationTrip> getTransportationTrips() {
		return new ArrayList<>(transportationTrips);
	}
	
	@Column(name = "ext_ref")
	public String getExternalRef() {
		return externalRef;
	}
	
	@Column(name = "route_no")
	public String getRouteNo() {
		return routeNo;
	}
	
	@Column(name = "operator")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Column(name = "network")
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
	@Column(name = "desc_from")
	public String getDescFrom() {
		return descFrom;
	}

	public void setDescFrom(String descFrom) {
		this.descFrom = descFrom;
	}
	
	@Column(name = "desc_to")
	public String getDescTo() {
		return descTo;
	}

	public void setDescTo(String descTo) {
		this.descTo = descTo;
	}
	
	@Column(name = "desce")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

	public void setTransportationTrips(List<TransportationTrip> transportationTrips) {
		this.transportationTrips = transportationTrips;
	}

	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
}
