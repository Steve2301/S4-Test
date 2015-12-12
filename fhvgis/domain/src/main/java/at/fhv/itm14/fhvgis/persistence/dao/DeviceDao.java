package at.fhv.itm14.fhvgis.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.utils.HibernateUtil;

public class DeviceDao extends GenericDao<Device> implements IDeviceDao{
	
	private static DeviceDao _instance;
	
	public static DeviceDao getInstance() {
		if (_instance == null) {
			_instance = new DeviceDao();
		}
		_instance.setClazz(Device.class);
		return _instance;
	}	

	@Override
	public Device findDeviceByDeviceId(String deviceId) {
		Device device = null;
		String sql = "FROM Device as d WHERE d.deviceId = :deviceId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(sql).setParameter("deviceId", deviceId);
			device = findOne(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return device;
	}

	
	

}
