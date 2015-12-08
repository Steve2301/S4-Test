package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.UUID;

public abstract class DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	protected UUID id;
	
	public DomainEntity() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}
}
