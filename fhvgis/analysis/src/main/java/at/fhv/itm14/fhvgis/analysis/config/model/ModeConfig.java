package at.fhv.itm14.fhvgis.analysis.config.model;

public class ModeConfig extends AbstractEnabableConfig {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Mode [name=" + name + ", id=" + id + ", enabled=" + enabled + "]";
	}
}
