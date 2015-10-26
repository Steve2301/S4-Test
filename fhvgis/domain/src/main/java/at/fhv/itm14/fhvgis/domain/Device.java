package at.fhv.itm14.fhvgis.domain;

import java.util.ArrayList;
import java.util.List;

public class Device extends Entity {

	private String token;
	private List<Track> tracks;
	
	public Device(String token) {
		super();
		this.token = token;
		this.tracks = new ArrayList<>();
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

}
