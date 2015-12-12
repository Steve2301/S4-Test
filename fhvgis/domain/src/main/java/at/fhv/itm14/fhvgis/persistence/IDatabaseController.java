package at.fhv.itm14.fhvgis.persistence;

import java.util.List;
import java.util.UUID;

import at.fhv.itm14.fhvgis.domain.*;

public interface IDatabaseController {
	
	/* Save objects */
	void persistUser(User user);
	void persistTrack(Track track);
	void persistDevice(Device device);
	void persistWaypoint(Waypoint waypoint);
	void persistLog(Log log);
	void persistTransportation(Transportation transportation);
	void persistTransportationRoute(TransportationRoute transportationRoute);
	
	/* Update existing objects*/
	void updateUser(User user);
	void updateTrack(Track track);
	void updateDevice(Device device);
	void updateWaypoint(Waypoint waypoint);
	void updateLog(Log log);
	void updateTransportation(Transportation transportation);
	void updateTransportationRoute(TransportationRoute transportationRoute);
	
	/* Remove objects */
	void deleteUser(User user);
	void deleteTrack(Track track);
	void deleteDevice(Device device);
	void deleteWaypoint(Waypoint waypoint);
	void deleteLog(Log log);
	void deleteTransportation(Transportation transportation);
	void deleteTransportationRoute(TransportationRoute transportationRoute);
	
	/* Get all the objects  of a certain type */
	List<User> findAllUsers();
	List<Track> findAllTracks();
	List<Device> findAllDevices();
	List<Waypoint> findAllWaypoints();
	List<Log> findAllLogs();
	List<Transportation> findAllTransportations();
	List<TransportationRoute> findAllTransportationRoutes();
	
	/* Get objects by their UUID */
	User findUser(UUID id);
	Track findTrack(UUID id);
	Device findDevice(UUID id);
	Waypoint findWaypoint(UUID id);
	Log findLog(UUID id);
	Transportation findTransportation(UUID id);
	TransportationRoute findTransportationRoute(UUID id);
	
	/* Miscellaneous */
	
	Device findDeviceByDeviceId(String deviceId);
	User findUserByUsername(String username);
	

}
