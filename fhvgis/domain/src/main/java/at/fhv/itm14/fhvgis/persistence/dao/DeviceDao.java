package at.fhv.itm14.fhvgis.persistence.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IDeviceDao;

public class DeviceDao extends GenericDao<Device> implements IDeviceDao{
	
	private static DeviceDao _instance;
	
	public static DeviceDao getInstance() {
		if (_instance == null) {
			_instance = new DeviceDao();
		}
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
			Hibernate.initialize(device.getLogs().size());
			Hibernate.initialize(device.getTracks().size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return device;
	}

	
	

}
