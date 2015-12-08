package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import at.fhv.itm14.fhvgis.domain.Device;
import at.fhv.itm14.fhvgis.domain.raw.RawMotionValue;

public interface IMotionValuesDao extends IGenericDao<RawMotionValue> {

	void deleteMotionValuesOfDevice(Device device);

}
