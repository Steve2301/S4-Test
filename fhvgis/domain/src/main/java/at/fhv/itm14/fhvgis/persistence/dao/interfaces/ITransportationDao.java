package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import at.fhv.itm14.fhvgis.domain.*;

public interface ITransportationDao extends IGenericDao<Transportation> {
	
	Transportation findTransportationByWaypoint(Waypoint waypoint);

}
