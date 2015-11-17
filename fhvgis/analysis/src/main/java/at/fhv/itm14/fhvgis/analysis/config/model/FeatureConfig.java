package at.fhv.itm14.fhvgis.analysis.config.model;

public class FeatureConfig extends AbstractEnabableConfig {

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Feature [name=" + name + ", index=" + index + ", enabled=" + enabled + "]";
	}
}
