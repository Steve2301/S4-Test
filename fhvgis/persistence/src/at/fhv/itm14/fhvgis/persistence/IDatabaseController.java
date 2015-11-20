package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Log;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.domain.Waypoint;


public interface IDatabaseController {
	
	public List<User> getAllUsers();
	public List<Device> getAllDevices();
	public List<POI> getAllPois();
	public List<Track> getAllTracks();
	public List<Schedule> getAllSchedules();
	public List<Waypoint> getAllWaypoints();
	public List<Log> getAllLogs();

	/* add (is also update) */
	public void addUser(User user);
	public void addSchedule(Schedule schedule);
	public void addDevice(Device device);
	public void addTrack(Track track);
	public void addPoi(POI poi);
	public void addWaypoint(Waypoint waypoint);
	public void addLog(Log log);
	
	/* remove */
	public void removeUser(User user);
	public void removeSchedule(Schedule schedule);
	public void removeDevice(Device device);
	public void removeTrack(Track track);
	public void removePoi(POI poi);
	public void removeWaypoint(Waypoint waypoint);
	public void removeLog(Log log);
	
	
	/* -----Misc------ */
	public User getUserByName(String username);
	public User getUserByDeviceId(String deviceId);
	public List<POI> getPOIsByPosition(Geometry position);
	public List<Schedule> getScheduleByPositionAndTime(Geometry position, Date date);
	public List<Track> getTrackByDevice(String deviceId);
	public List<Track> getTrackByUser(String name);



}
