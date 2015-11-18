package at.fhv.itm14.fhvgis.persistence.dao;

import org.hibernate.Query;

import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

	@Override
	public User findUserByName(String name) {
		User user = null;
		String sql = "SELECT u from user u WHERE p.name := name";
		Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery(sql).setParameter("name", name);
		user = findOne(query);
		return user;
	}

	@Override
	public User findUserByDeviceId(String deviceId) {
		User user = null;
		String sql = "I suck at SQL";
		Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery(sql).setParameter("device_id", deviceId);
		user = findOne(query);
		return user;
	}
	
	
	
	
	

}
