package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

public class DatabaseService implements IDatabaseService {

	private static DatabaseService _instance;

	private IDatabaseServiceFacade _serviceFacade;

	private DatabaseService() {
		_serviceFacade = DatabaseServiceFacade.getInstance();
	}

	public static DatabaseService getInstance() {
		if (_instance == null) {
			_instance = new DatabaseService();
		}
		return _instance;
	}

	@Override
	public List<User> getAllUsers() {
		return _serviceFacade.getUserDaoInstance().findAll(User.class);
		// List<User> rv = new LinkedList<User>();
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = null;
		// try {
		// transaction = session.beginTransaction();
		// List<User> rs = (List<User>) session.createQuery("from User").list();
		// rv = rs;
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// session.close();
		// }
		// return rv;
	}

	@Override
	public List<Device> getAllDevices() {
		return _serviceFacade.getDeviceDaoInstance().findAll(Device.class);
		// List<Device> rv = new LinkedList<>();
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = null;
		// try {
		// transaction = session.beginTransaction();
		// Query query = session.createQuery("from Device");
		// List<?> dbList = query.list();
		// if (dbList != null) {
		// for (Object o : dbList) {
		// Device tmp = (Device) o;
		// if (tmp != null) {
		// rv.add(tmp);
		// }
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// session.close();
		// }
		// return rv;
	}

	@Override
	public void insertUser(User user) {
		_serviceFacade.getUserDaoInstance().save(user);
	}

	// new methods

}
