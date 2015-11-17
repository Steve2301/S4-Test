package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransportationTrip extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private TransportationRoute transportationRoute;
	private List<Schedule> schedules;
	private LocalDate validFrom;
	private LocalDate validTo;
	// e.g. other schedule on official holiday
	private LocalDate explicitDate;
	// days is empty if explicitDate is set & vice versa
	private List<DayOfWeek> days;

	public TransportationTrip(TransportationRoute transportationRoute, LocalDate validFrom, List<DayOfWeek> days) {
		this(transportationRoute, null, validFrom, null, null, days);
	}

	public TransportationTrip(TransportationRoute transportationRoute, List<Schedule> schedules, LocalDate validFrom,
			LocalDate validTo, LocalDate explicitDate, List<DayOfWeek> days) {
		super();
		this.transportationRoute = transportationRoute;
		this.schedules = schedules;
		if (schedules == null) {
			this.schedules = new ArrayList<>();
		}
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.explicitDate = explicitDate;
		this.days = days;
		if (days == null) {
			this.days = new ArrayList<>();
		}
	}

	public boolean isValid(LocalDate date) {
		// TODO check explicitDate & days regarding given date
		throw new RuntimeException("Not implemented.");
	}

	public void addSchedule(Schedule schedule) {
		this.schedules.addAll(schedules);
	}

	public void removeSchedule(Schedule schedule) {
		this.schedules.remove(schedule);
	}

	public List<Schedule> getSchedules() {
		return new ArrayList<>(schedules);
	}

	public TransportationRoute getTransportationRoute() {
		return transportationRoute;
	}

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

	public LocalDate getExplicitDate() {
		return explicitDate;
	}

	public List<DayOfWeek> getDays() {
		return new ArrayList<>(days);
	}

}
