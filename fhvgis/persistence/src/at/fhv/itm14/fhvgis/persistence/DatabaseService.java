package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

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
	public void insertUser(User user) {
		_serviceFacade.getUserDaoInstance().save(user);
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
	public void insertSchedule(Shedule schedule) {
		_serviceFacade.getScheduleDaoInstance().save(schedule);

	}

	@Override
	public void insertDevice(Device device) {
		_serviceFacade.getDeviceDaoInstance().save(device);
	}

	@Override
	public void insertTrack(Track track) {
		_serviceFacade.getTrackDaoInstance().save(track);
	}

	@Override
	public void insertPoi(Poi poi) {
		_serviceFacade.getPoiDaoInstance().save(poi);
	}

	@Override
	public void insertWaypoint(Waypoint waypoint) {
		_serviceFacade.getWaypointDaoInstance().save(waypoint);
	}

	@Override
	public void writeToLog(Log log) {
		_serviceFacade.getLogDaoInstance().save(log);
	}

	@Override
	public void updateUser(User user) {
		_serviceFacade.getUserDaoInstance().save(user);

	}

	@Override
	public User getUserByName(String username) {
		return _serviceFacade.getUserDaoInstance().findUserByName(username);
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) {
			deleteDeviceByUser(user);
			_serviceFacade.getUserDaoInstance().delete(user);
		}

	}

	public void deleteDevice(Device device) {
		_serviceFacade.getDeviceDaoInstance().delete(device);
	}

	public void deleteDeviceByUser(User user) {
		_serviceFacade.getDeviceDaoInstance().deleteDeviceByUser(user);
	}

}
