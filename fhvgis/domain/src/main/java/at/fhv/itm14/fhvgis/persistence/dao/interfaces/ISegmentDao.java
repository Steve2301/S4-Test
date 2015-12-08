package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;


public interface ISegmentDao extends IGenericDao<Segment> {

	void deleteSegmentsFromOfWaypoint(Waypoint waypoint);

	void deleteSegmentsToOfWaypoint(Waypoint waypoint);

	void deleteSegmentsOfTransportationRoute(TransportationRoute transportationRoute);

	void deleteSegmentFromOfPoi(POI poi);

	void deleteSegmentToOfPoi(POI poi);

	void deleteSegmentsOfTransportation(Transportation transportation);
	
	List<Segment> findSegmentsOfTransportationRoute(TransportationRoute route);
	
	List<Segment> findSegmentsOfWaypointTo(Waypoint waypoint);
	
	List<Segment> findSegmentsOfWaypointFrom(Waypoint waypoint);

}
