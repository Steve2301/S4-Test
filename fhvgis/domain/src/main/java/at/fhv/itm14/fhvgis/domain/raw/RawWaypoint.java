package at.fhv.itm14.fhvgis.domain.raw;

import at.fhv.itm14.fhvgis.domain.DomainEntity;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.Transportation;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Author: Philip Heimböck
 * Date: 03.12.15.
 */
@Entity
@Table(name = "raw_waypoint", schema = "public")
public class RawWaypoint extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int externalId;
    private int nrOfSatellites;
    private long timestamp;
    private double accuracy;
    private double speed;
    private double bearing;
    private String provider;
    private double longitude;
    private double latitude;
    private double altitude;

    private Transportation vehicle;
    private Track track;
    
    public RawWaypoint(){
    	
    }

    public RawWaypoint(int externalId, int nrOfSatellites, long timestamp, double accuracy, double speed, String provider, double bearing, double longitude, double latitude, double altitude, Transportation vehicle, Track track) {
        this.externalId = externalId;
        this.nrOfSatellites = nrOfSatellites;
        this.timestamp = timestamp;
        this.accuracy = accuracy;
        this.speed = speed;
        this.provider = provider;
        this.bearing = bearing;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.vehicle = vehicle;
        this.track = track;
    }
    
    @Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "external_id")
    public int getExternalId() {
        return externalId;
    }

    public void setExternalId(int externalId) {
        this.externalId = externalId;
    }
    
    @Column(name = "nr_of_satellites")
    public int getNrOfnSatellites() {
        return nrOfSatellites;
    }

    public void setNrOfnSatellites(int nrOfSatellites) {
        this.nrOfSatellites = nrOfSatellites;
    }
    
    @Column(name = "timestamp", length = 29)
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Column(name = "accuracy", precision = 17, scale = 17)
    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
    
    @Column(name = "speed", precision = 17, scale = 17)
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
	@Column(name = "provider")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    
    @Column(name = "longitude", precision = 17, scale = 17)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    @Column(name = "latitude", precision = 17, scale = 17)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    @Column(name = "altitude", precision = 17, scale = 17)
    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_id")
    public Transportation getVehicle() {
        return vehicle;
    }

    public void setVehicle(Transportation vehicle) {
        this.vehicle = vehicle;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", nullable = false)
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
    
	@Column(name = "bearing", precision = 17, scale = 17)
    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }
}