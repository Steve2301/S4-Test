package at.fhv.itm14.fhvgis.persistence.test;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.domain.Waypoint;
import at.fhv.itm14.fhvgis.persistence.DatabaseFacade;
import at.fhv.itm14.fhvgis.persistence.IDatabaseController;
import at.fhv.itm14.fhvgis.persistence.IDatabaseFacade;
import at.fhv.itm14.fhvgis.persistence.dao.interfaces.HibernateUtil;



public class Testclass {

	private static Testclass _test;
	private IDatabaseFacade _dbFacade;
	public IDatabaseController _dbController;
	
	public Testclass(){
		_dbFacade = DatabaseFacade.getInstance();
		_dbController = _dbFacade.getDatabaseController();
	}

	public static void main(String[] args) {
		
		_test = new Testclass();
		 _test.TestDatabaseDeleteAll();
		 _test.TestDatabaseInsertAll();
		 _test.TestDatabaseFindUserAndDevice();
		System.out.println("Success");

	}

	private void TestDatabaseFindUserAndDevice() {
		User u = _dbController.findUserByUsername("Lucas");
		Device d = _dbController.findDeviceByDeviceId("kaka");
		
		Track t = new Track(d, Instant.now(), Instant.now().plusSeconds(80000));
		
		
		GeometryFactory factory = new GeometryFactory();
		Point point1 = factory.createPoint(new Coordinate(10, 50));
		Point point2 = factory.createPoint(new Coordinate(11, 51));

		Waypoint w1 = new Waypoint(point1, Instant.now(), 5, 6, true, 7, 8, 9, 10);
		Waypoint w2 = new Waypoint(point2, Instant.now(), 5, 6, true, 7, 8, 9, 10);

		t.addWaypoint(w1);
		t.addWaypoint(w2);
		d.addTrack(t);

		_dbController.updateDevice(d);
		
		_dbController.deleteDevice(d);
		
		//_dbController.findWaypointsOfTrack("kaka");
		
	}

	private void TestDatabaseDeleteAll() {
		List<User> users = _test._dbController.findAllUsers();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction t = session.beginTransaction();
			session.delete(users.get(0));
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		
	}

	private void TestDatabaseInsertAll() {
		User u = new User("Lucas", "luketheduke");
		Device d = new Device("lucasdev", "kaka");
		d.setUser(u);
		_dbController.persistUser(u);
		_dbController.persistDevice(d);
		
	}



}
