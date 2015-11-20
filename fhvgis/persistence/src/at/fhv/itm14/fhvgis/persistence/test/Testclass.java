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
	private static Testclass _test;

	public static void main(String[] args) {
		_test = new Testclass();
		List<User> temp = _test.loadUsers();
		_test.removeAllUser(temp);
		_test.insertUsers();
		_test.insertDevice("Lucas");
		_test.removeUserByName("Lucas");
		System.out.println("Success");

	}

	private void removeUserByName(String username) {
		User user = _test._dbController.getUserByName(username);
		removeUser(user);
	}

	public Testclass() {
		_dbFacade = DatabaseFacade.getInstance();
		_dbController = _dbFacade.getDatabaseController();
	}

	public void loadDevices() {
		List<Device> users = _test._dbController.getAllDevices();
		if (users != null) {
			for (Device u : users) {
				System.out.println(u.getId().toString());
				System.out.println(u.getToken());
			}
		}
	}

	public List<User> loadUsers() {
		List<User> users = _test._dbController.getAllUsers();
		return users;
	}

	public void insertDevice(String username) {
		User user = _test._dbController.getUserByName(username);
		Device d = new Device("abcdefg");
		user.addDevice(d);
		_test._dbController.updateUser(user);
	}

	public void removeAllUser(List<User> users) {
		if (users != null) {
			for (User u : users) {
				removeUser(u);
			}
		}
	}

	public void removeUser(User user) {
		_test._dbController.deleteUser(user);
	}

	public void insertUsers() {
		User user1 = new User("Stefan", "stefan");
		User user2 = new User("Lucas", "lucas");
		_test._dbController.insertUser(user1);
		_test._dbController.insertUser(user2);
	}

}
