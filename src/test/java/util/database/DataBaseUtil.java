package util.database;

import util.file.JSONController;

import java.util.ArrayList;

/**
 * abstract class providing template for specified json util class
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public abstract class DataBaseUtil {
	protected final JSONController controller;

	/**
	 * <p>Constructor of abstract class is always overridden,
	 * and cannot be called since abstract class cannot be instantiated.</p>
	 * @param uri path to json file
	 */
	protected DataBaseUtil(String uri) {
		this.controller = new JSONController(uri);
	}

	/**
	 * Get requested object by its ID
	 * @param id object's ID
	 * @return object
	 */
	public abstract Object get(String id);

	/**
	 * Add object to json
	 * @param o object
	 */
	public abstract void add(Object o);

	/**
	 * Clear the json file
	 */
	public void removeAll() {
		controller.writeArray(new ArrayList<>());
	}
}
