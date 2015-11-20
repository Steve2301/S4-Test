package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IMotionValuesDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.MotionValues;

public class MotionValuesDao extends GenericDao<MotionValues> implements IMotionValuesDao {

	private static MotionValuesDao _instance;

	private MotionValuesDao() {

	}

	public static MotionValuesDao getInstance() {
		if (_instance == null) {
			_instance = new MotionValuesDao();
		}
		return _instance;
	}

}
