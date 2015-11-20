package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.persistence.dao.DeviceDao;
import at.fhv.itm14.fhvgis.persistence.dao.GeofenceDao;
import at.fhv.itm14.fhvgis.persistence.dao.LogDao;
import at.fhv.itm14.fhvgis.persistence.dao.MotionValuesDao;
import at.fhv.itm14.fhvgis.persistence.dao.PoiDao;
import at.fhv.itm14.fhvgis.persistence.dao.PoiTypeDao;
import at.fhv.itm14.fhvgis.persistence.dao.ScheduleDao;
import at.fhv.itm14.fhvgis.persistence.dao.ScheduleDayDao;
import at.fhv.itm14.fhvgis.persistence.dao.SegmentDao;
import at.fhv.itm14.fhvgis.persistence.dao.TrackDao;
import at.fhv.itm14.fhvgis.persistence.dao.TransportationDao;
import at.fhv.itm14.fhvgis.persistence.dao.TransportationRouteDao;
import at.fhv.itm14.fhvgis.persistence.dao.UserDao;
import at.fhv.itm14.fhvgis.persistence.dao.WaypointDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IGeofenceDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ILogDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IMotionValuesDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IPoiTypeDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IScheduleDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IScheduleDayDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ISegmentDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITrackDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.ITransportationRouteDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IUserDao;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IWaypointDao;

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

	@Override
	public IGeofenceDao getGeofenceDaoInstance() {
		return GeofenceDao.getInstance();
	}

	@Override
	public ILogDao getLogDaoInstance() {
		return LogDao.getInstance();
	}

	@Override
	public IMotionValuesDao getMotionValuesDaoInstance() {
		return MotionValuesDao.getInstance();
	}

	@Override
	public IPoiTypeDao getPoiTypeDaoInstance() {
		return PoiTypeDao.getInstance();
	}

	@Override
	public IScheduleDao getScheduleDaoInstance() {
		return ScheduleDao.getInstance();
	}

	@Override
	public IScheduleDayDao getScheduleDayDaoInstance() {
		return ScheduleDayDao.getInstance();
	}

	@Override
	public ISegmentDao getSegmentDaoInstance() {
		return SegmentDao.getInstance();
	}

	@Override
	public ITransportationDao getTransportationDaoInstance() {
		return TransportationDao.getInstance();
	}

	@Override
	public ITransportationRouteDao getTransportationRouteDaoInstance() {
		return TransportationRouteDao.getInstance();
	}

	@Override
	public IWaypointDao getWaypointDaoInstance() {
		return WaypointDao.getInstance();
	}

}
