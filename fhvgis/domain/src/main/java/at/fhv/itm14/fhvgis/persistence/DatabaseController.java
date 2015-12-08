package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;

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


}
