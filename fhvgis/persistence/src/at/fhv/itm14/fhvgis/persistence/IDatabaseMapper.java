package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;

public interface IDatabaseMapper {

	public User mapDatabaseUser(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User dbUser);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.User mapDomainUser(User domainUser);
	public List<User> mapDatabaseUserList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList);
	public List<Device> mapDatabaseDeviceList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList);
	public Device mapDatabaseDevice(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device dbDevice);
	
	public POI mapDatabasePoi(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi poi);
	public List<POI> mapDatabasePoiList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi> pois);

	public Track mapDatabaseTrack(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track track);
	public List<Track> mapDatabaseTrackList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> tracks);
	public List<Schedule> mapDatabaseScheduleList(List<Shedule> dbScheduleList);
	public Schedule mapDatabaseSchedule(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule schedule);
	public List<Waypoint> mapDatabaseWaypointList(
			List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint> dbScheduleList);
	public Waypoint mapDatabaseWaypoint(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint waypoint);
	public List<Log> mapDatabaseLogList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log> dbScheduleList);
	public Log mapDatabaseLog(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log log);
	public Shedule mapDomainSchedule(Schedule schedule);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device mapDomainDevice(Device device);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track mapDomainTrack(Track track);
	public Poi mapDomainPoi(POI poi);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint mapDomainWaypoint(Waypoint waypoint);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log mapDomainLog(Log log);
}
