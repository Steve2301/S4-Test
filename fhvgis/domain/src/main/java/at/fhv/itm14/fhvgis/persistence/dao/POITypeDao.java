package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.domain.POIType;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiTypeDao;

public class POITypeDao extends GenericDao<POIType> implements IPoiTypeDao{
	
	private static POITypeDao _instance;
	
	public static POITypeDao getInstance() {
		if (_instance == null) {
			_instance = new POITypeDao();
		}
		_instance.setClazz(POIType.class);
		return _instance;
	}	

}
