package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;

public interface IDatabaseController<T> {
	// old stuff
	public List<User> getAllUsers();

	public List<Device> getAllDevices();

	public void insertUser(User user1);

	// new interface methods
	public void insert(T value);

	public void update(T value);

	public void delete(T value);

	public User getUserByName(String name);

	public User getUserByDeviceId(String deviceId);

	public List<T> getAll(Class<T> classname);

	public List<POI> getPOIsByPosition(Geometry position);

	public List<Schedule> getScheduleByPositionAndTime(Geometry position, Date date);

	public List<Track> getTrackByDevice(String deviceId);

	public List<Track> getTrackByUser(String name);

}
