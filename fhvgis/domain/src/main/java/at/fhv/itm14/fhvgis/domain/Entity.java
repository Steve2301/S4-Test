package at.fhv.itm14.fhvgis.domain;

import java.util.UUID;

public abstract class Entity {

	protected UUID id;
	
	public Entity() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}
}
