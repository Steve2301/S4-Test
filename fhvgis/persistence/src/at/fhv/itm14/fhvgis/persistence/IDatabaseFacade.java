package at.fhv.itm14.fhvgis.persistence;

public interface IDatabaseFacade {
	public IDatabaseController getDatabaseController();
	public IDatabaseService getDatabaseConnector();
	public IDatabaseMapper getDatabaseMapper();
}
