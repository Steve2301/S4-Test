package at.fhv.itm14.fhvgis.persistence.test;

import java.util.LinkedList;
import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.HibernateUtil;



public class Testclass {

	private static Testclass _test;

	public static void main(String[] args) {
		
		_test = new Testclass();
		 _test.TestDatabaseDeleteAll();
		 _test.TestDatabaseInsertAll();
		// _test.LoadCompleteUser("Test");
		System.out.println("Success");

	}


	private void TestDatabaseDeleteAll() {
		List<User> users = _test.findAllUsers();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction t = session.beginTransaction();
			session.delete(users.get(0));
			session.delete(users.get(1));
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		
	}
	
	private List<User> findAllUsers(){
		List<User> rv = new LinkedList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<User> rs = session.createQuery("from User").list();
			if (rs != null) {
				for (User t : rs) {
					Hibernate.initialize(t.getDevices());
					for(Device d : t.getDevices()){
						Hibernate.initialize(d.getLogs());
						Hibernate.initialize(d.getTracks());
						for(Track track : d.getTracks()){
							Hibernate.initialize(track.getSegments());
							Hibernate.initialize(track.getWaypoints());
							Hibernate.initialize(track.getRawWaypoints());
						}
						Hibernate.initialize(d.getRawMotionValues());
					}
				}
			}
			rv = rs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return rv;
	}


	private void TestDatabaseInsertAll() {
		User u = new User("Teffgfst", "tfffest");
		Device d = new Device("token", "kakakaka");
		u.addDevice(d);
		List<User> rv = new LinkedList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction t = session.beginTransaction();
			session.persist(u);
			session.persist(u.getDevices().get(0));
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		System.out.println(rv.size() + " " + rv.get(0).getDevices().size());
		

	}



}
