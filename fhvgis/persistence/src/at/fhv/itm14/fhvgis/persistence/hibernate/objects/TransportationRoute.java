package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 28.10.2015 12:44:52 by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TransportationRoute generated by hbm2java
 */
@Entity
@Table(name = "transportation_route", schema = "public")
public class TransportationRoute implements java.io.Serializable {

	private String id;
	private Transportation transportation;
	private String name;
	private Date validFrom;
	private Date validUntil;
	private Set<Segment> segments = new HashSet<Segment>(0);
	private Set<Shedule> shedules = new HashSet<Shedule>(0);
	private Set<Waypoint> waypoints = new HashSet<Waypoint>(0);

	public TransportationRoute() {
	}

	public TransportationRoute(String id, Transportation transportation, Date validFrom) {
		this.id = id;
		this.transportation = transportation;
		this.validFrom = validFrom;
	}

	public TransportationRoute(String id, Transportation transportation, String name, Date validFrom,
			Date validUntil, Set<Segment> segments, Set<Shedule> shedules, Set<Waypoint> waypoints) {
		this.id = id;
		this.transportation = transportation;
		this.name = name;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.segments = segments;
		this.shedules = shedules;
		this.waypoints = waypoints;
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
	@JoinColumn(name = "transportation_id", nullable = false)
	public Transportation getTransportation() {
		return this.transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valid_from", nullable = false, length = 29)
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valid_until", length = 29)
	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute")
	public Set<Segment> getSegments() {
		return this.segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute")
	public Set<Shedule> getShedules() {
		return this.shedules;
	}

	public void setShedules(Set<Shedule> shedules) {
		this.shedules = shedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationRoute")
	public Set<Waypoint> getWaypoints() {
		return this.waypoints;
	}

	public void setWaypoints(Set<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

}
