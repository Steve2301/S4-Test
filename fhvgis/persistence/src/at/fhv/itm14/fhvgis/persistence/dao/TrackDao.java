package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITrackDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;

public class TrackDao extends GenericDao<Track> implements ITrackDao {

	private static TrackDao _instance;

	private TrackDao() {
		// TODO Auto-generated constructor stub
	}

	public static TrackDao getIntance() {
		if (_instance == null) {
			_instance = new TrackDao();
		}
		return _instance;
	}

	@Override
	public List<Track> getTrackByDevice(String deviceId) {
		List<Track> rv = new ArrayList<>();
		// TODO Auto-generated method stub
		return rv;
	}

	@Override
	public List<Track> getTrackByUser(String name) {
		List<Track> rv = new ArrayList<>();
		// TODO Auto-generated method stub
		return rv;
	}

}
