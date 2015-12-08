package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;

public interface IDeviceDao extends IGenericDao<Device> {
	
	public Device findDeviceByDeviceId(String deviceId);

	public List<Device> findAll();
	
}
