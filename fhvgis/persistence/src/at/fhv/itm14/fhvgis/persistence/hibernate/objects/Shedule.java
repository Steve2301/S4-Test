package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 29.10.2015 22:12:10 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Shedule generated by hbm2java
 */
@Entity
@Table(name = "shedule", schema = "public")
public class Shedule implements java.io.Serializable {

	private String id;
	private TransportationRoute transportationRoute;
	private Shedule shedule;
	private SheduleDay sheduleDay;
	private int tripNr;
	private Date validFrom;
	private Date validUntil;
	private Date explicitDate;
	private Date arrivalTime;
	private Date departureTime;
	private Integer seqNo;
	private Set<Shedule> shedules = new HashSet<Shedule>(0);

	public Shedule() {
	}

	public Shedule(String id, TransportationRoute transportationRoute, Shedule shedule, SheduleDay sheduleDay,
			int tripNr, Date arrivalTime) {
		this.id = id;
		this.transportationRoute = transportationRoute;
		this.shedule = shedule;
		this.sheduleDay = sheduleDay;
		this.tripNr = tripNr;
		this.arrivalTime = arrivalTime;
	}

	public Shedule(String id, TransportationRoute transportationRoute, Shedule shedule, SheduleDay sheduleDay,
			int tripNr, Date validFrom, Date validUntil, Date explicitDate, Date arrivalTime, Date departureTime,
			Integer seqNo, Set<Shedule> shedules) {
		this.id = id;
		this.transportationRoute = transportationRoute;
		this.shedule = shedule;
		this.sheduleDay = sheduleDay;
		this.tripNr = tripNr;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.explicitDate = explicitDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seqNo = seqNo;
		this.shedules = shedules;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_route_id", nullable = false)
	public TransportationRoute getTransportationRoute() {
		return this.transportationRoute;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_id", nullable = false)
	public Shedule getShedule() {
		return this.shedule;
	}

	public void setShedule(Shedule shedule) {
		this.shedule = shedule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shedule_day_id", nullable = false)
	public SheduleDay getSheduleDay() {
		return this.sheduleDay;
	}

	public void setSheduleDay(SheduleDay sheduleDay) {
		this.sheduleDay = sheduleDay;
	}

	@Column(name = "trip_nr", nullable = false)
	public int getTripNr() {
		return this.tripNr;
	}

	public void setTripNr(int tripNr) {
		this.tripNr = tripNr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valid_from", length = 29)
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valid_until", length = 29)
	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "explicit_date", length = 29)
	public Date getExplicitDate() {
		return this.explicitDate;
	}

	public void setExplicitDate(Date explicitDate) {
		this.explicitDate = explicitDate;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "arrival_time", nullable = false, length = 15)
	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "departure_time", length = 15)
	public Date getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name = "seq_no")
	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shedule")
	public Set<Shedule> getShedules() {
		return this.shedules;
	}

	public void setShedules(Set<Shedule> shedules) {
		this.shedules = shedules;
	}

}
