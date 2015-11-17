package at.fhv.itm14.fhvgis.analysis.config.model;

public abstract class AbstractEnabableConfig {

	protected String name;
	protected boolean enabled;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Mode [name=" + name + ", enabled=" + enabled + "]";
	}
}
