package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "waypoint", schema = "public")
public class Waypoint extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Point position;
	private Instant recordTime;
	// TODO redundancy btw acc, nrOfSats, fixType, isValid..
	private double accuracy;
	private int nrOfSatellites;
	// TODO use FixType as enum or/and isValid
	private boolean isValid;
	private double speed;
	private double minAcceleration;
	private double maxAcceleration;
	private double avgAcceleration;
	private Transportation transportation;
	private TransportationRoute transportationRoute;
	private POI poi;
	private Track track;
	private List<Segment> segmentsTo;
	private List<Segment> segmentsFrom;
	
	public Waypoint(){
		
	}

	public Waypoint(Point postion, Instant recordTime, double accuracy, 
					int nrOfSatellites, boolean isValid, double speed,
					double minAcceleration, double maxAcceleration, double avgAcceleration) {

		super();
		this.position = postion;
		this.recordTime = recordTime;
		this.accuracy = accuracy;
		this.nrOfSatellites = nrOfSatellites;
		this.isValid = isValid;
		this.speed = speed;
		this.minAcceleration = minAcceleration;
		this.maxAcceleration = maxAcceleration;
		this.avgAcceleration = avgAcceleration;
	}

	public Waypoint(UUID id, Point postion, Instant recordTime, double accuracy, int nrOfSatellites,
			boolean isValid, double speed,
					double minAcceleration, double maxAcceleration, double avgAcceleration) {
		this.id = id;
		this.position = postion;
		this.recordTime = recordTime;
		this.accuracy = accuracy;
		this.nrOfSatellites = nrOfSatellites;
		this.isValid = isValid;
		this.speed = speed;
		this.minAcceleration = minAcceleration;
		this.maxAcceleration = maxAcceleration;
		this.avgAcceleration = avgAcceleration;
	
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
	@JoinColumn(name = "transportation_superv_id")
	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_route_superv_id")
	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_id")
	public POI getPoi() {
		return poi;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}
	
	@Column(name = "position", nullable = false)
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}

	@Column(name = "record_time", nullable = false, length = 29)
	public Instant getRecordTime() {
		return recordTime;
	}
	
	@Column(name = "accuracy", precision = 17, scale = 17)
	public double getAccuracy() {
		return accuracy;
	}
	
	@Column(name = "nr_of_satellites", nullable = false)
	public int getNrOfSatellites() {
		return nrOfSatellites;
	}
	
	@Column(name = "valid", nullable = false)
	public boolean isValid() {
		return isValid;
	}
	
	@Column(name = "speed", precision = 8, scale = 8)
	public double getSpeed() {
		return speed;
	}
	@Transient
	public double getMinAcceleration() {
		return minAcceleration;
	}
	@Transient
	public double getMaxAcceleration() {
		return maxAcceleration;
	}
	@Transient
	public double getAvgAcceleration() {
		return avgAcceleration;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", nullable = false)
	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "end", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegmentsTo() {
		return segmentsTo;
	}

	public void setSegmentsTo(List<Segment> segmentsTo) {
		this.segmentsTo = segmentsTo;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "begin", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Segment> getSegmentsFrom() {
		return segmentsFrom;
	}

	public void setSegmentsFrom(List<Segment> segmentsFrom) {
		this.segmentsFrom = segmentsFrom;
	}

	public void setRecordTime(Instant recordTime) {
		this.recordTime = recordTime;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public void setNrOfSatellites(int nrOfSatellites) {
		this.nrOfSatellites = nrOfSatellites;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setMinAcceleration(double minAcceleration) {
		this.minAcceleration = minAcceleration;
	}

	public void setMaxAcceleration(double maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}

	public void setAvgAcceleration(double avgAcceleration) {
		this.avgAcceleration = avgAcceleration;
	}

	@Override
	public String toString() {
		return "Waypoint{" + "postion=" + position + ", recordTime=" + recordTime + ", accuracy=" + accuracy + ", nrOfSatellites=" + nrOfSatellites + ", isValid=" + isValid + ", speed=" + speed + ", minAcceleration=" + minAcceleration + ", maxAcceleration=" + maxAcceleration + ", avgAcceleration=" + avgAcceleration + ", transportation=" + transportation + ", transportationRoute=" + transportationRoute + ", poi=" + poi + '}';
	}
}
