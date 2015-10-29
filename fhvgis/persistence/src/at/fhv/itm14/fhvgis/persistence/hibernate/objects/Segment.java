package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 29.10.2015 22:12:10 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Segment generated by hbm2java
 */
@Entity
@Table(name = "segment", schema = "public")
public class Segment implements java.io.Serializable {

	private String id;
	private TransportationRoute transportationRoute;
	private Poi poiByPoiToId;
	private Transportation transportation;
	private Waypoint waypointByWaypointFromId;
	private Poi poiByPoiFromId;
	private Waypoint waypointByWaypointToId;

	public Segment() {
	}

	public Segment(String id, Transportation transportation, Waypoint waypointByWaypointFromId,
			Waypoint waypointByWaypointToId) {
		this.id = id;
		this.transportation = transportation;
		this.waypointByWaypointFromId = waypointByWaypointFromId;
		this.waypointByWaypointToId = waypointByWaypointToId;
	}

	public Segment(String id, TransportationRoute transportationRoute, Poi poiByPoiToId,
			Transportation transportation, Waypoint waypointByWaypointFromId, Poi poiByPoiFromId,
			Waypoint waypointByWaypointToId) {
		this.id = id;
		this.transportationRoute = transportationRoute;
		this.poiByPoiToId = poiByPoiToId;
		this.transportation = transportation;
		this.waypointByWaypointFromId = waypointByWaypointFromId;
		this.poiByPoiFromId = poiByPoiFromId;
		this.waypointByWaypointToId = waypointByWaypointToId;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_route_analyzed_id")
	public TransportationRoute getTransportationRoute() {
		return this.transportationRoute;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_to_id")
	public Poi getPoiByPoiToId() {
		return this.poiByPoiToId;
	}

	public void setPoiByPoiToId(Poi poiByPoiToId) {
		this.poiByPoiToId = poiByPoiToId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_analyzed_id", nullable = false)
	public Transportation getTransportation() {
		return this.transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "waypoint_from_id", nullable = false)
	public Waypoint getWaypointByWaypointFromId() {
		return this.waypointByWaypointFromId;
	}

	public void setWaypointByWaypointFromId(Waypoint waypointByWaypointFromId) {
		this.waypointByWaypointFromId = waypointByWaypointFromId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_from_id")
	public Poi getPoiByPoiFromId() {
		return this.poiByPoiFromId;
	}

	public void setPoiByPoiFromId(Poi poiByPoiFromId) {
		this.poiByPoiFromId = poiByPoiFromId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "waypoint_to_id", nullable = false)
	public Waypoint getWaypointByWaypointToId() {
		return this.waypointByWaypointToId;
	}

	public void setWaypointByWaypointToId(Waypoint waypointByWaypointToId) {
		this.waypointByWaypointToId = waypointByWaypointToId;
	}

}
