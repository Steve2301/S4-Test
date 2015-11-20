package at.fhv.itm14.fhvgis.persistence;

public interface IDatabaseFacade {
	public IDatabaseController getDatabaseController();
	public IDatabaseService getDatabaseService();
	public IDatabaseMapper getDatabaseMapper();
}
