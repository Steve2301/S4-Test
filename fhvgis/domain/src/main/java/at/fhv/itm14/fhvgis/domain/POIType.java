package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;

public class POIType extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private boolean isPrivate;
	
	public POIType(String name) {
		this(name, false);
	}
	
	public POIType(String name, boolean isPrivate) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
	}

	public String getName() {
		return name;
	}

	public boolean isPrivate() {
		return isPrivate;
	}
	
}
