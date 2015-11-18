package at.fhv.itm14.fhvgis.persistence.dao;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.*;;

public interface UserDao extends GenericDao<User>{
	
	public User findUserByName(String name);

	public User findUserByDevice(String deviceId);

}
