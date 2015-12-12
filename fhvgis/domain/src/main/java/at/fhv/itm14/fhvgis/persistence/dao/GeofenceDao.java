package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.domain.Geofence;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IGeofenceDao;

public class GeofenceDao extends GenericDao<Geofence> implements IGeofenceDao{

	private static GeofenceDao _instance;
	
	public static GeofenceDao getInstance() {
		if (_instance == null) {
			_instance = new GeofenceDao();
		}
		_instance.setClazz(Geofence.class);
		return _instance;
	}	
}
