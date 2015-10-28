package at.fhv.itm14.fhvgis.persistence;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

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
		List<User> rv = new LinkedList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<User> rs = (List<User>) session.createQuery("from User").list();
			rv = rs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rv;
	}
	
	@Override
	public List<Device> getAllDevices()
	{
		List<Device> rv = new LinkedList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Device");
			List<?> dbList = query.list();
			if(dbList != null)
			{
				for(Object o : dbList)
				{
					Device tmp = (Device) o;
					if(tmp != null)
					{
						rv.add(tmp);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return rv;
	}
}
