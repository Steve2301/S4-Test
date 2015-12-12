package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public interface IDatabaseController {
	
	void persistUser(User user);
	void persistTrack(Track track);
	void persistDevice(Device device);
	void persistWaypoint(Waypoint waypoint);
	void persistLog(Log log);
	
	void updateUser(User user);
	void updateTrack(Track track);
	void updateDevice(Device device);
	void updateWaypoint(Waypoint waypoint);
	void updateLog(Log log);
	
	void deleteUser(User user);
	void deleteTrack(Track track);
	void deleteDevice(Device device);
	void deleteWaypoint(Waypoint waypoint);
	void deleteLog(Log log);
	
	List<User> findAllUsers();
	List<Track> findAllTracks();
	List<Device> findAllDevices();
	List<Waypoint> findAllWaypoints();
	List<Log> findAllLogs();
	
	User findUserByUsername(String username);
	Device findDeviceByDeviceId(String deviceId);
	
	

}
