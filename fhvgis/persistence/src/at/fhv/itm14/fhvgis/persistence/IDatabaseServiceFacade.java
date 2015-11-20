package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.persistence.dao.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.dao.IPoiDao;
import at.fhv.itm14.fhvgis.persistence.dao.ITrackDao;
import at.fhv.itm14.fhvgis.persistence.dao.IUserDao;

public interface IDatabaseServiceFacade {

	public IUserDao getUserDaoInstance();

	public IDeviceDao getDeviceDaoInstance();

	public IPoiDao getPoiDaoInstance();

	public ITrackDao getTrackDaoInstance();

}
