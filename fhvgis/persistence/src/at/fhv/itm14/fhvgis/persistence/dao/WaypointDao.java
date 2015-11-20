package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IWaypointDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint;

public class WaypointDao extends GenericDao<Waypoint> implements IWaypointDao {
	private static WaypointDao _instance;

	private WaypointDao() {

	}

	public static WaypointDao getInstance() {
		if (_instance == null) {
			_instance = new WaypointDao();
		}
		return _instance;
	}

}
