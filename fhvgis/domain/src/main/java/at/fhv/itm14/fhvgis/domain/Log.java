package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "log", schema = "public")
public class Log extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String level;
	private Instant timestamp;
	private String tag;
	private String message;
	private String stacktrace;
	private Device device;
	
	public Log(){
		
	}

	public Log(String level, Instant timestamp, String tag, String message, String stacktrace) {
		super();
		this.level = level;
		this.timestamp = timestamp;
		this.tag = tag;
		this.message = message;
		this.stacktrace = stacktrace;
	}

	public Log(UUID id, String level, Instant timestamp, String tag, String message, String stacktrace) {
		this.id = id;
		this.level = level;
		this.timestamp = timestamp;
		this.tag = tag;
		this.message = message;
		this.stacktrace = stacktrace;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "level")
	public String getLevel() {
		return level;
	}
	
	@Column(name = "log_time", length = 29)
	public Instant getTimestamp() {
		return timestamp;
	}

	@Column(name = "tag")
	public String getTag() {
		return tag;
	}
	
	@Column(name = "message")
	public String getMessage() {
		return message;
	}
	
	@Column(name = "stacktrace")
	public String getStacktrace() {
		return stacktrace;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", nullable = false)
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
}
