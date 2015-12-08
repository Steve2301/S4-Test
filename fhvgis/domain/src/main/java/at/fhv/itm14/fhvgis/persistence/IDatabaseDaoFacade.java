package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.*;

public interface IDatabaseDaoFacade {
	
	public IDeviceDao getDeviceDaoInstance();
	
	public IGeofenceDao getGeofenceDaoInstance();

	public ILogDao getLogDaoInstance();

	public IMotionValuesDao getMotionValuesDaoInstance();

	public IPoiDao getPoiDaoInstance();

	public IPoiTypeDao getPoiTypeDaoInstance();

	public IScheduleDao getScheduleDaoInstance();

	public ISegmentDao getSegmentDaoInstance();

	public ITrackDao getTrackDaoInstance();

	public ITransportationDao getTransportationDaoInstance();

	public ITransportationRouteDao getTransportationRouteDaoInstance();

	public IUserDao getUserDaoInstance();

	public IWaypointDao getWaypointDaoInstance();

}
