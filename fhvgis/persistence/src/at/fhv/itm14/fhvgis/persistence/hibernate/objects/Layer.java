package at.fhv.itm14.fhvgis.persistence.hibernate.objects;
// default package
// Generated 29.10.2015 22:12:10 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Layer generated by hbm2java
 */
@Entity
@Table(name = "layer", schema = "topology", uniqueConstraints = @UniqueConstraint(columnNames = { "schema_name",
		"table_name", "feature_column" }) )
public class Layer implements java.io.Serializable {

	private LayerId id;
	private Topology topology;
	private String schemaName;
	private String tableName;
	private String featureColumn;
	private int featureType;
	private int level;
	private Integer childId;

	public Layer() {
	}

	public Layer(LayerId id, Topology topology, String schemaName, String tableName, String featureColumn,
			int featureType, int level) {
		this.id = id;
		this.topology = topology;
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.featureColumn = featureColumn;
		this.featureType = featureType;
		this.level = level;
	}

	public Layer(LayerId id, Topology topology, String schemaName, String tableName, String featureColumn,
			int featureType, int level, Integer childId) {
		this.id = id;
		this.topology = topology;
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.featureColumn = featureColumn;
		this.featureType = featureType;
		this.level = level;
		this.childId = childId;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "topologyId", column = @Column(name = "topology_id", nullable = false) ),
			@AttributeOverride(name = "layerId", column = @Column(name = "layer_id", nullable = false) ) })
	public LayerId getId() {
		return this.id;
	}

	public void setId(LayerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topology_id", nullable = false, insertable = false, updatable = false)
	public Topology getTopology() {
		return this.topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	@Column(name = "schema_name", nullable = false)
	public String getSchemaName() {
		return this.schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	@Column(name = "table_name", nullable = false)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "feature_column", nullable = false)
	public String getFeatureColumn() {
		return this.featureColumn;
	}

	public void setFeatureColumn(String featureColumn) {
		this.featureColumn = featureColumn;
	}

	@Column(name = "feature_type", nullable = false)
	public int getFeatureType() {
		return this.featureType;
	}

	public void setFeatureType(int featureType) {
		this.featureType = featureType;
	}

	@Column(name = "level", nullable = false)
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "child_id")
	public Integer getChildId() {
		return this.childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

}
