package at.fhv.itm14.fhvgis.persistence;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;

public interface IDatabaseController {

	
	User findUserByUsername(String username);
	Device findDeviceByDeviceId(String deviceId);
	

}
