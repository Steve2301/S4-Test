package at.fhv.itm14.fhvgis.persistence;

import java.util.LinkedList;
import java.util.List;

import at.fhv.itm14.fhvgis.domain.User;

public class DatabaseMapper implements IDatabaseMapper {

	private static DatabaseMapper _instance;
	
	private DatabaseMapper()
	{
		
	}
	
	public static DatabaseMapper getInstance()
	{
		if(_instance == null)
		{
			_instance = new DatabaseMapper();
		}
		return _instance;
	}

	@Override
	public User mapDatabaseUser(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User dbUser) {
		User rv = new User(dbUser.getUsername(), dbUser.getPassword());
		return rv;
	}

	@Override
	public at.fhv.itm14.fhvgis.persistence.hibernate.objects.User mapDomainUser(User domainUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> mapDatabaseUserList(List<at.fhv.itm14.fhvgis.persistence.hibernate.objects.User> dbUserList) {
		List<User> rv = new LinkedList<User>();
		for(at.fhv.itm14.fhvgis.persistence.hibernate.objects.User u : dbUserList)
		{
			User tmp = mapDatabaseUser(u);
			if(tmp != null)
			{
				rv.add(tmp);
			}
		}
		return rv;
	}
}
