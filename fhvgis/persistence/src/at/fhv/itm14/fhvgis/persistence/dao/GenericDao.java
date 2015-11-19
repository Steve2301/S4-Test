package at.fhv.itm14.fhvgis.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import at.fhv.itm14.fhvgis.persistence.hibernate.objects.HibernateUtil;

public abstract class GenericDao<T> implements IGenericDao<T> {

	public void save(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll(Class clazz) {
		List<T> rv = new LinkedList<T>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<T> rs = (List<T>) session.createQuery("from " + clazz.getName()).list();
			rv = rs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rv;
	}

	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> rv = new LinkedList<T>();
		rv = query.list();
		return rv;
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findById(Class<?> classname, long id) {
		Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
		T t = null;
		t = (T) hibernateSession.get(classname, id);
		return t;
	}
}
