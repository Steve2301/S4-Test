package at.fhv.itm14.fhvgis.domain;

public class POI extends Entity {
	
	private String name;
	private POIType poiType;
	
	public POI(String name, POIType poiType) {
		super();
		this.name = name;
		this.poiType = poiType;
	}

	public String getName() {
		return name;
	}

	public POIType getPoiType() {
		return poiType;
	}

}
