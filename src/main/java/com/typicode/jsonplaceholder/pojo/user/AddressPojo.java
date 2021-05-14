package com.typicode.jsonplaceholder.pojo.user;

/**
 *  This class provides Pojo implementation of Address to use for serialization and de-serialization for User data
 */
public class AddressPojo {
	
	private String street;
	private String suite;
	private String city;
	private String zipCode;
	private GeoPojo geo;
	
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the suite
	 */
	public String getSuite() {
		return suite;
	}
	/**
	 * @param suite the suite to set
	 */
	public void setSuite(String suite) {
		this.suite = suite;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the geoPojo
	 */
	public GeoPojo getGeoPojo() {
		return geo;
	}
	/**
	 * @param geoPojo the geoPojo to set
	 */
	public void setGeoPojo(GeoPojo geo) {
		this.geo = geo;
	}

	
}
