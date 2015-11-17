package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.Instant;

public class Log extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String level;
	private Instant timestamp;
	private String tag;
	private String message;
	private String stacktrace;

	public Log(String level, Instant timestamp, String tag, String message, String stacktrace) {
		this.level = level;
		this.timestamp = timestamp;
		this.tag = tag;
		this.message = message;
		this.stacktrace = stacktrace;
	}

	public String getLevel() {
		return level;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getTag() {
		return tag;
	}

	public String getMessage() {
		return message;
	}

	public String getStacktrace() {
		return stacktrace;
	}
}
