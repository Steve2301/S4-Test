package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Device;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Log;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Shedule;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;
import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Waypoint;

public interface IDatabaseService {

	/* findAll* */
	public List<User> getAllUsers();

	public List<Device> getAllDevices();

	public List<Poi> getAllPois();

	public List<Track> getAllTracks();

	public List<Shedule> getAllSchedules();

	public List<Waypoint> getAllWaypoints();

	/* insert* */
	public void insertUser(User user);

	public void insertSchedule(Shedule schedule);

	public void insertDevice(Device device);

	public void insertTrack(Track track);

	public void insertPoi(Poi poi);

	public void insertWaypoint(Waypoint waypoint);

	/* update */
	public void updateUser(User user);

	/* Miscellaneous */
	public void writeToLog(Log log);

	public User getUserByName(String username);

	public void deleteUser(User user);

}
