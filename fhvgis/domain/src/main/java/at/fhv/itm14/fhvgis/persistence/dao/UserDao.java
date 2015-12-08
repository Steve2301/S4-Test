package at.fhv.itm14.fhvgis.persistence.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IUserDao;

public class UserDao extends GenericDao<User> implements IUserDao{
	
	private static UserDao _instance;
	
	public static UserDao getInstance() {
		if (_instance == null) {
			_instance = new UserDao();
		}
		return _instance;
	}

	@Override
	public User findUserByName(String name) {
		User user = null;
		String sql = "FROM User as u WHERE u.username = :name";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(sql).setParameter("name", name);
			user = findOne(query);
			Hibernate.initialize(user.getDevices().size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}


}
