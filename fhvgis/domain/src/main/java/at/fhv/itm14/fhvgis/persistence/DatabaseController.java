package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Log;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.domain.Waypoint;

public class DatabaseController implements IDatabaseController{
	
	private static DatabaseController _instance;
	private IDatabaseFacade _databaseFacade;

	private DatabaseController() {
		_databaseFacade = DatabaseFacade.getInstance();
	}

	public static DatabaseController getInstance() {
		if (_instance == null) {
			_instance = new DatabaseController();
		}
		return _instance;
	}
	

	@Override
	public User findUserByUsername(String username) {
		return _databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().findUserByName(username);
	}

	@Override
	public Device findDeviceByDeviceId(String deviceId) {
		return _databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().findDeviceByDeviceId(deviceId);
	}

	@Override
	public void persistUser(User user) {
		_databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().persist(user);
	}

	@Override
	public void persistTrack(Track track) {
		_databaseFacade.getDatabaseDaoFacade().getTrackDaoInstance().persist(track);	
	}

	@Override
	public void persistDevice(Device device) {
		_databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().persist(device);
	}

	@Override
	public void persistWaypoint(Waypoint waypoint) {
		_databaseFacade.getDatabaseDaoFacade().getWaypointDaoInstance().persist(waypoint);	
	}

	@Override
	public void persistLog(Log log) {
		_databaseFacade.getDatabaseDaoFacade().getLogDaoInstance().persist(log);	
	}

	@Override
	public void updateUser(User user) {
		_databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().update(user);
	}

	@Override
	public void updateTrack(Track track) {
		_databaseFacade.getDatabaseDaoFacade().getTrackDaoInstance().update(track);	
	}

	@Override
	public void updateDevice(Device device) {
		_databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().update(device);
	}

	@Override
	public void updateWaypoint(Waypoint waypoint) {
		_databaseFacade.getDatabaseDaoFacade().getWaypointDaoInstance().update(waypoint);
	}

	@Override
	public void updateLog(Log log) {
		_databaseFacade.getDatabaseDaoFacade().getLogDaoInstance().update(log);
	}

	@Override
	public void deleteUser(User user) {
		_databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().delete(user);
	}

	@Override
	public void deleteTrack(Track track) {
		_databaseFacade.getDatabaseDaoFacade().getTrackDaoInstance().delete(track);
	}

	@Override
	public void deleteDevice(Device device) {
		_databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().delete(device);
	}

	@Override
	public void deleteWaypoint(Waypoint waypoint) {
		_databaseFacade.getDatabaseDaoFacade().getWaypointDaoInstance().delete(waypoint);
	}

	@Override
	public void deleteLog(Log log) {
		_databaseFacade.getDatabaseDaoFacade().getLogDaoInstance().delete(log);
	}

	@Override
	public List<User> findAllUsers() {
		return _databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().findAll();
	}

	@Override
	public List<Track> findAllTracks() {
		return _databaseFacade.getDatabaseDaoFacade().getTrackDaoInstance().findAll();

	}

	@Override
	public List<Device> findAllDevices() {
		return _databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().findAll();
	}

	@Override
	public List<Waypoint> findAllWaypoints() {
		return _databaseFacade.getDatabaseDaoFacade().getWaypointDaoInstance().findAll();
	}

	@Override
	public List<Log> findAllLogs() {
		return _databaseFacade.getDatabaseDaoFacade().getLogDaoInstance().findAll();
	}


}
