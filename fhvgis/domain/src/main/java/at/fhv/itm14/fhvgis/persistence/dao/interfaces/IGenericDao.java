package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.util.List;

import org.hibernate.Query;

public interface IGenericDao<T> {

	public void delete(T obj);
	
	public void persist(T obj);
	
	public void update(T obj);

	public List<T> findAll();

	public List<T> findMany(Query query);

	public T findOne(Query query);
	
	

}
