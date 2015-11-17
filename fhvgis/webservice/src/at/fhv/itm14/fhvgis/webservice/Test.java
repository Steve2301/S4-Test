package at.fhv.itm14.fhvgis.webservice;

import java.util.ArrayList;
import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public class Test {

	private static Test _instance;
	private List<User> _users;

	private Test() {
		_users = new ArrayList<>();
		_users.add(new User("testperson1", "test"));
		_users.add(new User("testperson2", "test"));
		_users.add(new User("testperson3", "test"));
		_users.add(new User("testperson4", "test"));
		_users.add(new User("testperson5", "test"));

	}

	public static Test getInstance() {
		if (_instance == null) {
			_instance = new Test();
		}
		return _instance;
	}

	public User getUser(String username) {
		if (_users != null) {
			for (User u : _users) {
				if(u.getName().equals(username))
				{
					return u;
				}
			}
		}
		return null;
	}
}
