package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.TransportationRoute;


public interface IScheduleDao extends IGenericDao<Schedule> {

	List<Schedule> findScheduleByPositionAndTime(Geometry position, Date date);
	
	List<Schedule> findSchedulesOfTransportationRoute(TransportationRoute route);

	void deleteSchedulesOfTransportationRoute(TransportationRoute transportationRoute);

	void deleteSchedulesOfPoi(POI poi);

	//void deleteSchedulesOfScheduleDay(ScheduleDay scheduleDay);

}
