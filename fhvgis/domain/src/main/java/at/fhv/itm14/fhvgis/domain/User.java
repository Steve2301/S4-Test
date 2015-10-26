package at.fhv.itm14.fhvgis.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity {
	
	private String name;
	private String password;
	private List<Device> devices;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.devices = new ArrayList<>();
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}
	
	public void removeDevice(Device device) {
		this.devices.remove(device);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Device> getDevices() {
		return new ArrayList<Device>(devices);
	}

}
