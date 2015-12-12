package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.POIType;
import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiDao;

public class POIDao extends GenericDao<POI> implements IPoiDao{
	
	private static POIDao _instance;
	
	public static POIDao getInstance() {
		if (_instance == null) {
			_instance = new POIDao();
		}
		_instance.setClazz(POI.class);
		return _instance;
	}	

	@Override
	public List<POI> findPoisByPosition(Geometry position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<POI> findPoisByType(POIType poiType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POI findPoiByWaypoint(Waypoint waypoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePoisOfPoiType(POIType poiType) {
		// TODO Auto-generated method stub
		
	}

}
