package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import at.fhv.itm14.fhvgis.domain.raw.*;

@Entity
@Table(name="device", schema="public")
public class Device extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;
	private String deviceId;
	private List<Track> tracks;
	private List<Log> logs;
	private List<RawMotionValue> rawMotionValues;
	//private List<MotionValue> motionValues;
	private User user;

	public Device(){
		
	}
	
	public Device(String token, String deviceId) {
		super();
		this.token = token;
		this.deviceId = deviceId;
		this.tracks = new ArrayList<>();
		this.logs = new ArrayList<>();
	}

	public Device(UUID id, String token, String deviceId) {
		this.id = id;
		this.token = token;
		this.deviceId = deviceId;
		this.tracks = new ArrayList<>();
		this.logs = new ArrayList<>();
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "token", nullable = false)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "device_id")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Track> getTracks() {
		return new ArrayList<>(tracks);
	}

	public void addTrack(Track track) {
		this.tracks.add(track);
	}

	public void removeTrack(Track track) {
		this.tracks.remove(track);
	}

	public void addLog(Log log) {
		this.logs.add(log);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Log> getLogs() {
		return new ArrayList<>(logs);
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<RawMotionValue> getRawMotionValues() {
		return rawMotionValues;
	}

	public void setRawMotionValues(List<RawMotionValue> rawMotionValues) {
		this.rawMotionValues = rawMotionValues;
	}
	
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}


}
