package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public interface IDatabaseController {
	public List<User> getAllUsers();
	public List<Device> getAllDevices();
}
