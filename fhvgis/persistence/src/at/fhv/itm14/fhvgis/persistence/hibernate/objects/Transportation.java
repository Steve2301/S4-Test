package at.fhv.itm14.fhvgis.persistence.hibernate.objects;

// default package
// Generated 17.11.2015 09:21:54 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.type.UUIDBinaryType;

/**
 * Transportation generated by hbm2java
 */
@Entity
@Table(name = "transportation", schema = "public")
public class Transportation implements java.io.Serializable {

	private UUID id;
	private String name;
	private Float maxSpeed;
	private Float avarageSpeed;
	private String color;
	private Set<TransportationRoute> transportationRoutes = new HashSet<TransportationRoute>(0);
	private Set<Segment> segments = new HashSet<Segment>(0);
	private Set<Waypoint> waypoints = new HashSet<Waypoint>(0);

	public Transportation() {
	}

	public Transportation(UUID id) {
		this.id = id;
	}

	public Transportation(UUID id, String name, Float maxSpeed, Float avarageSpeed, String color,
			Set<TransportationRoute> transportationRoutes, Set<Segment> segments, Set<Waypoint> waypoints) {
		this.id = id;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.avarageSpeed = avarageSpeed;
		this.color = color;
		this.transportationRoutes = transportationRoutes;
		this.segments = segments;
		this.waypoints = waypoints;
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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "max_speed", precision = 8, scale = 8)
	public Float getMaxSpeed() {
		return this.maxSpeed;
	}

	public void setMaxSpeed(Float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Column(name = "avarage_speed", precision = 8, scale = 8)
	public Float getAvarageSpeed() {
		return this.avarageSpeed;
	}

	public void setAvarageSpeed(Float avarageSpeed) {
		this.avarageSpeed = avarageSpeed;
	}

	@Column(name = "color")
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation")
	public Set<TransportationRoute> getTransportationRoutes() {
		return this.transportationRoutes;
	}

	public void setTransportationRoutes(Set<TransportationRoute> transportationRoutes) {
		this.transportationRoutes = transportationRoutes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation")
	public Set<Segment> getSegments() {
		return this.segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportation")
	public Set<Waypoint> getWaypoints() {
		return this.waypoints;
	}

	public void setWaypoints(Set<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

}
