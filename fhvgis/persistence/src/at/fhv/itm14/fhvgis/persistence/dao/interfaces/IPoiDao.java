package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.Poi;

public interface IPoiDao extends IGenericDao<Poi> {

	List<Poi> findPoisByPosition(Geometry position);

}
