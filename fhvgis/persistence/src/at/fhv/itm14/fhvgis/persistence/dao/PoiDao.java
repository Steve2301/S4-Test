package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiDao;
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

	@Override
	public List<Poi> findPoisByPosition(Geometry position) {
		// TODO Auto-generated method stub
		return null;
	}
}
