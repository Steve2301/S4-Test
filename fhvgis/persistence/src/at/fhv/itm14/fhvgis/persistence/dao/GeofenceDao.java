package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IGeofenceDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Geofence;

public class GeofenceDao extends GenericDao<Geofence> implements IGeofenceDao {

	private static GeofenceDao _instance;

	private GeofenceDao() {

	}

	public static GeofenceDao getInstance() {
		if (_instance == null) {
			_instance = new GeofenceDao();
		}
		return _instance;
	}

}
