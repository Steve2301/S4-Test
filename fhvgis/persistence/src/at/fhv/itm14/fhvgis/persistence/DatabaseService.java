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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> getAllDevices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poi> getAllPois() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getAllTracks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shedule> getAllSchedules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Waypoint> getAllWaypoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> getAllLogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSchedule(Shedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrack(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPoi(Poi poi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWaypoint(Waypoint waypoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSchedule(Shedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDevice(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrack(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePoi(Poi poi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeWaypoint(Waypoint waypoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLog(Log log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poi> getPoisByPosition(Geometry position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shedule> getScheduleByPositionAndTime(Geometry position, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTrackByDevice(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTrackByUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}