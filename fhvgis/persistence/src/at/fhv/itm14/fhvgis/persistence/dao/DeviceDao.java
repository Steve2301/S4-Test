package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IDeviceDao;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

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

	@Override
	public void deleteDeviceByUser(User user) {
		List<Device> devices;
		String sql = "FROM Device as d WHERE d.user = :user";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(sql).setParameter("user", user);
			devices = findMany(query);
			session.close();
			if (devices != null) {
				for (Device d : devices) {
					delete(d);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

}
