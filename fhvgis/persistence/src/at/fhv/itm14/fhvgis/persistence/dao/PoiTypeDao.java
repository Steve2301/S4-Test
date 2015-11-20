package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiTypeDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.PoiType;

public class PoiTypeDao extends GenericDao<PoiType> implements IPoiTypeDao {

	private static PoiTypeDao _instance;

	private PoiTypeDao() {

	}

	public static PoiTypeDao getInstance() {
		if (_instance == null) {
			_instance = new PoiTypeDao();
		}
		return _instance;
	}

}
