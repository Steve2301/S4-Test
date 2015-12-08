package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.Log;


public interface ILogDao extends IGenericDao<Log> {

	void deleteLogsOfDevice(Device device);

	List<Log> getLogsOfDevice(Device dbDevice);
	
	

}
