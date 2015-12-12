package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Log;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ILogDao;

public class LogDao extends GenericDao<Log> implements ILogDao{
	
private static LogDao _instance;
	
	public static LogDao getInstance() {
		if (_instance == null) {
			_instance = new LogDao();
		}
		_instance.setClazz(Log.class);
		return _instance;
	}	

	@Override
	public void deleteLogsOfDevice(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Log> getLogsOfDevice(Device dbDevice) {
		// TODO Auto-generated method stub
		return null;
	}

}
