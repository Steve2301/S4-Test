package at.fhv.itm14.fhvgis.persistence;

import java.util.List;
import java.util.UUID;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Geofence;
import at.fhv.itm14.fhvgis.domain.Log;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.Transportation;
import at.fhv.itm14.fhvgis.domain.TransportationRoute;
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

	@Override
	public User findUser(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getUserDaoInstance().find(id);
	}

	@Override
	public Track findTrack(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getTrackDaoInstance().find(id);
	}

	@Override
	public Device findDevice(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getDeviceDaoInstance().find(id);
	}

	@Override
	public Waypoint findWaypoint(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getWaypointDaoInstance().find(id);
	}

	@Override
	public Log findLog(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getLogDaoInstance().find(id);
	}

	@Override
	public void updateTransportation(Transportation transportation) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationDaoInstance().update(transportation);
	}

	@Override
	public void updateTransportationRoute(TransportationRoute transportationRoute) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationRouteDaoInstance().update(transportationRoute);
	}

	@Override
	public void deleteTransportation(Transportation transportation) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationDaoInstance().delete(transportation);
	}

	@Override
	public void deleteTransportationRoute(TransportationRoute transportationRoute) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationRouteDaoInstance().delete(transportationRoute);		
	}

	@Override
	public List<Transportation> findAllTransportations() {
		return _databaseFacade.getDatabaseDaoFacade().getTransportationDaoInstance().findAll();
	}

	@Override
	public List<TransportationRoute> findAllTransportationRoutes() {
		return  _databaseFacade.getDatabaseDaoFacade().getTransportationRouteDaoInstance().findAll();
	}

	@Override
	public Transportation findTransportation(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getTransportationDaoInstance().find(id);
	}

	@Override
	public TransportationRoute findTransportationRoute(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getTransportationRouteDaoInstance().find(id);

	}

	@Override
	public void persistTransportation(Transportation transportation) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationDaoInstance().persist(transportation);
	}

	@Override
	public void persistTransportationRoute(TransportationRoute transportationRoute) {
		_databaseFacade.getDatabaseDaoFacade().getTransportationRouteDaoInstance().persist(transportationRoute);
	}

	@Override
	public void persistPOI(POI poi) {
		_databaseFacade.getDatabaseDaoFacade().getPoiDaoInstance().persist(poi);	
	}

	@Override
	public void persistGeofence(Geofence geofence) {
		_databaseFacade.getDatabaseDaoFacade().getGeofenceDaoInstance().persist(geofence);		
	}

	@Override
	public void updatePOI(POI poi) {
		_databaseFacade.getDatabaseDaoFacade().getPoiDaoInstance().update(poi);	
	}

	@Override
	public void updateGeofence(Geofence geofence) {
		_databaseFacade.getDatabaseDaoFacade().getGeofenceDaoInstance().update(geofence);
	}

	@Override
	public void deletePOI(POI poi) {
		_databaseFacade.getDatabaseDaoFacade().getPoiDaoInstance().delete(poi);
	}

	@Override
	public void deleteGeofence(Geofence geofence) {
		_databaseFacade.getDatabaseDaoFacade().getGeofenceDaoInstance().delete(geofence);
	}

	@Override
	public List<POI> findAllPOIs() {
		return _databaseFacade.getDatabaseDaoFacade().getPoiDaoInstance().findAll();
	}

	@Override
	public List<Geofence> findAllGeofences() {
		return 	_databaseFacade.getDatabaseDaoFacade().getGeofenceDaoInstance().findAll();

	}

	@Override
	public POI findPOI(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getPoiDaoInstance().find(id);
	}

	@Override
	public Geofence findGeofence(UUID id) {
		return _databaseFacade.getDatabaseDaoFacade().getGeofenceDaoInstance().find(id);
	}


}
