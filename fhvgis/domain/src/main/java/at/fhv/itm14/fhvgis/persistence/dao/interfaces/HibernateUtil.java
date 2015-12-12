package at.fhv.itm14.fhvgis.persistence.dao.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory _sessionFactory;

	static {
		try {
			_sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory createion failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return _sessionFactory;
	}

	public static byte[] hibernateCollectionPackage = "org.hibernate.collection".getBytes();

	public static void initializeObject(Object o, String insidePackageName) {
		Set<Object> seenObjects = new HashSet<Object>();
		initializeObject(o, seenObjects, insidePackageName.getBytes());
		seenObjects = null;
	}

	private static void initializeObject(Object o, Set<Object> seenObjects, byte[] insidePackageName) {

		seenObjects.add(o);

		Method[] methods = o.getClass().getMethods();
		for (Method method : methods) {

			String methodName = method.getName();
			
			if (methodName.length() < 3 || !"get".equals(methodName.substring(0, 3)))
				continue;
			
			if (method.getParameterTypes().length > 0)
				continue;

			int modifiers = method.getModifiers();

			if (!Modifier.isPublic(modifiers)) {
				continue;
			}

			if (Modifier.isStatic(modifiers)) {
				continue;
			}

			try {
				Object r = method.invoke(o);
				if (r == null)
					continue;

				if (seenObjects.contains(r))
					continue;
				

				if (!isIgnoredType(r.getClass()) && !r.getClass().isPrimitive() && !r.getClass().isArray()
						&& !r.getClass().isAnonymousClass()) {

					if (!isClassInPackage(r.getClass(), insidePackageName)
							&& !isClassInPackage(r.getClass(), hibernateCollectionPackage)) {
						continue;
					}
					Hibernate.initialize(r);
					initializeObject(r, seenObjects, insidePackageName);
				}

			} catch (InvocationTargetException e) {
				e.printStackTrace();
				return;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return;
			}
		}
//		if(o.getClass().equals(User.class)){
//			for(Device d : ((User)o).getDevices()){
//				initializeObject(d, "at.fhv.itm14.fhvgis.domain");
//			}
//		}
//		if(o.getClass().equals(Device.class)){
//			for(Track t : ((Device)o).getTracks()){
//				initializeObject(t, "at.fhv.itm14.fhvgis.domain");
//			}
//		}
//		if(o.getClass().equals(Track.class)){
//			for(Waypoint w : ((Track)o).getWaypoints()){
//				initializeObject(w, "at.fhv.itm14.fhvgis.domain");
//			}
//		}

	}

	private static final Set<Class<?>> IGNORED_TYPES = getIgnoredTypes();

	private static boolean isIgnoredType(Class<?> clazz) {
		return IGNORED_TYPES.contains(clazz);
	}

	private static Set<Class<?>> getIgnoredTypes() {
		Set<Class<?>> ret = new HashSet<Class<?>>();
		ret.add(Boolean.class);
		ret.add(Character.class);
		ret.add(Byte.class);
		ret.add(Short.class);
		ret.add(Integer.class);
		ret.add(Long.class);
		ret.add(Float.class);
		ret.add(Double.class);
		ret.add(Void.class);
		ret.add(String.class);
		ret.add(Class.class);
		ret.add(Package.class);
		return ret;
	}

	private static Boolean isClassInPackage(Class<?> clazz, byte[] insidePackageName) {

		Package p = clazz.getPackage();
		if (p == null)
			return null;

		byte[] packageName = p.getName().getBytes();

		int lenP = packageName.length;
		int lenI = insidePackageName.length;

		if (lenP < lenI)
			return false;

		for (int i = 0; i < lenI; i++) {
			if (packageName[i] != insidePackageName[i])
				return false;
		}

		return true;
	}

}
