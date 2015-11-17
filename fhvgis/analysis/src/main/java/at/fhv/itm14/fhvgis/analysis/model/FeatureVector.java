package at.fhv.itm14.fhvgis.analysis.model;

public class FeatureVector {

	private double avgSpeed;
	private double avgAcc;
	private double maxSpeed;
	private double minSpeed;
	private String transportationMode;

	public FeatureVector(double avgSpeed, double avgAcc, double maxSpeed, double minSpeed, String transportationMode) {
		this.avgSpeed = avgSpeed;
		this.avgAcc = avgAcc;
		this.maxSpeed = maxSpeed;
		this.minSpeed = minSpeed;
		this.transportationMode = transportationMode;
	}

	public double getAvgSpeed() {
		return avgSpeed;
	}

	public double getAvgAcc() {
		return avgAcc;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getMinSpeed() {
		return minSpeed;
	}

	public String getTransportationMode() {
		return transportationMode;
	}

}
