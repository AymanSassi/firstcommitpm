package com.am.util;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maher
 */
public class ClassInfo {

	public static void invokeSetter(Object record, String property, Object newValue) {
		String pLeft, pRight;
		if (property.contains(".")) {
			pLeft = property.substring(0, property.indexOf("."));
			pRight = property.substring(property.indexOf(".") + 1);
		} else {
			pLeft = null;
			pRight = property;
		}
		if (pLeft == null || pLeft.isEmpty()) {
			String methodName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
			// Class<?>[] parameterTypes = new Class<?>[]{newValue.getClass()};
			Method m = null;
			for (Method i : record.getClass().getMethods()) {
				if (i.getName().equals(methodName)) {
					m = i;
					break;
				}
			}
			try {
				if (m == null) {
					Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, "Aucune fonction de ce type");
				} else // Method m = record.getClass().getMethod(methodName, parameterTypes);
				// record.getClass().getm
				{
					m.invoke(record, newValue);
				}

			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException ex) {
				Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			Object resultat = invokeGetter(record, pLeft);
			invokeSetter(resultat, pRight, newValue);
		}

	}

	public static Object invokeGetter(Object record, String property) {
		/*
		 * if (record == null) { return null; }
		 */
		String pLeft, pRight;
		Object retour = null;
		if (property.contains(".")) {
			pLeft = property.substring(0, property.indexOf("."));
			pRight = property.substring(property.indexOf(".") + 1);
		} else {
			pLeft = null;
			pRight = property;
		}
		if (pLeft == null || pLeft.isEmpty()) {
			String methodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
			Method m = null;
			for (Method i : record.getClass().getMethods()) {
				if (i.getName().equals(methodName)) {
					m = i;
					break;
				}
			}
			try {
				if (m == null) {
					Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, "Aucune fonction de ce type");
				} else // Class<?>[] parameterTypes = new Class<?>[]{};
				// try {
				// Method m = record.getClass().getMethod(methodName, parameterTypes);
				{
					retour = m.invoke(record);
				}
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException ex) {
				Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			retour = invokeGetter(record, pLeft);
			return invokeGetter(retour, pRight);
		}
		// System.out.println("getter "+property+"="+retour);
		return retour;
	}

	public static Method getSetter(Object record, String property) {
		String pLeft, pRight;
		Method m = null;
		if (property.contains(".")) {
			pLeft = property.substring(0, property.indexOf("."));
			pRight = property.substring(property.indexOf(".") + 1);
		} else {
			pLeft = null;
			pRight = property;
		}
		if (pLeft == null || pLeft.isEmpty()) {
			String methodName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
			Class<?>[] parameterTypes = new Class<?>[] {};// .getClass()};
			try {
				m = record.getClass().getMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException | SecurityException | IllegalArgumentException ex) {
				Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			Object resultat = invokeGetter(record, pLeft);
			m = getSetter(resultat, pRight);
		}
		return m;
	}

	public static Method getGetter(Object record, String property) {
		if (record == null) {
			return null;
		}
		String pLeft, pRight;
		Object retour = null;
		Method m = null;
		if (property.contains(".")) {
			pLeft = property.substring(0, property.indexOf("."));
			pRight = property.substring(property.indexOf(".") + 1);
		} else {
			pLeft = null;
			pRight = property;
		}
		if (pLeft == null || pLeft.isEmpty()) {
			String methodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
			Class<?>[] parameterTypes = new Class<?>[] {};

			try {
				m = record.getClass().getMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException | SecurityException | IllegalArgumentException ex) {
				Logger.getLogger(record.getClass().getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			retour = invokeGetter(record, pLeft);
			m = getGetter(retour, pRight);
		}
		return m;
	}

	/**
	 *
	 *
	 * Retourne la classe passsée en paramétre exemple public class BlcMsav extends
	 * DataBlock<Msav> getClassInArgument(BlcMsav) return Msav
	 *
	 *
	 * @param class_
	 * @return
	 */
	public static Class getClassInArgument(Class class_) {
		ParameterizedType ab = (ParameterizedType) class_.getGenericSuperclass();
		if (ab.getActualTypeArguments() != null && ab.getActualTypeArguments().length > 0) {
			return (Class) ab.getActualTypeArguments()[0];
		}

		return null;
		/*
		 * Type type = class_.getGenericSuperclass(); while (!(type instanceof
		 * ParameterizedType) || ((ParameterizedType) type).getRawType() != class_) { if
		 * (type instanceof ParameterizedType) { type = ((Class<?>) ((ParameterizedType)
		 * type).getRawType()).getGenericSuperclass(); } else { type = ((Class<?>)
		 * type).getGenericSuperclass(); } } return (Class<?>) ((ParameterizedType)
		 * type).getActualTypeArguments()[0];
		 */
	}

	public static Map<String, Object> getFieldValues(Object record, boolean onlyNotNull) {
		Map<String, Object> fieldValues = new HashMap<>();
		Object o;
		if (record.getClass().getDeclaredFields().length > 0) {
			for (Field f : record.getClass().getDeclaredFields()) {
				Method f1 = getGetter(record, f.getName());
				// System.out.println("F1=" + f1.getName());
				if (f1 != null) {
					o = invokeGetter(record, f.getName());
					if (o instanceof Integer || o instanceof String || o instanceof Date || o instanceof Double
							|| o instanceof Long) {
						if (!onlyNotNull || o != null) {
							// System.out.println("FOK=" + f1.getName());
							if (onlyNotNull && o != null && o instanceof String && ((String) o).isEmpty()) {
							} else
								fieldValues.put(f.getName(), o);
						}

					}
				}
			}
		}
		return fieldValues;
	}

}
