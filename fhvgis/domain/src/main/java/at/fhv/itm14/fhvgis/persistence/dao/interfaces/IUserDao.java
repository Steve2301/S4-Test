package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import at.fhv.itm14.fhvgis.domain.User;

public interface IUserDao extends IGenericDao<User> {

	public User findUserByName(String name);
}
