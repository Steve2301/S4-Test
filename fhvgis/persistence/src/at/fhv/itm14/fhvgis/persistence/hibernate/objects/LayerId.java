package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 29.10.2015 22:12:10 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LayerId generated by hbm2java
 */
@Embeddable
public class LayerId implements java.io.Serializable {

	private int topologyId;
	private int layerId;

	public LayerId() {
	}

	public LayerId(int topologyId, int layerId) {
		this.topologyId = topologyId;
		this.layerId = layerId;
	}

	@Column(name = "topology_id", nullable = false)
	public int getTopologyId() {
		return this.topologyId;
	}

	public void setTopologyId(int topologyId) {
		this.topologyId = topologyId;
	}

	@Column(name = "layer_id", nullable = false)
	public int getLayerId() {
		return this.layerId;
	}

	public void setLayerId(int layerId) {
		this.layerId = layerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LayerId))
			return false;
		LayerId castOther = (LayerId) other;

		return (this.getTopologyId() == castOther.getTopologyId()) && (this.getLayerId() == castOther.getLayerId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTopologyId();
		result = 37 * result + this.getLayerId();
		return result;
	}

}
