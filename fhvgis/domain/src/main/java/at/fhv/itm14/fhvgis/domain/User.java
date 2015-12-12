package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User extends DomainEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<Device> devices;

	public User(){
		
	}

	public User(String name, String password) {
		super();
		this.username = name;
		this.password = password;
		this.devices = new ArrayList<>();
	}
	
	public User(UUID id, String name, String password) {
		this.id = id;
		this.username = name;
		this.password = password;
		this.devices = new ArrayList<>();
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void addDevice(Device device) {
		device.setUser(this);
		this.devices.add(device);
	}
	
	public void removeDevice(Device device) {
		this.devices.remove(device);
	}
	
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String name) {
		this.username = name;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Device> getDevices() {
		return new ArrayList<Device>(devices);
	}
	
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}
