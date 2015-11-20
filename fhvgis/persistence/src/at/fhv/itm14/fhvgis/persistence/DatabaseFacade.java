package at.fhv.itm14.fhvgis.persistence;

public class DatabaseFacade implements IDatabaseFacade {

	private static DatabaseFacade _instance;

	private IDatabaseService _databaseService;
	private IDatabaseController _databaseController;
	private IDatabaseMapper _databaseMapper;

	private DatabaseFacade() {

	}

	public static DatabaseFacade getInstance() {
		if (_instance == null) {
			_instance = new DatabaseFacade();
		}
		return _instance;
	}

	public IDatabaseService getDatabaseConnector() {
		if (_databaseService == null) {
			_databaseService = DatabaseService.getInstance();
		}
		return _databaseService;
	}

	public IDatabaseController getDatabaseController() {
		if (_databaseController == null) {
			_databaseController = DatabaseController.getInstance();
		}
		return _databaseController;
	}

	public IDatabaseMapper getDatabaseMapper() {
		if (_databaseMapper == null) {
			_databaseMapper = DatabaseMapper.getInstance();
		}
		return _databaseMapper;
	}

}
