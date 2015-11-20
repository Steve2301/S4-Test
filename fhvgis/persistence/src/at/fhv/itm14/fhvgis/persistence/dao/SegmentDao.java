package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ISegmentDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Segment;

public class SegmentDao extends GenericDao<Segment> implements ISegmentDao {
	private static SegmentDao _instance;

	private SegmentDao() {

	}

	public static SegmentDao getInstance() {
		if (_instance == null) {
			_instance = new SegmentDao();
		}
		return _instance;
	}

}
