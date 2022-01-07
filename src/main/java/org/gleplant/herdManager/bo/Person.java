package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "person")
public class Person {

	private String names;
	@Column(name = "breeding_name")
	private String breedingName;
	@Column(name = "email_address")
	private String emailAddress;
	private String address;
	private String city;
	@Column(name = "zip_code")
	private Integer zipCode;
	private String country;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "home_number")
	private String homeNumber;
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;

	/**
	 * 
	 */
	public Person() {
	}

	/**
	 * @return the names
	 */
	@JsonGetter("names")
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the breedingName
	 */

	@JsonGetter("breedingName")
	public String getBreedingName() {
		return breedingName;
	}

	/**
	 * @param breedingName the breedingName to set
	 */
	public void setBreedingName(String breedingName) {
		this.breedingName = breedingName;
	}

	/**
	 * @return the emailAddress
	 */

	@JsonGetter("emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the address
	 */

	@JsonGetter("address")
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */

	@JsonGetter("city")
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
	@JsonGetter("zipCode")
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the country
	 */
	@JsonGetter("country")
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the mobileNumber
	 */
	@JsonGetter("mobileNumber")
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the homeNumber
	 */
	@JsonGetter("homeNumber")
	public String getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param homeNumber the homeNumber to set
	 */
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	/**
	 * @return the personId
	 */
	@JsonGetter("personId")
	public Integer getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Person [names=" + names + ", breedingName=" + breedingName + ", emailAddress=" + emailAddress
				+ ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country
				+ ", mobileNumber=" + mobileNumber + ", homeNumber=" + homeNumber + ", personId=" + personId + "]";
	}

}
