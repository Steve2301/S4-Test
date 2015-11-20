package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;

public class DeviceDao extends GenericDao<Device> implements IDeviceDao {

	private static DeviceDao _instance;

	private DeviceDao() {

	}

	public static DeviceDao getInstance() {
		if (_instance == null) {
			_instance = new DeviceDao();
		}
		return _instance;
	}

}
