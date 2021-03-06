package at.fhv.itm14.fhvgis.persistence.hibernate.objects;

// default package
// Generated 17.11.2015 09:21:54 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.UUIDBinaryType;

/**
 * MotionValues generated by hbm2java
 */
@Entity
@Table(name = "motion_values", schema = "public")
public class MotionValues implements java.io.Serializable {

	private UUID id;
	private Device device;
	private Double x;
	private Double y;
	private Double z;
	private Integer motionType;
	private Integer isExported;
	private Long dateTimeCaptured;

	public MotionValues() {
	}

	public MotionValues(UUID id, Device device) {
		this.id = id;
		this.device = device;
	}

	public MotionValues(UUID id, Device device, Double x, Double y, Double z, Integer motionType,
			Integer isExported, Long dateTimeCaptured) {
		this.id = id;
		this.device = device;
		this.x = x;
		this.y = y;
		this.z = z;
		this.motionType = motionType;
		this.isExported = isExported;
		this.dateTimeCaptured = dateTimeCaptured;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", nullable = false)
	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Column(name = "x", precision = 17, scale = 17)
	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	@Column(name = "y", precision = 17, scale = 17)
	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Column(name = "z", precision = 17, scale = 17)
	public Double getZ() {
		return this.z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	@Column(name = "motion_type")
	public Integer getMotionType() {
		return this.motionType;
	}

	public void setMotionType(Integer motionType) {
		this.motionType = motionType;
	}

	@Column(name = "is_exported")
	public Integer getIsExported() {
		return this.isExported;
	}

	public void setIsExported(Integer isExported) {
		this.isExported = isExported;
	}

	@Column(name = "date_time_captured")
	public Long getDateTimeCaptured() {
		return this.dateTimeCaptured;
	}

	public void setDateTimeCaptured(Long dateTimeCaptured) {
		this.dateTimeCaptured = dateTimeCaptured;
	}

}
