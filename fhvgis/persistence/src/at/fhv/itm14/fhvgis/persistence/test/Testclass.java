package at.fhv.itm14.fhvgis.persistence.test;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.DatabaseFacade;
import at.fhv.itm14.fhvgis.persistence.IDatabaseController;
import at.fhv.itm14.fhvgis.persistence.IDatabaseFacade;

public class Testclass {

	private IDatabaseFacade _dbFacade;
	public IDatabaseController _dbController;

	public static void main(String[] args) {
		Testclass test = new Testclass();
		test.loadUsers(test);
		// test.insertUsers(test);
		// test.loadUsers(test);
		System.out.println("Success");

	}

	public Testclass() {
		_dbFacade = DatabaseFacade.getInstance();
		_dbController = _dbFacade.getDatabaseController();
	}

	public void loadDevices(Testclass test) {
		List<Device> users = test._dbController.getAllDevices();
		if (users != null) {
			for (Device u : users) {
				System.out.println(u.getId().toString());
				System.out.println(u.getToken());
			}
		}
	}

	public void loadUsers(Testclass test) {
		List<User> users = test._dbController.getAllUsers();
		if (users != null) {
			for (User u : users) {
				System.out.println(u.getId().toString());
				System.out.println(u.getName());
			}
		}
	}

	public void insertUsers(Testclass test) {
		User user1 = new User("Stefan", "stefan");
		User user2 = new User("Lucas", "lucas");
		test._dbController.insertUser(user1);
		test._dbController.insertUser(user2);
	}

}
