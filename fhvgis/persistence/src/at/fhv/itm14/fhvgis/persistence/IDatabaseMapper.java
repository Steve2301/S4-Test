package at.fhv.itm14.fhvgis.persistence;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.*;

public interface IDatabaseMapper {

	public User mapDatabaseUser(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User dbUser);
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.User mapDomainUser(User domainUser);
	public List<User> mapDatabaseUserList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList);
}
