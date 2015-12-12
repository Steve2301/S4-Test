package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.persistence.dao.interfaces.IGenericDao;
import at.fhv.itm14.fhvgis.persistence.utils.HibernateUtil;

public abstract class GenericDao<T> implements IGenericDao<T> {
	
	private Class< T > clazz;
	
	public final void setClazz( Class< T > clazz ){
	      this.clazz = clazz;
	}

	@Override
	public void delete(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void persist(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void update(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Override
	public T find(UUID id) {
		T entity = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			entity = session.load(clazz, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> rs = null;
		try {
			session.beginTransaction();
			rs = (List<T>) session.createQuery("from " + clazz.getName()).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen())
			session.close();
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findMany(Query query) {
		List<T> rv = new LinkedList<T>();
		rv = query.list();
		for(T entity : rv){
			HibernateUtil.initializeObject(entity, "at.fhv.itm14.fhvgis.domain");
		}
		return rv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		HibernateUtil.initializeObject(t, "at.fhv.itm14.fhvgis.domain");
		return t;
	}

	
	protected final Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	

}
