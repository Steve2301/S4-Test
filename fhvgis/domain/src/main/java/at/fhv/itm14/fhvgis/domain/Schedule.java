package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name = "schedule", schema = "public")
public class Schedule extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Date explicitDate;
	private Date validFrom;
	private Date validUntil;
	private TransportationTrip transportationTrip;
	private TransportationRoute transportationRoute;
	private POI poi;
	private int tripNr;
	private int seqNo;
	
	public Schedule(){
		
	}
	
	public Schedule(LocalTime arrivalTime, LocalTime departureTime, TransportationTrip transportationTrip, POI poi) {
		super();
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.transportationTrip = transportationTrip;
		this.poi = poi;
	}

	public Schedule(UUID id, LocalTime arrivalTime, LocalTime departureTime, TransportationTrip transportationTrip,
			POI poi) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.transportationTrip = transportationTrip;
		this.poi = poi;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	@Column(name = "arrival_time", nullable = false, length = 15)
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	
	@Column(name = "departure_time", length = 15)
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	
	@Transient
	public TransportationTrip getTransportationTrip() {
		return transportationTrip;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poi_id", nullable = false)
	public POI getPoi() {
		return poi;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_route_id", nullable = false)
	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}

	public void setTransportationRoute(TransportationRoute transportationRoute) {
		this.transportationRoute = transportationRoute;
	}
	
	@Column(name = "trip_nr", nullable = false)
	public int getTripNr() {
		return this.tripNr;
	}

	public void setTripNr(int tripNr) {
		this.tripNr = tripNr;
	}
	
	@Column(name = "seq_no")
	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	
	@Column(name = "explicit_date", length = 29)
	public Date getExplicitDate() {
		return this.explicitDate;
	}

	public void setExplicitDate(Date explicitDate) {
		this.explicitDate = explicitDate;
	}
	
	@Column(name = "valid_until", length = 29)
	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	
	@Column(name = "valid_from", length = 29)
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setTransportationTrip(TransportationTrip transportationTrip) {
		this.transportationTrip = transportationTrip;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	
}
