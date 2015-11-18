package at.fhv.itm14.fhvgis.persistence;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.POI;
import at.fhv.itm14.fhvgis.domain.Schedule;
import at.fhv.itm14.fhvgis.domain.Track;
import at.fhv.itm14.fhvgis.domain.User;

public interface IDatabaseController {
	// old stuff
	public List<User> getAllUsers();

	public List<Device> getAllDevices();

	public void insertUser(User user1);

	// new interface methods


	public List<POI> getPOIsByPosition(Geometry position);

	public List<Schedule> getScheduleByPositionAndTime(Geometry position, Date date);

	public List<Track> getTrackByDevice(String deviceId);

	public List<Track> getTrackByUser(String name);

}
