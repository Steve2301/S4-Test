package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Transportation;

public class TransportationDao extends GenericDao<Transportation> implements ITransportationDao {
	private static TransportationDao _instance;

	private TransportationDao() {

	}

	public static TransportationDao getInstance() {
		if (_instance == null) {
			_instance = new TransportationDao();
		}
		return _instance;
	}

}
