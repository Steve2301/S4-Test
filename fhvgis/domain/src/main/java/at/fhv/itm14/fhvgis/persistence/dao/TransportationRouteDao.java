package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Transportation;
import at.fhv.itm14.fhvgis.domain.TransportationRoute;
import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationRouteDao;

public class TransportationRouteDao extends GenericDao<TransportationRoute> implements ITransportationRouteDao{
	
	private static TransportationRouteDao _instance;
	
	public static TransportationRouteDao getInstance() {
		if (_instance == null) {
			_instance = new TransportationRouteDao();
		}
		return _instance;
	}

	@Override
	public void deleteTransporationRoutesOfTransportation(Transportation transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TransportationRoute> findTransportationRoutesOfTransportation(Transportation transportation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransportationRoute findTransportationRouteOfWaypoint(Waypoint waypoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
