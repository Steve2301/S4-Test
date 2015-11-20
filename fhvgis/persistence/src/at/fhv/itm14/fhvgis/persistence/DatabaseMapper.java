package at.fhv.itm14.fhvgis.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;

public class DatabaseMapper implements IDatabaseMapper {

	private static DatabaseMapper _instance;

	private DatabaseMapper() {

	}

	public static DatabaseMapper getInstance() {
		if (_instance == null) {
			_instance = new DatabaseMapper();
		}
		return _instance;
	}

	@Override
	public User mapDatabaseUser(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User dbUser) {
		User rv = null;
		if (dbUser != null) {
			rv = new User(dbUser.getId(), dbUser.getUsername(), dbUser.getPassword());
		}
		return rv;
	}

	@Override
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.User mapDomainUser(User domainUser) {

		Set<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> devices = new HashSet<>(
				mapDomainDeviceList(domainUser.getDevices()));
		at.fhv.itm14.fhvgis.persistence.hibernate.objects.User rv = new at.fhv.itm14.fhvgis.persistence.hibernate.objects.User(
				domainUser.getId(), domainUser.getName(), domainUser.getPassword(), null);
		for (at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device d : devices) {
			d.setUser(rv);
		}
		rv.setDevices(devices);
		return rv;
	}

	@Override
	public List<User> mapDatabaseUserList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList) {
		List<User> rv = new ArrayList<User>();
		for (at.fhv.itm14.fhvgis.persistence.hibernate.objects.User u : dbUserList) {
			User tmp = mapDatabaseUser(u);
			if (tmp != null) {
				rv.add(tmp);
			}
		}
		return rv;
	}

	@Override
	public List<Device> mapDatabaseDeviceList(
			List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> dbDeviceList) {
		List<Device> rv = new ArrayList<Device>();
		if (dbDeviceList != null) {
			for (at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device u : dbDeviceList) {
				Device tmp = mapDatabaseDevice(u);
				if (tmp != null) {
					rv.add(tmp);
				}
			}
		}
		return rv;
	}

	public List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> mapDomainDeviceList(List<Device> devices) {
		List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device> rv = new ArrayList<>();
		if (devices != null) {
			for (Device u : devices) {
				at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device tmp = mapDomainDevice(u);
				if (tmp != null) {
					rv.add(tmp);
				}
			}
		}
		return rv;

	}

	private at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device mapDomainDevice(Device u) {
		at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device rv = new at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device(
				u.getId(), null, u.getToken());
		return rv;
	}

	@Override
	public Device mapDatabaseDevice(at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device dbDevice) {
		Device rv = new Device(dbDevice.getId(), dbDevice.getToken(), null, null);
		return rv;
	}
}
