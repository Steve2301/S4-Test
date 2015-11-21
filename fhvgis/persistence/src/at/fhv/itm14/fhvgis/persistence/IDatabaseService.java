package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Geofence;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Transportation;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;

public interface IDatabaseService {
	
	/* -----General----- */

	/* findAll* */
	public List<User> getAllUsers();
	public List<Device> getAllDevices();
	public List<Poi> getAllPois();
	public List<Track> getAllTracks();
	public List<Shedule> getAllSchedules();
	public List<Waypoint> getAllWaypoints();
	public List<Log> getAllLogs();
	public List<Geofence> getAllGeofences();
	public List<Transportation> getAllTransportation();

	/* add (is also update) */
	public void addUser(User user);
	public void addSchedule(Shedule schedule);
	public void addDevice(Device device);
	public void addTrack(Track track);
	public void addPoi(Poi poi);
	public void addWaypoint(Waypoint waypoint);
	public void addLog(Log log);
	public void addGeofence(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Geofence mapDomainGeofence);
	public void addTransportation(
			at.fhv.itm14.fhvgis.persistence.hibernate.objects.Transportation mapDomainTransportation);
	
	
	/* remove */
	public void removeUser(User user);
	public void removeSchedule(Shedule schedule);
	public void removeDevice(Device device);
	public void removeTrack(Track track);
	public void removePoi(Poi poi);
	public void removeWaypoint(Waypoint waypoint);
	public void removeLog(Log log);
	public void removeGeofence(Geofence geofence);
	public void removeTransportation(
			at.fhv.itm14.fhvgis.persistence.hibernate.objects.Transportation mapDomainTransportation);
	
	
	/* -----misc------ TODO implement these*/ 
	public User getUserByName(String username);
	public User getUserByDeviceId(String deviceId);
	public List<Poi> getPoisByPosition(Geometry position);
	public List<Shedule> getScheduleByPositionAndTime(Geometry position, Date date);
	public List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> getTrackByDevice(String deviceId);
	public List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> getTrackByUser(String name);



}
