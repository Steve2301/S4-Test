package at.fhv.itm14.fhvgis.domain.raw;

import at.fhv.itm14.fhvgis.domain.*;


import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Author: Philip Heimböck
 * Date: 03.12.15.
 */
@Entity
@Table(name = "raw_motion_value", schema = "public")
public class RawMotionValue extends DomainEntity implements Serializable {

   
	private static final long serialVersionUID = 1L;
	private int externalId;
    private double x;
    private double y;
    private double z;
    private int motionType;
    private long timestamp;
    private Device device;
    
    public RawMotionValue(){
    	
    }

    public RawMotionValue(int externalId, double x, double y, double z, int motionType, long timestamp) {
        this.externalId = externalId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.motionType = motionType;
        this.timestamp = timestamp;
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
    
	@Column(name = "x", precision = 17, scale = 17)
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    
	@Column(name = "y", precision = 17, scale = 17)
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
	@Column(name = "z", precision = 17, scale = 17)
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
	@Column(name = "motion_type")
    public int getMotionType() {
        return motionType;
    }

    public void setMotionType(int motionType) {
        this.motionType = motionType;
    }
    
    @Column(name = "timestamp", length = 29)
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}