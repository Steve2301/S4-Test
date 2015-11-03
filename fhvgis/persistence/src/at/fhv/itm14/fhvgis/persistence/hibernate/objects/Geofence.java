package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 03.11.2015 22:57:50 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Geofence generated by hbm2java
 */
@Entity
@Table(name = "geofence", schema = "public")
public class Geofence implements java.io.Serializable {

	private String id;
	private Poi poi;
	private String[] positions;

	public Geofence() {
	}

	public Geofence(String id, Poi poi, String[] positions) {
		this.id = id;
		this.poi = poi;
		this.positions = positions;
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
	@JoinColumn(name = "poi_id", nullable = false)
	public Poi getPoi() {
		return this.poi;
	}

	public void setPoi(Poi poi) {
		this.poi = poi;
	}

	@Column(name = "positions", nullable = false)
	public String[] getPositions() {
		return this.positions;
	}

	public void setPositions(String[] positions) {
		this.positions = positions;
	}

}
