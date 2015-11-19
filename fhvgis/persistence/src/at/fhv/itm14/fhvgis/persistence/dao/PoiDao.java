package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;

public class PoiDao extends GenericDao<Poi> implements IPoiDao {

	private static PoiDao _instance;

	private PoiDao() {

	}

	public static PoiDao getIntance() {
		if (_instance == null) {
			_instance = new PoiDao();
		}
		return _instance;
	}
}
