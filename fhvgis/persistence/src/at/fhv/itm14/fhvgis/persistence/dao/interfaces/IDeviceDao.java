package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

public interface IDeviceDao extends IGenericDao<Device> {
	public void deleteDeviceByUser(User user);
}
