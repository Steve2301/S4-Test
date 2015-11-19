package at.fhv.itm14.fhvgis.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

public class UserDao extends GenericDao<User> implements IUserDao {

	private static UserDao _instance;

	private UserDao() {

	}

	public static UserDao getInstance() {
		if (_instance == null) {
			_instance = new UserDao();
		}
		return _instance;
	}

	@Override
	public User findUserByName(String name) {
		User user = null;
		String sql = "SELECT u from user u WHERE p.name := name";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).setParameter("name", name);
			user = findOne(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User findUserByDevice(String deviceId) {
		User user = null;
		String sql = "I suck at SQL";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(sql).setParameter("device_id", deviceId);
			user = findOne(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

}
