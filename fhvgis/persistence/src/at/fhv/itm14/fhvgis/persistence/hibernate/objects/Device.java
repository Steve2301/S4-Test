package at.fhv.itm14.fhvgis.persistence.hibernate.objects;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Device generated by hbm2java
 */
@Entity
@Table(name = "device", schema = "public")
public class Device implements java.io.Serializable {

	private UUID id;
	private User user;
	private String token;
	private String deviceId;
	private Set<MotionValues> motionValueses = new HashSet<MotionValues>(0);
	private Set<Track> tracks = new HashSet<Track>(0);
	private Set<Log> logs = new HashSet<Log>(0);

	public Device() {
	}

	public Device(UUID id, User user, String token) {
		this.id = id;
		this.user = user;
		this.token = token;
	}

	public Device(UUID id, User user, String token, String deviceId, Set<MotionValues> motionValueses,
			Set<Track> tracks, Set<Log> logs) {
		this.id = id;
		this.user = user;
		this.token = token;
		this.deviceId = deviceId;
		this.motionValueses = motionValueses;
		this.tracks = tracks;
		this.logs = logs;
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
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "token", nullable = false)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "device_id")
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	public Set<MotionValues> getMotionValueses() {
		return this.motionValueses;
	}

	public void setMotionValueses(Set<MotionValues> motionValueses) {
		this.motionValueses = motionValueses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

}
