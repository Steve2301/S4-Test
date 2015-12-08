package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.POIType;
import at.fhv.itm14.fhvgis.domain.Waypoint;


public interface IPoiDao extends IGenericDao<POI> {

	List<POI> findPoisByPosition(Geometry position);
	
	List<POI> findPoisByType(POIType poiType);
	
	POI findPoiByWaypoint(Waypoint waypoint);

	void deletePoisOfPoiType(POIType poiType);

}
