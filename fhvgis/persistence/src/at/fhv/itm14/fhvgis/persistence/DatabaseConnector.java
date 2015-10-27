package at.fhv.itm14.fhvgis.persistence;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import at.fhv.itm14.fhvgis.persistence.hibernate.*;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.*;

public class DatabaseConnector implements IDatabaseConnector {

	private static DatabaseConnector _instance;

	private DatabaseConnector() {

	}

	public static DatabaseConnector getInstance() {
		if (_instance == null) {
			_instance = new DatabaseConnector();
		}
		return _instance;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> rv = new LinkedList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			rv = session.createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rv;
	}
}
