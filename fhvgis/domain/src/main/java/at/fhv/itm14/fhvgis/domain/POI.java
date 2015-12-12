package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "poi", schema = "public")
public class POI extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private POIType poiType;
	private Point poiPosition;
	private List<Geofence> geofences;
	private List<Waypoint> waypoints;
	private List<Segment> segmentsFrom;
	private List<Segment> segmentsTo;
	private List<Schedule> schedules;
	private String externalRef;
	private double radius;
	
	public POI(){
		
	}
	
	public POI(String name, POIType poiType, Point poiPosition, String externalRef) {
		super();
		this.name = name;
		this.poiType = poiType;
		this.poiPosition = poiPosition;
		this.geofences = new ArrayList<>();
		this.externalRef = externalRef;
	}

	public POI(UUID id, String name, POIType poiType, Point poiPosition, String externalRef,
			List<Geofence> geofences, double radius) {
		this.id = id;
		this.name = name;
		this.poiType = poiType;
		this.poiPosition = poiPosition;
		this.externalRef = externalRef;
		this.geofences = geofences;
		this.radius = radius;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public boolean isWithinGeofence(Waypoint waypoint) {
		return poiPosition.isWithinDistance(waypoint.getPoi().getPoiPosition(), radius);
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@ManyToOne()
	public POIType getPoiType() {
		return poiType;
	}
	
	@Column(name = "position", nullable = false)
	public Point getPoiPosition() {
		return poiPosition;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poi", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Geofence> getGeofences() {
		return new ArrayList<>(geofences);
	}

	public void addGeofence(Geofence geofence) {
		geofences.add(geofence);
	}

	public void removeGeofence(Geofence geofence) {
		geofences.remove(geofence);
	}
	
	@Column(name = "ext_ref")
	public String getExternalRef() {
		return externalRef;
	}
	
	@Column(name = "radius", precision = 8, scale = 8)
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poi", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beginPOI", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegmentsFrom() {
		return segmentsFrom;
	}

	public void setSegmentsFrom(List<Segment> segmentsFrom) {
		this.segmentsFrom = segmentsFrom;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endPOI", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegmentsTo() {
		return segmentsTo;
	}

	public void setSegmentsTo(List<Segment> segmentsTo) {
		this.segmentsTo = segmentsTo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poi", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoiType(POIType poiType) {
		this.poiType = poiType;
	}

	public void setPoiPosition(Point poiPosition) {
		this.poiPosition = poiPosition;
	}

	public void setGeofences(List<Geofence> geofences) {
		this.geofences = geofences;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

}
