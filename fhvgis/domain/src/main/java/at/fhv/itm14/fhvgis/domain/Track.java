package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;


import at.fhv.itm14.fhvgis.domain.raw.RawWaypoint;

@Entity
@Table(name = "track", schema = "public")
public class Track extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant startDate;
	private Instant endDate;
	private Device device;
	private List<Waypoint> waypoints;
	private List<Segment> segments;
	private List<RawWaypoint> rawWaypoints;
	private boolean analyzed;
	// TODO States: isFinished, isAnalyzed
	
	public Track(){
		
	}

	public Track(Device device, Instant startDate, Instant endDate) {
		super();
		this.device = device;
		this.startDate = startDate;
		this.endDate = endDate;
		this.waypoints = new ArrayList<>();
		this.segments = new ArrayList<>();
	}

	public Track(UUID id, Device device, Instant startDate) {
		this.id = id;
		this.device = device;
		this.startDate = startDate;
		this.waypoints = new ArrayList<>();
		this.segments = new ArrayList<>();
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Transient
	public boolean isFinished() {
		return this.endDate != null;
	}

	public void finishTrack(Instant endDate) {
		this.endDate = endDate;
	}
	
	@Transient
	public boolean isAnalyzed() {
		analyzed = this.segments != null && segments.size() > 0;
		return analyzed;
	}
	@Transient
	public boolean getAnalyzed(){
		return isAnalyzed();
	}
	
	public void setAnalyzed(boolean b){
		analyzed = b;
	}

	@Transient
	public Duration getDuration() {
		if ((this.startDate != null) && (this.endDate != null)) {
			return Duration.between(startDate, endDate);
		}
		return null;
	}

	public void addWaypoint(Waypoint waypoint) {
		waypoint.setTrack(this);
		this.waypoints.add(waypoint);
	}

	public void addSegment(Segment segment) {
		this.segments.add(segment);
	}
	
	@Column(name = "start_date", nullable = false, length = 29)
	public Instant getStartDate() {
		return startDate;
	}
	@Column(name = "end_date", length = 29)
	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", nullable = false)
	public Device getDevice() {
		return device;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Waypoint> getWaypoints() {
		return new ArrayList<>(waypoints);
	}
	
	@Transient //TODO map segments
	public List<Segment> getSegments() {
		//return new ArrayList<>(segments);
		return segments;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<RawWaypoint> getRawWaypoints() {
		return rawWaypoints;
	}

	public void setRawWaypoints(List<RawWaypoint> rawWaypoints) {
		this.rawWaypoints = rawWaypoints;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
}
