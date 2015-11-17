package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Device extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	private List<Track> tracks;
	private List<Log> logs;
	
	public Device(String token) {
		super();
		this.token = token;
		this.tracks = new ArrayList<>();
		this.logs = new ArrayList<>();
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

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

	public List<Log> getLogs() {
		return new ArrayList<>(logs);
	}
}
