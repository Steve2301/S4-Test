package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;

public interface IScheduleDao extends IGenericDao<Shedule> {

	List<Shedule> findScheduleByPositionAndTime(Geometry position, Date date);

}
