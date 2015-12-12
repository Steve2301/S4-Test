package at.fhv.itm14.fhvgis.domain;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import at.fhv.itm14.fhvgis.domain.raw.RawWaypoint;
import at.fhv.itm14.fhvgis.persistence.utils.ColorConverter;

@Entity
@Table(name = "transportation", schema = "public")
public class Transportation extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private double maxSpeed;
	private double avgSpeed;
	private Color color;
	private List<TransportationRoute> transportationRoutes;
	private List<RawWaypoint> rawWaypoints;
	private List<Segment> segments;
	private List<Waypoint> waypoints;
	
	public Transportation(){
		
	}

	public Transportation(String name, double maxSpeed, Color color) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.color = color;
	}

	public Transportation(UUID id, String name, double maxSpeed, double avgSpeed, Color color) {
		this.id = id;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.avgSpeed = avgSpeed;
		this.color = color;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "max_speed", precision = 8, scale = 8)
	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	@Column(name = "avarage_speed", precision = 8, scale = 8)
	public double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
	
	@Column(name = "color")
	@Convert(converter = ColorConverter.class)
	//TODO check this mapping
	public Color getColor() {
		return color;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<TransportationRoute> getTransportationRoutes() {
		return transportationRoutes;
	}

	public void setTransportationRoutes(List<TransportationRoute> transportationRoutes) {
		this.transportationRoutes = transportationRoutes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<RawWaypoint> getRawWaypoints() {
		return rawWaypoints;
	}

	public void setRawWaypoints(List<RawWaypoint> rawWaypoints) {
		this.rawWaypoints = rawWaypoints;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
