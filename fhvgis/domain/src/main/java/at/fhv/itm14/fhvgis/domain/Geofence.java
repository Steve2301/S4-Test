package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "geofence", schema = "public")
public class Geofence extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private double radius;
	private POI poi;
	private Point center;
	private MultiPoint positions;
	
	public Geofence(){
		
	}

	public Geofence(double radius, Point center) {
		super();
		this.radius = radius;
		this.center = center;
	}

	public Geofence(UUID id, double radius, Point center, MultiPoint positions) {
		this.id = id;
		this.radius = radius;
		this.center = center;
		this.setPositions(positions);
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center){
		this.center = center;
	}
	
	@Column(name = "positions", nullable = false)
	public MultiPoint getPositions() {
		return positions;
	}

	public void setPositions(MultiPoint positions) {
		this.positions = positions;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_id", nullable = false)
	public POI getPoi() {
		return poi;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}
}
