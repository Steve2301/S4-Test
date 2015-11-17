package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Track extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private Instant startDate;
	private Instant endDate;
	private Device device;
	private List<Waypoint> waypoints;
	private List<Segment> segments;
	// TODO States: isFinished, isAnalyzed

	public Track(Device device, Instant startDate) {
		super();
		this.device = device;
		this.startDate = startDate;
		this.waypoints = new ArrayList<>();
		this.segments = new ArrayList<>();
	}
	
	public boolean isFinished() {
		return this.endDate != null;
	}
	
	public void finishTrack(Instant endDate) {
		this.endDate = endDate;
	}
	
	public boolean isAnalyzed() {
		return this.segments != null && segments.size() > 0;
	}
	
	public Duration getDuration() {
		return Duration.between(startDate, endDate);
	}
	
	public void addWaypoint(Waypoint waypoint) {
		this.waypoints.add(waypoint);
	}
	
	public void addSegment(Segment segment) {
		this.segments.add(segment);
	}
	
	public Instant getStartDate() {
		return startDate;
	}
	
	public Instant getEndDate() {
		return endDate;
	}

	public Device getDevice() {
		return device;
	}

	public List<Waypoint> getWaypoints() {
		return new ArrayList<>(waypoints);
	}
	
	public List<Segment> getSegments() {
		return new ArrayList<>(segments);
	}
}
