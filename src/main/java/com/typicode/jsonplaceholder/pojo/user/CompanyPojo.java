package com.typicode.jsonplaceholder.pojo.user;

/**
 *  This class provides Pojo implementation of Company  to use for serialization and de-serialization for User data
 */
public class CompanyPojo {
	
	private String name;
	private String catchPhrase;
	private String bs;
	
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
	 * @return the catchPhrase
	 */
	public String getCatchPhrase() {
		return catchPhrase;
	}
	/**
	 * @param catchPhrase the catchPhrase to set
	 */
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	/**
	 * @return the bs
	 */
	public String getBs() {
		return bs;
	}
	/**
	 * @param bs the bs to set
	 */
	public void setBs(String bs) {
		this.bs = bs;
	}


}
