package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.domain.Transportation;
import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationDao;

public class TransportationDao extends GenericDao<Transportation> implements ITransportationDao{
	
	private static TransportationDao _instance;
	
	public static TransportationDao getInstance() {
		if (_instance == null) {
			_instance = new TransportationDao();
		}
		return _instance;
	}

	@Override
	public Transportation findTransportationByWaypoint(Waypoint waypoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
