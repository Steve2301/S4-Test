package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public interface ITransportationRouteDao extends IGenericDao<TransportationRoute> {

	void deleteTransporationRoutesOfTransportation(Transportation transportation);
	
	List<TransportationRoute> findTransportationRoutesOfTransportation(Transportation transportation);
	
	TransportationRoute findTransportationRouteOfWaypoint(Waypoint waypoint);

}
