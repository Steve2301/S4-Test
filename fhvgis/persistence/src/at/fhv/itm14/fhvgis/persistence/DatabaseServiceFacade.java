package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.persistence.dao.DeviceDao;
import at.fhv.itm14.fhvgis.persistence.dao.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.dao.IPoiDao;
import at.fhv.itm14.fhvgis.persistence.dao.ITrackDao;
import at.fhv.itm14.fhvgis.persistence.dao.IUserDao;
import at.fhv.itm14.fhvgis.persistence.dao.PoiDao;
import at.fhv.itm14.fhvgis.persistence.dao.TrackDao;
import at.fhv.itm14.fhvgis.persistence.dao.UserDao;

public class DatabaseServiceFacade implements IDatabaseServiceFacade {

	private static DatabaseServiceFacade _instance;

	private DatabaseServiceFacade() {

	}

	public static DatabaseServiceFacade getInstance() {
		if (_instance == null) {
			_instance = new DatabaseServiceFacade();
		}
		return _instance;
	}

	@Override
	public IUserDao getUserDaoInstance() {
		return UserDao.getInstance();
	}

	@Override
	public IDeviceDao getDeviceDaoInstance() {
		return DeviceDao.getInstance();
	}

	@Override
	public IPoiDao getPoiDaoInstance() {
		return PoiDao.getIntance();
	}

	@Override
	public ITrackDao getTrackDaoInstance() {
		return TrackDao.getIntance();
	}

}
