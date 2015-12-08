package at.fhv.itm14.fhvgis.persistence.dao;


import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITrackDao;

public class TrackDao extends GenericDao<Track> implements ITrackDao{
	
	private static TrackDao _instance;
	
	public static TrackDao getInstance() {
		if (_instance == null) {
			_instance = new TrackDao();
		}
		return _instance;
	}


}
