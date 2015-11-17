package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends Entity implements Serializable {

	private String name;
	private String password;
	private List<Device> devices;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.devices = new ArrayList<>();
	}

	public User(UUID id, String name, String password) {
		this.id = id;
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
