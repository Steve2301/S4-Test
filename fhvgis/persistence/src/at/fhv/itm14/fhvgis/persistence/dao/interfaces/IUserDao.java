package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.User;;

public interface IUserDao extends IGenericDao<User> {

	public User findUserByName(String name);

	public User findUserByDevice(String deviceId);

}
