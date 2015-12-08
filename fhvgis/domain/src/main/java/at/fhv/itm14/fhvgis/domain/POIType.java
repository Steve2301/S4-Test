package at.fhv.itm14.fhvgis.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "poi_type", schema = "public")
public class POIType extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private boolean isPrivate;
	private List<POI> pois;
	
	public POIType(){
		
	}

	public POIType(String name) {
		this(name, false);
	}

	public POIType(String name, boolean isPrivate) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
	}

	public POIType(UUID id, String name, boolean isPrivate) {
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "private", nullable = false)
	public boolean isPrivate() {
		return isPrivate;
	}
	
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poiType", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<POI> getPois() {
		return this.pois;
	}

	public void setPois(List<POI> pois) {
		this.pois = pois;
	}

}
