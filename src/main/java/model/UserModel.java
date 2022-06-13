package model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private String name;
	private String pref;
	private String city;

	public UserModel() {
		//JavaBeans
	}

	public UserModel(String name, String pref, String city) {
		this.name = name;
		this.pref = pref;
		this.city = city;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return pref
	 */
	public String getPref() {
		return pref;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

}
