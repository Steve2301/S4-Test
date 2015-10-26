package at.fhv.itm14.fhvgis.domain;

public class Transportation extends Entity {

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
