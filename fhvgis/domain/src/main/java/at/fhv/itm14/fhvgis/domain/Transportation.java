package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class Transportation extends Entity implements Serializable{

	private String name;
	private double maxSpeed;
	
	public Transportation(String name, double maxSpeed) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
