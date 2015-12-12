package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;

public class HibernateUtil {

	private static final SessionFactory _sessionFactory;

	static {
		try {
			_sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory createion failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return _sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
		if (entity == null) {
			return null;
		}

		if (entity instanceof HibernateProxy) {
			Hibernate.initialize(entity);
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
		}
		return entity;
	}
}
