package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint;

public class DatabaseService implements IDatabaseService {

	private static DatabaseService _instance;

	private IDatabaseServiceFacade _serviceFacade;

	private DatabaseService() {
		_serviceFacade = DatabaseServiceFacade.getInstance();
	}

	public static DatabaseService getInstance() {
		if (_instance == null) {
			_instance = new DatabaseService();
		}
		return _instance;
	}

	@Override
	public List<User> getAllUsers() {
		return _serviceFacade.getUserDaoInstance().findAll(User.class);
	}

	@Override
	public List<Device> getAllDevices() {
		return _serviceFacade.getDeviceDaoInstance().findAll(Device.class);
	}

	@Override
	public List<Poi> getAllPois() {
		return _serviceFacade.getPoiDaoInstance().findAll(Poi.class);
	}

	@Override
	public List<Track> getAllTracks() {
		return _serviceFacade.getTrackDaoInstance().findAll(Track.class);
	}

	@Override
	public List<Shedule> getAllSchedules() {
		return _serviceFacade.getScheduleDaoInstance().findAll(Shedule.class);
	}

	@Override
	public List<Waypoint> getAllWaypoints() {
		return _serviceFacade.getWaypointDaoInstance().findAll(Waypoint.class);
	}

	@Override
	public List<Log> getAllLogs() {
		return _serviceFacade.getLogDaoInstance().findAll(Log.class);
	}

	@Override
	public void addUser(User user) {
		_serviceFacade.getUserDaoInstance().save(user);
	}

	@Override
	public void addSchedule(Shedule schedule) {
		_serviceFacade.getScheduleDaoInstance().save(schedule);
	}

	@Override
	public void addDevice(Device device) {
		_serviceFacade.getDeviceDaoInstance().save(device);
	}

	@Override
	public void addTrack(Track track) {
		_serviceFacade.getTrackDaoInstance().save(track);
	}

	@Override
	public void addPoi(Poi poi) {
		_serviceFacade.getPoiDaoInstance().save(poi);
	}

	@Override
	public void addWaypoint(Waypoint waypoint) {
		_serviceFacade.getWaypointDaoInstance().save(waypoint);
	}

	@Override
	public void addLog(Log log) {
		_serviceFacade.getLogDaoInstance().save(log);
	}

	@Override
	public void removeUser(User user) {
		_serviceFacade.getUserDaoInstance().delete(user);
	}

	@Override
	public void removeSchedule(Shedule schedule) {
		_serviceFacade.getScheduleDaoInstance().delete(schedule);		
	}

	@Override
	public void removeDevice(Device device) {
		_serviceFacade.getDeviceDaoInstance().delete(device);
	}

	@Override
	public void removeTrack(Track track) {
		_serviceFacade.getTrackDaoInstance().delete(track);
	}

	@Override
	public void removePoi(Poi poi) {
		_serviceFacade.getPoiDaoInstance().delete(poi);
	}

	@Override
	public void removeWaypoint(Waypoint waypoint) {
		_serviceFacade.getWaypointDaoInstance().delete(waypoint);
	}

	@Override
	public void removeLog(Log log) {
		_serviceFacade.getLogDaoInstance().delete(log);		
	}

	@Override
	public User getUserByName(String username) {
		return _serviceFacade.getUserDaoInstance().findUserByName(username);
	}

	@Override
	public User getUserByDeviceId(String deviceId) {
		return _serviceFacade.getUserDaoInstance().findUserByDevice(deviceId);
	}

	@Override
	public List<Poi> getPoisByPosition(Geometry position) {
		return _serviceFacade.getPoiDaoInstance().findPoisByPosition(position);
	}

	@Override
	public List<Shedule> getScheduleByPositionAndTime(Geometry position, Date date) {
		return _serviceFacade.getScheduleDaoInstance().findScheduleByPositionAndTime(position,date);
	}

	@Override
	public List<Track> getTrackByDevice(String deviceId) {
		return _serviceFacade.getTrackDaoInstance().getTrackByDevice(deviceId);
	}

	@Override
	public List<Track> getTrackByUser(String name) {
		return _serviceFacade.getTrackDaoInstance().getTrackByUser(name);
	}

}