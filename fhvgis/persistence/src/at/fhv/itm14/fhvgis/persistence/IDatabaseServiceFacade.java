package at.fhv.itm14.fhvgis.persistence;

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

public interface IDatabaseServiceFacade {

	public IDeviceDao getDeviceDaoInstance();

	public IGeofenceDao getGeofenceDaoInstance();

	public ILogDao getLogDaoInstance();

	public IMotionValuesDao getMotionValuesDaoInstance();

	public IPoiDao getPoiDaoInstance();

	public IPoiTypeDao getPoiTypeDaoInstance();

	public IScheduleDao getScheduleDaoInstance();

	public IScheduleDayDao getScheduleDayDaoInstance();

	public ISegmentDao getSegmentDaoInstance();

	public ITrackDao getTrackDaoInstance();

	public ITransportationDao getTransportationDaoInstance();

	public ITransportationRouteDao getTransportationRouteDaoInstance();

	public IUserDao getUserDaoInstance();

	public IWaypointDao getWaypointDaoInstance();

}
