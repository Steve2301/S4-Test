package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IScheduleDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;

public class ScheduleDao extends GenericDao<Shedule> implements IScheduleDao {
	private static ScheduleDao _instance;

	private ScheduleDao() {

	}

	public static ScheduleDao getInstance() {
		if (_instance == null) {
			_instance = new ScheduleDao();
		}
		return _instance;
	}

	@Override
	public List<Shedule> findScheduleByPositionAndTime(Geometry position, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
