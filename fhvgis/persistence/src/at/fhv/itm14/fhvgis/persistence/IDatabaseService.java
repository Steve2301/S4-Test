package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;

public interface IDatabaseService {
	public List<User> getAllUsers();

	public List<Device> getAllDevices();

	public List<Poi> getAllPois();

	public List<Track> getAllTracks();

	public void insertUser(User user);

}
