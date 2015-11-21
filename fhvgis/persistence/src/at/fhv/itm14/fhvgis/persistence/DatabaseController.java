package at.fhv.itm14.fhvgis.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Log;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;

public class DatabaseController implements IDatabaseController {

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
	public List<User> getAllUsers() {
		List<User> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList = _databaseFacade.getDatabaseService()
				.getAllUsers();
		if (dbUserList != null) {
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseUserList(dbUserList);
		}
		return rv;
	}

	@Override
	public List<Device> getAllDevices() {
		List<Device> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList = _databaseFacade
				.getDatabaseService().getAllDevices();
		if (dbDeviceList != null) {
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseDeviceList(dbDeviceList);
		}
		return rv;
	}
	
	@Override
	public List<POI> getAllPois() {
		List<POI> rv = new ArrayList<>();
		List<Poi> dbPoiList = _databaseFacade.getDatabaseService().getAllPois();
		if(dbPoiList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabasePoiList(dbPoiList);
		}
		return rv;
	}

	@Override
	public List<Track> getAllTracks() {
		List<Track> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> dbTrackList = _databaseFacade.getDatabaseService().getAllTracks();
		if(dbTrackList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseTrackList(dbTrackList);
		}
		return rv;
	}

	@Override
	public List<Schedule> getAllSchedules() {
		List<Schedule> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule> dbScheduleList = _databaseFacade.getDatabaseService().getAllSchedules();
		if(dbScheduleList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseScheduleList(dbScheduleList);
		}
		return rv;
	}

	@Override
	public List<Waypoint> getAllWaypoints() {
		List<Waypoint> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint> dbScheduleList = _databaseFacade.getDatabaseService().getAllWaypoints();
		if(dbScheduleList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseWaypointList(dbScheduleList);
		}
		return rv;
	}

	@Override
	public List<Log> getAllLogs() {
		List<Log> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log> dbScheduleList = _databaseFacade.getDatabaseService().getAllLogs();
		if(dbScheduleList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseLogList(dbScheduleList);
		}
		return rv;
	}


	@Override
	public List<POI> getPOIsByPosition(Geometry position) {
		List<POI> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi> dbPoiList = _databaseFacade.getDatabaseService().getPoisByPosition(position);
		if(dbPoiList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabasePoiList(dbPoiList);
		}
		return rv;
	}

	@Override
	public List<Schedule> getScheduleByPositionAndTime(Geometry position, Date date) {
		List<Schedule> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule> dbScheduleList = _databaseFacade.getDatabaseService().getScheduleByPositionAndTime(position,date);
		if(dbScheduleList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseScheduleList(dbScheduleList);
		}
		return rv;
	}

	@Override
	public List<Track> getTrackByDevice(String deviceId) {
		List<Track> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> dbTrackList = _databaseFacade.getDatabaseService().getTrackByDevice(deviceId);
		if(dbTrackList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseTrackList(dbTrackList);
		}
		return rv;
	}

	@Override
	public List<Track> getTrackByUser(String name) {
		List<Track> rv = new ArrayList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track> dbTrackList = _databaseFacade.getDatabaseService().getTrackByUser(name);
		if(dbTrackList != null){
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseTrackList(dbTrackList);
		}
		return rv;
	}

	@Override
	public User getUserByName(String username) {
		User rv = _databaseFacade.getDatabaseMapper()
				.mapDatabaseUser(_databaseFacade.getDatabaseService().getUserByName(username));
		return rv;
	}

	@Override
	public void addUser(User user) {
		_databaseFacade.getDatabaseService().addUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));
	}

	@Override
	public void removeUser(User user) {
		_databaseFacade.getDatabaseService().removeUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));

	}

	@Override
	public void addSchedule(Schedule schedule) {
		_databaseFacade.getDatabaseService().addSchedule(_databaseFacade.getDatabaseMapper().mapDomainSchedule(schedule));
		
	}

	@Override
	public void addDevice(Device device) {
		_databaseFacade.getDatabaseService().addDevice(_databaseFacade.getDatabaseMapper().mapDomainDevice(device));
	}

	@Override
	public void addTrack(Track track) {
		_databaseFacade.getDatabaseService().addTrack(_databaseFacade.getDatabaseMapper().mapDomainTrack(track));
	}

	@Override
	public void addPoi(POI poi) {
		_databaseFacade.getDatabaseService().addPoi(_databaseFacade.getDatabaseMapper().mapDomainPoi(poi));
	}

	@Override
	public void addWaypoint(Waypoint waypoint) {
		_databaseFacade.getDatabaseService().addWaypoint(_databaseFacade.getDatabaseMapper().mapDomainWaypoint(waypoint));
	}

	@Override
	public void addLog(Log log) {
		_databaseFacade.getDatabaseService().addLog(_databaseFacade.getDatabaseMapper().mapDomainLog(log));
		
	}

	@Override
	public void removeSchedule(Schedule schedule) {
		_databaseFacade.getDatabaseService().removeSchedule(_databaseFacade.getDatabaseMapper().mapDomainSchedule(schedule));
	}

	@Override
	public void removeDevice(Device device) {
		_databaseFacade.getDatabaseService().removeDevice(_databaseFacade.getDatabaseMapper().mapDomainDevice(device));
	}

	@Override
	public void removeTrack(Track track) {
		_databaseFacade.getDatabaseService().removeTrack(_databaseFacade.getDatabaseMapper().mapDomainTrack(track));
	}

	@Override
	public void removePoi(POI poi) {
		_databaseFacade.getDatabaseService().removePoi(_databaseFacade.getDatabaseMapper().mapDomainPoi(poi));
	}

	@Override
	public void removeWaypoint(Waypoint waypoint) {
		_databaseFacade.getDatabaseService().removeWaypoint(_databaseFacade.getDatabaseMapper().mapDomainWaypoint(waypoint));	
	}

	@Override
	public void removeLog(Log log) {
		_databaseFacade.getDatabaseService().removeLog(_databaseFacade.getDatabaseMapper().mapDomainLog(log));	
	}

	@Override
	public User getUserByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	// new methods

}
