package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationRouteDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.TransportationRoute;

public class TransportationRouteDao extends GenericDao<TransportationRoute> implements ITransportationRouteDao {
	private static TransportationRouteDao _instance;

	private TransportationRouteDao() {

	}

	public static TransportationRouteDao getInstance() {
		if (_instance == null) {
			_instance = new TransportationRouteDao();
		}
		return _instance;
	}

}
