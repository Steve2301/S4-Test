package at.fhv.itm14.fhvgis.persistence;

public class DatabaseFacade implements IDatabaseFacade {

	private static DatabaseFacade _instance;
	
	private IDatabaseConnector _databaseConnector;
	private IDatabaseController _databaseController;
	private IDatabaseMapper _databaseMapper;
	
	private DatabaseFacade()
	{
		
	}
	
	public static DatabaseFacade getInstance()
	{
		if(_instance == null)
		{
			_instance = new DatabaseFacade();
		}
		return _instance;
	}
	
	public IDatabaseConnector getDatabaseConnector()
	{
		if(_databaseConnector == null)
		{
			_databaseConnector = DatabaseConnector.getInstance();
		}
		return _databaseConnector;
	}
	
	public IDatabaseController getDatabaseController()
	{
		if(_databaseController == null)
		{
			_databaseController = DatabaseController.getInstance();
		}
		return _databaseController;
	}
	
	public IDatabaseMapper getDatabaseMapper()
	{
		if(_databaseMapper == null)
		{
			_databaseMapper = DatabaseMapper.getInstance();
		}
		return _databaseMapper;
	}
	
}
