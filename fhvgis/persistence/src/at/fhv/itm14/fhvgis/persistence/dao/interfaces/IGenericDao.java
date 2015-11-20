package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import org.hibernate.Query;

public interface IGenericDao<T> {

	public void delete(T obj);

	public void save(T obj);

	public List<T> findAll(Class<?> classname);

	public List<T> findMany(Query query);

	public T findOne(Query query);

	public T findById(Class<?> classname, long id);

}
