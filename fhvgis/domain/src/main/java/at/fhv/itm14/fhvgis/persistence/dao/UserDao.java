package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IUserDao;

public class UserDao extends GenericDao<User> implements IUserDao{
	
	private static UserDao _instance;
	
	public static UserDao getInstance() {
		if (_instance == null) {
			_instance = new UserDao();
		}
		_instance.setClazz(User.class);
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
			for(Device d : user.getDevices()){
				Hibernate.initialize(d.getLogs().size());
				Hibernate.initialize(d.getTracks().size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> rs = null;
		try {
			session.beginTransaction();
			rs = (List<User>) session.createQuery("from " + User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen())
			session.close();
		}
		return rs;
	}


}
