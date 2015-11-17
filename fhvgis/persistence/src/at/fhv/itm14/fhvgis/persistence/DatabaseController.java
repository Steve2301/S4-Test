package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
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
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList = _databaseFacade.getDatabaseConnector()
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
				.getDatabaseConnector().getAllDevices();
		if (dbDeviceList != null) {
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseDeviceList(dbDeviceList);
		}
		return rv;
	}

	@Override
	public void insertUser(User user) {
		_databaseFacade.getDatabaseConnector().insertUser(_databaseFacade.getDatabaseMapper().mapDomainUser(user));

	}

	// new methods

	@Override
	public void insert(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByName(String name) {
		User rv;
		rv = _databaseFacade.getDatabaseMapper()
				.mapDatabaseUser(_databaseFacade.getDatabaseConnector().getUserByName());
		return rv;
	}

	@Override
	public User getUserByDeviceId(String deviceId) {
		User rv;
		rv = _databaseFacade.getDatabaseMapper()
				.mapDatabaseUser(_databaseFacade.getDatabaseConnector().getUserByDeviceID(deviceId));
		return rv;
	}

	@Override
	public List getAll(Class classname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPOIsByPosition(Geometry position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getScheduleByPositionAndTime(Geometry position, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getTrackByDevice(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getTrackByUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
