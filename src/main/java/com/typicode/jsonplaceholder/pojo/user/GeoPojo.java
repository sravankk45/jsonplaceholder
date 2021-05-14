package com.typicode.jsonplaceholder.pojo.user;

/**
 *  This class provides Pojo implementation of Geo data to use for serialization and de-serialization for user data
 */
public class GeoPojo {
	
	private String lat;
	private String lng;
	
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}


}
