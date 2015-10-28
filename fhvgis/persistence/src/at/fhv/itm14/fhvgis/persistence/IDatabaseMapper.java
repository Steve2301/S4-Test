package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public interface IDatabaseMapper {

	public User mapDatabaseUser(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User dbUser);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.User mapDomainUser(User domainUser);
	public List<User> mapDatabaseUserList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList);
	public List<Device> mapDatabaseDeviceList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList);
	public Device mapDatabaseDevice(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device dbDevice);
}
