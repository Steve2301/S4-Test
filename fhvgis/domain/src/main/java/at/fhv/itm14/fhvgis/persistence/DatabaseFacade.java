package at.fhv.itm14.fhvgis.persistence;

public class DatabaseFacade implements IDatabaseFacade{
	
	private static DatabaseFacade _instance;
	private IDatabaseController _databaseController;
	private IDatabaseDaoFacade _databaseDaoFacade;
	
	private DatabaseFacade() {

	}

	public static DatabaseFacade getInstance() {
		if (_instance == null) {
			_instance = new DatabaseFacade();
		}
		return _instance;
	}
	
	@Override
	public IDatabaseController getDatabaseController() {
		if (_databaseController == null) {
			_databaseController = DatabaseController.getInstance();
		}
		return _databaseController;
	}

	@Override
	public IDatabaseDaoFacade getDatabaseDaoFacade() {
		if(_databaseDaoFacade == null){
			_databaseDaoFacade = DatabaseDaoFacade.getInstance();
		}
		return _databaseDaoFacade;
	}


}
