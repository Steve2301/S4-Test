package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Track;

public interface ITrackDao {
	List<Track> getTrackByDevice(String deviceId);

	List<Track> getTrackByUser(String name);

}
