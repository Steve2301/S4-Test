package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IWaypointDao;

public class WaypointDao extends GenericDao<Waypoint> implements IWaypointDao{
	
	private static WaypointDao _instance;
	
	public static WaypointDao getInstance() {
		if (_instance == null) {
			_instance = new WaypointDao();
		}
		_instance.setClazz(Waypoint.class);
		return _instance;
	}

}
