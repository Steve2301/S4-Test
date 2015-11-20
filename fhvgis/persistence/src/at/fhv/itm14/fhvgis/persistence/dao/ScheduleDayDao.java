package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IScheduleDayDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.SheduleDay;

public class ScheduleDayDao extends GenericDao<SheduleDay> implements IScheduleDayDao {
	private static ScheduleDayDao _instance;

	private ScheduleDayDao() {

	}

	public static ScheduleDayDao getInstance() {
		if (_instance == null) {
			_instance = new ScheduleDayDao();
		}
		return _instance;
	}

}
