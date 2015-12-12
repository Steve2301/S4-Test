package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.persistence.dao.*;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.*;


public class DatabaseDaoFacade implements IDatabaseDaoFacade{
	
		private static DatabaseDaoFacade _instance;

		private DatabaseDaoFacade() {

		}

		public static DatabaseDaoFacade getInstance() {
			if (_instance == null) {
				_instance = new DatabaseDaoFacade();
			}
			return _instance;
		}

		@Override
		public IDeviceDao getDeviceDaoInstance() {
			return DeviceDao.getInstance();
		}
		
		@Override
		public IUserDao getUserDaoInstance() {
			return UserDao.getInstance();
		}

		@Override
		public IWaypointDao getWaypointDaoInstance() {
			return WaypointDao.getInstance();
		}
		
		@Override
		public ITrackDao getTrackDaoInstance() {
			return TrackDao.getInstance();
		}

		@Override
		public IGeofenceDao getGeofenceDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public ILogDao getLogDaoInstance() {
			return LogDao.getInstance();
		}

		@Override
		public IMotionValuesDao getMotionValuesDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public IPoiDao getPoiDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public IPoiTypeDao getPoiTypeDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public IScheduleDao getScheduleDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public ISegmentDao getSegmentDaoInstance() {
			throw new UnsupportedOperationException("not yet implemented");
		}

		@Override
		public ITransportationDao getTransportationDaoInstance() {
			return TransportationDao.getInstance();
		}

		@Override
		public ITransportationRouteDao getTransportationRouteDaoInstance() {
			return TransportationRouteDao.getInstance();
		}


}
