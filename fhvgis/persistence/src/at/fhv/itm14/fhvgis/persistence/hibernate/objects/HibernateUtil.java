package at.fhv.itm14.fhvgis.persistence.hibernate.objects;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static final SessionFactory _sessionFactory;
	
	static{
		try {
			_sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex)
		{
			System.err.println("Initial SessionFactory createion failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return _sessionFactory;
	}
}
