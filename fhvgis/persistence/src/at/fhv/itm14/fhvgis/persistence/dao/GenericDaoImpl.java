package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	public void save(T entity){
		Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
		hibernateSession.saveOrUpdate(entity);
	}
	
	public void delete(T entity){
		Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
		hibernateSession.delete(entity);
	}
	
	@SuppressWarnings("rawtypes")
	public List<T> findAll(Class clazz){
		Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        @SuppressWarnings("unchecked")
		List<T> list = query.list();
        return list;
	}
	
	public List<T> findMany(Query query){
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public T findOne(Query query){
		T t;
        t = (T) query.uniqueResult();
        return t;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Class<?> classname, long id ){
		  Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
	        T t = null;
	        t = (T) hibernateSession.get(classname, id);
	        return t;
	}
	
	


	
	
	
	

}
