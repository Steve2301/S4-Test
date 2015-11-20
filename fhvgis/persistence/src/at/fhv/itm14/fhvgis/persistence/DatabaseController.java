package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;

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
		List<User> rv = new LinkedList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList = _databaseFacade.getDatabaseService()
				.getAllUsers();
		if (dbUserList != null) {
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseUserList(dbUserList);
		}
		return rv;
	}

	@Override
	public List<Device> getAllDevices() {
		List<Device> rv = new LinkedList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList = _databaseFacade
				.getDatabaseService().getAllDevices();
		if (dbDeviceList != null) {
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseDeviceList(dbDeviceList);
		}
		return rv;
	}

	@Override
	public void insertUser(User user) {
		_databaseFacade.getDatabaseService().insertUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));

	}

	@Override
	public List<POI> getPOIsByPosition(Geometry position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> getScheduleByPositionAndTime(Geometry position, Date date) {
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

	@Override
	public User getUserByName(String username) {
		User rv = _databaseFacade.getDatabaseMapper()
				.mapDatabaseUser(_databaseFacade.getDatabaseService().getUserByName(username));
		return rv;
	}

	@Override
	public void updateUser(User user) {
		_databaseFacade.getDatabaseService().updateUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));
	}

	@Override
	public void deleteUser(User user) {
		_databaseFacade.getDatabaseService().deleteUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));

	}

	// new methods

}
