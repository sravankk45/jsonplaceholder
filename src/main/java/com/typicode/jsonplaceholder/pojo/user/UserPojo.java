package com.typicode.jsonplaceholder.pojo.user;

public class UserPojo {

	private String id;
	private String name;
	private String userName;
	private String email;
	private AddressPojo address;
	private GeoPojo geoPojo;
	private String phone;
	private String website;
	private CompanyPojo company;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public AddressPojo getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressPojo address) {
		this.address = address;
	}
	/**
	 * @return the geoPojo
	 */
	public GeoPojo getGeoPojo() {
		return geoPojo;
	}
	/**
	 * @param geoPojo the geoPojo to set
	 */
	public void setGeoPojo(GeoPojo geoPojo) {
		this.geoPojo = geoPojo;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the company
	 */
	public CompanyPojo getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(CompanyPojo company) {
		this.company = company;
	}

}
