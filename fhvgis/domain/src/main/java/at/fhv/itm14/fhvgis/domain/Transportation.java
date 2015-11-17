package at.fhv.itm14.fhvgis.domain;

import java.awt.Color;
import java.io.Serializable;

public class Transportation extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private double maxSpeed;
	private Color color;

	public Transportation(String name, double maxSpeed, Color color) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.color = color;
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

	public Color getColor() {
		return color;
	}
}
