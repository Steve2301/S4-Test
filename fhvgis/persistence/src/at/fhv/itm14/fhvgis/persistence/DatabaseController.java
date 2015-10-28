package at.fhv.itm14.fhvgis.persistence;

import java.util.LinkedList;
import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;

public class DatabaseController implements IDatabaseController {

	private static DatabaseController _instance;
	private IDatabaseFacade _databaseFacade;
	
	private DatabaseController()
	{
		_databaseFacade = DatabaseFacade.getInstance();
	}
	
	public static DatabaseController getInstance()
	{
		if(_instance == null)
		{
			_instance = new DatabaseController();
		}
		return _instance;
	}
	
	
	
	@Override
	public List<User> getAllUsers() {
		List<User> rv = new LinkedList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList =  _databaseFacade.getDatabaseConnector().getAllUsers();
		if(dbUserList != null)
		{
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseUserList(dbUserList);
		}
		return rv;
	}

	@Override
	public List<Device> getAllDevices() {
		List<Device> rv = new LinkedList<>();
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList =  _databaseFacade.getDatabaseConnector().getAllDevices();
		if(dbDeviceList != null)
		{
			rv = _databaseFacade.getDatabaseMapper().mapDatabaseDeviceList(dbDeviceList);
		}
		return rv;
	}

}
