package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

public interface IDatabaseConnector {
	public List<User> getAllUsers();

	public List<Device> getAllDevices();

	public void insertUser(User user);

}
