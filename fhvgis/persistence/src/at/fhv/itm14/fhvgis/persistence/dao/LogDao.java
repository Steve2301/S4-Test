package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ILogDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log;

public class LogDao extends GenericDao<Log> implements ILogDao {

	private static LogDao _instance;

	private LogDao() {

	}

	public static LogDao getInstance() {
		if (_instance == null) {
			_instance = new LogDao();
		}
		return _instance;
	}
}
