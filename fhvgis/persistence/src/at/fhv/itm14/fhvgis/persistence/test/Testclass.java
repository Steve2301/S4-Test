package at.fhv.itm14.fhvgis.persistence.test;

import java.util.List;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.persistence.DatabaseFacade;
import at.fhv.itm14.fhvgis.persistence.IDatabaseController;
import at.fhv.itm14.fhvgis.persistence.IDatabaseFacade;

public class Testclass {

	private IDatabaseFacade _dbFacade;
	public IDatabaseController _dbController;
	
	
	
	public static void main(String[]args)
	{
		Testclass test = new Testclass();
		test.loadUsers(test);
		System.out.println("Success");
		
	}
	
	public Testclass()
	{
		_dbFacade = DatabaseFacade.getInstance();
		_dbController = _dbFacade.getDatabaseController();
	}
	
	
	public void loadDevices(Testclass test)
	{
		List<Device> users = test._dbController.getAllDevices();
		if(users != null)
		{
			for(Device u : users)
			{
				System.out.println(u.getId().toString());
				System.out.println(u.getToken());
			}
		}
	}
	
	public void loadUsers(Testclass test)
	{
		List<User> users = test._dbController.getAllUsers();
		if(users != null)
		{
			for(User u : users)
			{
				System.out.println(u.getId().toString());
				System.out.println(u.getName());
			}
		}
	}
	
	
}
